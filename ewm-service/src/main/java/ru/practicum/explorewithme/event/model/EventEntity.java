package ru.practicum.explorewithme.event.model;

import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import ru.practicum.explorewithme.event.dto.EventStatus;
import ru.practicum.explorewithme.event.dto.LocationDto;
import ru.practicum.explorewithme.user.model.User;

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
  @ManyToOne
  @JoinColumn(name = "initiator_id", referencedColumnName = "id")
  private User initiator;
  private String annotation;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private CategoryEntity category;
  private String description;
  private LocalDateTime eventDate;
  @Embedded
  @AttributeOverride(name = "lat", column = @Column(name = "lat"))
  @AttributeOverride(name = "lon", column = @Column(name = "lon"))
  private LocationDto location;
  private Boolean paid;
  private Integer participantLimit;
  private Boolean requestModeration;
  private String title;
  @Enumerated(EnumType.STRING)
  private EventStatus state;
  private LocalDateTime createdOn;
  private LocalDateTime publishedOn;
}
