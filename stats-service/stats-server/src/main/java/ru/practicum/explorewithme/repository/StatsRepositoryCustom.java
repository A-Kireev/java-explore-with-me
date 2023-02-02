package ru.practicum.explorewithme.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.explorewithme.HitStatDto;
import ru.practicum.explorewithme.model.StatsEntity;

public interface StatsRepositoryCustom {

  List<HitStatDto> getStats(String start, String end, List<String> uris, Boolean unique);
}
