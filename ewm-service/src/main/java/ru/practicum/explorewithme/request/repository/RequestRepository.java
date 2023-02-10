package ru.practicum.explorewithme.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.explorewithme.request.model.RequestEntity;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

}
