package ru.practicum.explorewithme.user.service;

import io.micrometer.core.instrument.util.StringUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.user.dto.UserDto;
import ru.practicum.explorewithme.user.dto.UserMapper;
import ru.practicum.explorewithme.user.repository.UserRepository;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

  private final UserRepository storage;

  @Override
  public UserDto createUser(UserDto userDto) {
    checkEmailPresents(userDto);

    var user = storage.save(UserMapper.toUser(userDto));
    return UserMapper.toUserDto(user);
  }

  @Override
  public List<UserDto> getUsers(List<Long> ids, int from, int size) {
    return storage.getUsers(ids, from, size);
  }

  @Override
  public void deleteUser(long userId) {
    storage.deleteById(userId);
  }

  private void checkEmailPresents(UserDto userDto) {
    if (StringUtils.isBlank(userDto.getEmail())) {
      throw new IllegalStateException("Email address is not presented");
    }
  }
}
