package ru.practicum.explorewithme.commonhandler;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException e) {
    return new ErrorResponse(e.getMessage());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleNoSuchElementException(final NoSuchElementException e) {
    return new ErrorResponse(e.getMessage());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleIllegalStateException(final IllegalStateException e) {
    return new ErrorResponse(e.getMessage());
  }
}
