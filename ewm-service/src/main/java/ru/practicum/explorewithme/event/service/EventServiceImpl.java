package ru.practicum.explorewithme.event.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.event.dto.InputEventDto;
import ru.practicum.explorewithme.event.dto.OutputEventDto;
import ru.practicum.explorewithme.event.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  @Override
  public List<OutputEventDto> getEvents(long userId, int from, int size) {
    return null;
  }

  @Override
  public OutputEventDto createEvent(long userId, InputEventDto inputEventDto) {
    return null;
  }

  @Override
  public OutputEventDto getEvent(long userId, long eventId) {
    return null;
  }

  @Override
  public OutputEventDto updateEvent(long userId, long eventId, InputEventDto inputEventDto) {
    return null;
  }

  @Override
  public List<OutputEventDto> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size) {
    return null;
  }

  @Override
  public OutputEventDto updateEvent(long eventId, InputEventDto inputEventDto) {
    return null;
  }
}
