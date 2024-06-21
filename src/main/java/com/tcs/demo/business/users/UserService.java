package com.tcs.demo.business.users;

import org.springframework.stereotype.Service;

/**
 * @author joaquinmartinezgutierrez
 */
@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        var userInDb = userRepository.findById(user.getId()).orElse(null);
        if (userInDb == null) {
            return null;
        }
        userInDb.setAccountNumber(user.getAccountNumber());
        userInDb.setAccountHolderEmail(user.getAccountHolderEmail());
        return userRepository.save(userInDb);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
