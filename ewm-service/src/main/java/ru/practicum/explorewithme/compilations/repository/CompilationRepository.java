package ru.practicum.explorewithme.compilations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.explorewithme.compilations.model.CompilationEntity;

public interface CompilationRepository extends JpaRepository<CompilationEntity, Long> {

}
