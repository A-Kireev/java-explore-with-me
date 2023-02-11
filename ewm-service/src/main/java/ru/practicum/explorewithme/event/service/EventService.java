package ru.practicum.explorewithme.event.service;

import java.util.List;
import ru.practicum.explorewithme.event.dto.ChangeEventStateDto;
import ru.practicum.explorewithme.event.dto.InputEventDto;
import ru.practicum.explorewithme.event.dto.OutputEventDto;

public interface EventService {

  List<OutputEventDto> getEvents(long userId, int from, int size);

  OutputEventDto createEvent(long userId, InputEventDto inputEventDto);

  OutputEventDto getEvent(long userId, long eventId);

  OutputEventDto updateEvent(long userId, long eventId, InputEventDto inputEventDto);

  List<OutputEventDto> searchEvents(List<Long> users, List<String> states, List<Integer> categories, String rangeStart,
      String rangeEnd, int from, int size);

  OutputEventDto updateEvent(long eventId, InputEventDto inputEventDto);
}
