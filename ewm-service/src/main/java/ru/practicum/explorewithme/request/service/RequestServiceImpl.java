package ru.practicum.explorewithme.request.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.request.dto.ChangeRequestStatusDto;
import ru.practicum.explorewithme.request.dto.RequestDto;
import ru.practicum.explorewithme.request.dto.RequestStatusesDto;
import ru.practicum.explorewithme.request.repository.RequestRepository;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

  private final RequestRepository requestRepository;

  @Override
  public List<RequestDto> getRequests(long userId) {
    return null;
  }

  @Override
  public RequestDto createRequest(long userId, long eventId) {
    return null;
  }

  @Override
  public RequestDto cancelRequest(long userId, long eventId) {
    return null;
  }

  @Override
  public List<RequestDto> getEventRequests(long userId, long eventId) {
    return null;
  }

  @Override
  public RequestStatusesDto changeEventRequests(long userId, ChangeRequestStatusDto changeRequestStatusDto) {
    return null;
  }
}
