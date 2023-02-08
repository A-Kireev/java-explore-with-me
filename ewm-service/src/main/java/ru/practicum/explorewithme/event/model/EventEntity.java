package ru.practicum.explorewithme.event.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.explorewithme.category.model.CategoryEntity;

@Getter
@Setter
@Builder
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String annotation;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private CategoryEntity category;
  private String description;
  private LocalDateTime eventDate;
  private String location;
  private Boolean paid;
  private Integer participantLimit;
  private Boolean requestModeration;
  private String title;
}
