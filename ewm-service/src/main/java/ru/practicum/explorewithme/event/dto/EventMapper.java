package ru.practicum.explorewithme.event.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.explorewithme.event.model.EventEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventMapper {

  public static OutputEventDto toDto(EventEntity eventEntity) {
    return OutputEventDto.builder()
        .id(eventEntity.getId())
        .annotation(eventEntity.getAnnotation())
        .description(eventEntity.getDescription())
        .eventDate(eventEntity.getEventDate())
        .paid(eventEntity.getPaid())
        .participantLimit(eventEntity.getParticipantLimit())
        .requestModeration(eventEntity.getRequestModeration())
        .title(eventEntity.getTitle())
        .createdOn(eventEntity.getCreatedOn())
        .location(new LocationDto(eventEntity.getLocation().getLat(), eventEntity.getLocation().getLon()))
        .build();
  }

  public static EventEntity toEntity(InputEventDto inputEventDto) {
    return EventEntity.builder()
        .annotation(inputEventDto.getAnnotation())
        .description(inputEventDto.getDescription())
        .eventDate(inputEventDto.getEventDate())
        .paid(inputEventDto.getPaid())
        .participantLimit(inputEventDto.getParticipantLimit())
        .requestModeration(inputEventDto.getRequestModeration())
        .title(inputEventDto.getTitle())
        .createdOn(LocalDateTime.now())
        .location(inputEventDto.getLocation())
        .build();
  }
}
