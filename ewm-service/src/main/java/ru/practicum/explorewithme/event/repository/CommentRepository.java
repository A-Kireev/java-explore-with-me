package ru.practicum.explorewithme.event.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.explorewithme.event.model.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

  List<CommentEntity> findAllByEventId(long eventId);
}
