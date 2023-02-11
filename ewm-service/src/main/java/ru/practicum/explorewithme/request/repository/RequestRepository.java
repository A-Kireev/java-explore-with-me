package ru.practicum.explorewithme.request.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.explorewithme.request.model.RequestEntity;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

  List<RequestEntity> findAllByUserId(long userId);

  RequestEntity findByUserIdAndEventId(long userId, long eventId);

  List<RequestEntity> findAllByUserIdAndEventId(long userId, long eventId);

  List<RequestEntity> findAllByIdIn(List<Long> eventIds);
}
