package ru.practicum.explorewithme.compilations.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.compilations.dto.CompilationCreationDto;
import ru.practicum.explorewithme.compilations.dto.CompilationDto;
import ru.practicum.explorewithme.compilations.repository.CompilationRepository;

@Service
@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {

  private final CompilationRepository compilationRepository;

  @Override
  public List<CompilationDto> getCompilations(Boolean pinned, int from, int size) {
    return null;
  }

  @Override
  public CompilationDto getCompilation(long compilationId) {
    return null;
  }

  @Override
  public CompilationDto createCompilation(CompilationCreationDto compilationCreationDto) {
    return null;
  }

  @Override
  public void deleteCompilation(long compilationId) {

  }

  @Override
  public CompilationDto updateCompilation(long compilationId, CompilationCreationDto compilationCreationDto) {
    return null;
  }
}
