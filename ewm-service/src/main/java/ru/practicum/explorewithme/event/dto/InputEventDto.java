package ru.practicum.explorewithme.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InputEventDto {

  private String annotation;
  private Integer category;
  private String description;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private LocalDateTime eventDate;
  private LocationDto location;
  private Boolean paid;
  private Integer participantLimit;
  private Boolean requestModeration;
  private String title;
}