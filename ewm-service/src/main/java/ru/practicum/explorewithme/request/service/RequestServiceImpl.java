package ru.practicum.explorewithme.request.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.event.model.EventEntity;
import ru.practicum.explorewithme.request.dto.ChangeRequestStatusDto;
import ru.practicum.explorewithme.request.dto.RequestDto;
import ru.practicum.explorewithme.request.dto.RequestMapper;
import ru.practicum.explorewithme.request.dto.RequestStatusDto;
import ru.practicum.explorewithme.request.dto.RequestStatusesDto;
import ru.practicum.explorewithme.request.model.RequestEntity;
import ru.practicum.explorewithme.request.repository.RequestRepository;
import ru.practicum.explorewithme.user.model.User;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

  private final RequestRepository requestRepository;

  @Override
  public List<RequestDto> getRequests(long userId) {
    return requestRepository.findAllByUserId(userId).stream()
        .map(RequestMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public RequestDto createRequest(long userId, long eventId) {
    var event = new EventEntity();
    event.setId(eventId);

    var user = new User();
    user.setId(userId);

    var request = RequestEntity.builder()
        .event(event)
        .user(user)
        .createdOn(LocalDateTime.now())
        .status(RequestStatusDto.PENDING)
        .build();

    requestRepository.save(request);
    return RequestMapper.toDto(request);
  }

  @Override
  public RequestDto cancelRequest(long userId, long requestId) {
    var request = requestRepository.findById(requestId).orElseThrow(NoSuchElementException::new);
    request.setStatus(RequestStatusDto.CANCELED);
    requestRepository.save(request);

    return RequestMapper.toDto(request);
  }

  @Override
  public List<RequestDto> getEventRequests(long userId, long eventId) {
    return requestRepository.findAllByUserIdAndEventId(userId, eventId).stream()
        .map(RequestMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public RequestStatusesDto changeEventRequests(long userId, ChangeRequestStatusDto changeRequestStatusDto) {
    var requests = requestRepository.findAllByIdIn(changeRequestStatusDto.getRequestIds());
    requests.forEach(s -> {
      s.setStatus(changeRequestStatusDto.getStatus());
      requestRepository.save(s);
    });

    var updatedRequests = new RequestStatusesDto();
    if (changeRequestStatusDto.getStatus() == RequestStatusDto.CONFIRMED) {
      updatedRequests.setConfirmedRequests(requests.stream().map(RequestMapper::toDto).collect(Collectors.toList()));
    } else {
      updatedRequests.setRejectedRequests(requests.stream().map(RequestMapper::toDto).collect(Collectors.toList()));
    }

    return updatedRequests;
  }
}
