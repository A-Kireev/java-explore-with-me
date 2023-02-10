package ru.practicum.explorewithme.request;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.explorewithme.request.dto.ChangeRequestStatusDto;
import ru.practicum.explorewithme.request.dto.RequestDto;
import ru.practicum.explorewithme.request.dto.RequestStatusesDto;
import ru.practicum.explorewithme.request.service.RequestService;

@RestController
@RequiredArgsConstructor
public class RequestController {

  private final RequestService requestService;

  @GetMapping("/users/{userId}/requests")
  public List<RequestDto> getRequests(@PathVariable long userId) {
    return requestService.getRequests(userId);
  }

  @PostMapping("/users/{userId}/requests")
  public RequestDto createRequest(@PathVariable long userId, @RequestParam long eventId) {
    return requestService.createRequest(userId, eventId);
  }

  @PatchMapping("/users/{userId}/requests/{requestId}/cancel")
  public RequestDto cancelRequest(@PathVariable long userId, @PathVariable long eventId) {
    return requestService.cancelRequest(userId, eventId);
  }

  @GetMapping("/users/{userId}/events/{eventId}/requests")
  public List<RequestDto> getEventRequests(@PathVariable long userId, @PathVariable long eventId) {
    return requestService.getEventRequests(userId, eventId);
  }

  @PatchMapping("/users/{userId}/events/{eventId}/requests")
  public RequestStatusesDto changeEventRequests(@PathVariable long userId,
      @RequestBody ChangeRequestStatusDto changeRequestStatusDto) {
    return requestService.changeEventRequests(userId, changeRequestStatusDto);
  }
}
