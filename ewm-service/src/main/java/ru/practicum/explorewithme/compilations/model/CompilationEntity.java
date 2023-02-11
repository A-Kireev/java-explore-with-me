package ru.practicum.explorewithme.compilations.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.explorewithme.event.model.EventEntity;

@Getter
@Setter
@Builder
@Entity
@Table(name = "compilations")
@NoArgsConstructor
@AllArgsConstructor
public class CompilationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Boolean pinned;
  private String title;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "compilation_event",
      joinColumns = @JoinColumn(name = "compilation_id"),
      inverseJoinColumns = @JoinColumn(name = "event_id"))
  private List<EventEntity> events;
}
