package ru.practicum.explorewithme.event.service;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.event.dto.ChangeEventStateDto;
import ru.practicum.explorewithme.event.dto.EventMapper;
import ru.practicum.explorewithme.event.dto.EventStatus;
import ru.practicum.explorewithme.event.dto.InputEventDto;
import ru.practicum.explorewithme.event.dto.OutputEventDto;
import ru.practicum.explorewithme.event.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  @Override
  public List<OutputEventDto> getEvents(long userId, int from, int size) {
    var sort = Sort.by("id").ascending();
    var pageable = PageRequest.of(from / size, size, sort);
    return eventRepository.findAll(pageable).map(EventMapper::toDto).toList();
  }

  @Override
  public OutputEventDto createEvent(long userId, InputEventDto inputEventDto) {
    var event = EventMapper.toEntity(inputEventDto);
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
    eventRepository.save(EventMapper.toEntity(inputEventDto));
    return EventMapper.toDto(event);
  }

  @Override
  public List<OutputEventDto> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size) {
    return eventRepository.searchEvents(users, states, categories, rangeStart, rangeEnd, from, size);
  }

  @Override
  public OutputEventDto updateEvent(long eventId, ChangeEventStateDto changeEventStateDto) {
    return new OutputEventDto();
  }
}
