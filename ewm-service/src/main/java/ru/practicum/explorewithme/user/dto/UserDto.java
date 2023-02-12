package ru.practicum.explorewithme.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class UserDto {

  private Long id;
  @NotNull
  private String name;
  @NotNull
  @Email
  private String email;
}
