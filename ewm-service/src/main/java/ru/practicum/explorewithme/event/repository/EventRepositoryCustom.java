package ru.practicum.explorewithme.event.repository;

import java.util.List;
import ru.practicum.explorewithme.event.model.EventEntity;

public interface EventRepositoryCustom {

  List<EventEntity> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size);
}
