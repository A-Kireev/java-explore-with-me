package ru.practicum.explorewithme.event.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventDto {

  private String annotation;
  private Integer category;
  private String description;
  private LocalDateTime eventDate;
  private LocationDto location;
  private Boolean paid;
  private Integer participantLimit;
  private Boolean requestModeration;
  private String title;
}
