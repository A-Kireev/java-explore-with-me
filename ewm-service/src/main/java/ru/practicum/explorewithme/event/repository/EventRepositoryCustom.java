package ru.practicum.explorewithme.event.repository;

import java.util.List;
import ru.practicum.explorewithme.event.dto.OutputEventDto;

public interface EventRepositoryCustom {

  List<OutputEventDto> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size);
}
