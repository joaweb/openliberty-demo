package com.tcs.demo.api.users;

import com.tcs.demo.api.users.dto.UserDto;
import com.tcs.demo.api.users.dto.UserUpdateDto;
import com.tcs.demo.business.users.UserFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author joaquinmartinezgutierrez
 */

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserResource {

    private final UserFacadeService userService;

    public UserResource(UserFacadeService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.saveUser(user);
        log.info("EVENT: new user created with id {}", savedUser.getId());
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserUpdateDto user) {
        var updatedUser = userService.updateUser(id, user);
        log.info("EVENT: user updated with id {}", updatedUser.getId());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        log.info("EVENT: user deleted with id {}", id);
        userService.deleteUser(id);
    }
}
