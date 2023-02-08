package ru.practicum.explorewithme.event.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.explorewithme.category.model.CategoryEntity;
import ru.practicum.explorewithme.user.model.User;

@Getter
@Setter
@Builder
public class OutputEventDto {

  private Long id;
  private String annotation;
  private User initiator;
  private CategoryEntity category;
  private String description;
  private LocalDateTime eventDate;
  private LocationDto location;
  private Boolean paid;
  private Integer participantLimit;
  private Boolean requestModeration;
  private String title;
  private EventStatus state;
  private Long views;
}
