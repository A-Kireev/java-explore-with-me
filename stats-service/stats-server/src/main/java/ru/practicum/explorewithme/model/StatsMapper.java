package ru.practicum.explorewithme.model;

import ru.practicum.explorewithme.HitDto;

public class StatsMapper {

  public StatsEntity toEntity(HitDto hitDto) {
    return StatsEntity.builder()
        .app(hitDto.getApp())
        .uri(hitDto.getUri())
        .ip(hitDto.getIp())
        .timestamp(hitDto.getTimestamp())
        .build();
  }
}
