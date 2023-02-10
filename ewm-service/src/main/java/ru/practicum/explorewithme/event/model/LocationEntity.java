package ru.practicum.explorewithme.event.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "locations")
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String lat;
  private String lon;

  public LocationEntity(String lat, String lon) {
    this.lat = lat;
    this.lon = lon;
  }
}
