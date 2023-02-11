package ru.practicum.explorewithme.event.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.category.model.CategoryEntity;
import ru.practicum.explorewithme.event.dto.EventMapper;
import ru.practicum.explorewithme.event.dto.EventStatus;
import ru.practicum.explorewithme.event.dto.FullEventInfo;
import ru.practicum.explorewithme.event.dto.InputEventDto;
import ru.practicum.explorewithme.event.dto.OutputEventDto;
import ru.practicum.explorewithme.event.dto.StateAction;
import ru.practicum.explorewithme.event.repository.EventRepository;
import ru.practicum.explorewithme.request.repository.RequestRepository;
import ru.practicum.explorewithme.user.model.User;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;
  private final RequestRepository requestRepository;

  @Override
  public List<OutputEventDto> getEvents(long userId, int from, int size) {
    var sort = Sort.by("id").ascending();
    var pageable = PageRequest.of(from / size, size, sort);
    return eventRepository.findAll(pageable).map(EventMapper::toDto).toList();
  }

  @Override
  public OutputEventDto createEvent(long userId, InputEventDto inputEventDto) {
    var event = EventMapper.toEntity(inputEventDto);
    event.setInitiator(new User(userId));
    event.setCategory(new CategoryEntity(Long.valueOf(inputEventDto.getCategory())));
    event.setState(EventStatus.PENDING);
    eventRepository.save(event);
    return EventMapper.toDto(event);
  }

  @Override
  public OutputEventDto getEvent(long userId, long eventId) {
    var event = eventRepository.findById(eventId).orElseThrow(NoSuchElementException::new);
    return EventMapper.toDto(event);
  }

  @Override
  public OutputEventDto updateEvent(long userId, long eventId, InputEventDto inputEventDto) {
    var event = eventRepository.findById(eventId).orElseThrow(NoSuchElementException::new);
    var updatedEvent = EventMapper.toEntity(inputEventDto, event);
    eventRepository.save(updatedEvent);
    return EventMapper.toDto(updatedEvent);
  }

  @Override
  public List<FullEventInfo> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size) {
    return eventRepository.searchEvents(users, states, categories, rangeStart, rangeEnd, from, size).stream()
        .map(s -> EventMapper.toFullDto(s, requestRepository.countByEventId(s.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public OutputEventDto updateEvent(long eventId, InputEventDto inputEventDto) {
    var event = eventRepository.findById(eventId).orElseThrow(NoSuchElementException::new);
    var updatedEvent = EventMapper.toEntity(inputEventDto, event);

    var newState = inputEventDto.getStateAction() == StateAction.PUBLISH_EVENT
        ? EventStatus.PUBLISHED
        : EventStatus.CANCELED;
    updatedEvent.setState(newState);
    updatedEvent.setPublishedOn(newState == EventStatus.PUBLISHED ? LocalDateTime.now() : null);

    eventRepository.save(updatedEvent);
    return EventMapper.toDto(updatedEvent);
  }

  @Override
  public List<FullEventInfo> getFullEventInfo(String text, List<Integer> categories, Boolean paid, String rangeStart,
      String rangeEnd, Boolean onlyAvailable, String sort, int from, int size) {
    return eventRepository.searchEvents(text, categories, paid, rangeStart, rangeEnd, onlyAvailable, sort, from, size)
        .stream()
        .map(s -> EventMapper.toFullDto(s, requestRepository.countByEventId(s.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public FullEventInfo getFullEventInfo(long eventId) {
    return EventMapper.toFullDto(eventRepository.findById(eventId).orElseThrow(NoSuchElementException::new),
        requestRepository.countByEventId(eventId));
  }
}
