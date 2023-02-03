package ru.practicum.explorewithme.model;

import java.sql.Timestamp;
import ru.practicum.explorewithme.HitDto;

public class StatsMapper {

  public StatsEntity toEntity(HitDto hitDto) {
    return StatsEntity.builder()
        .app(hitDto.getApp())
        .uri(hitDto.getUri())
        .ip(hitDto.getIp())
        .timestamp(Timestamp.valueOf(hitDto.getTimestamp()))
        .build();
  }
}
