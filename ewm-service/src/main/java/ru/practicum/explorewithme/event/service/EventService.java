package ru.practicum.explorewithme.event.service;

import java.util.List;
import ru.practicum.explorewithme.event.dto.FullEventInfo;
import ru.practicum.explorewithme.event.dto.InputEventDto;
import ru.practicum.explorewithme.event.dto.OutputEventDto;
import ru.practicum.explorewithme.event.dto.comment.CommentDto;

public interface EventService {

  List<OutputEventDto> getEvents(long userId, int from, int size);

  OutputEventDto createEvent(long userId, InputEventDto inputEventDto);

  OutputEventDto getEvent(long userId, long eventId);

  OutputEventDto updateEvent(long userId, long eventId, InputEventDto inputEventDto);

  List<FullEventInfo> searchEvents(List<Long> users, List<String> states, List<Integer> categories, String rangeStart,
      String rangeEnd, int from, int size);

  OutputEventDto updateEvent(long eventId, InputEventDto inputEventDto);

  List<FullEventInfo> getFullEventInfo(String text, List<Integer> categories, Boolean paid, String rangeStart,
      String rangeEnd, Boolean onlyAvailable, String sort, int from, int size);

  FullEventInfo getFullEventInfo(long eventId);

  CommentDto addComment(long userId, long eventId, CommentDto commentDto);

  CommentDto updateComment(long userId, long eventId, long commentId, CommentDto commentDto);

  void deleteComment(long userId, long eventId, long commentId);

  CommentDto updateCommentByAdmin(long eventId, long commentId, CommentDto commentDto);

  void deleteCommentByAdmin(long eventId, long commentId);
}
