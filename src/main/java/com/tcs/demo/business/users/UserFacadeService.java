package com.tcs.demo.business.users;

import com.tcs.demo.api.users.dto.UserDto;
import com.tcs.demo.api.users.dto.UserUpdateDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

/**
 * @author joaquinmartinezgutierrez
 */
@Component
public class UserFacadeService {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserFacadeService(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public UserDto saveUser(UserDto userDTO) {
        var user = fromDto(userDTO);
        var savedUser = userService.saveUser(user);
        return toDto(savedUser);
    }

    public UserDto getUser(int id) {
        var user = userService.getUser(id);
        return toDto(user);
    }

    public Iterable<UserDto> getUsers() {
        var users = userService.getUsers();
        return ListToDto(users);
    }

    public UserDto updateUser(int id, UserUpdateDto userDto) {
        userDto.setId(id);
        var user = fromDto(userDto);
        var updatedUser = userService.updateUser(user);
        return toDto(updatedUser);
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    private Iterable<UserDto> ListToDto(Iterable<User> users) {
        return () -> StreamSupport.stream(users.spliterator(), false)
                .map(this::toDto)
                .iterator();
    }

    private UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User fromDto(UserUpdateDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private User fromDto(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
