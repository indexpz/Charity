package pl.indexpz.charity.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.indexpz.charity.domain.model.User;
import pl.indexpz.charity.domain.repository.UserRepository;
import pl.indexpz.charity.domain.service.UserServiceInterface;
import pl.indexpz.charity.exceptions.ResourceNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow((() -> new ResourceNotFoundException("User with id " + userId + " not exist.")));
    }

    @Override
    public User getUserByUserName(String username) {
        return (User) userRepository.findByUsername(username).orElseThrow((() -> new ResourceNotFoundException("User with username " + username + " not exist.")));

    }

    @Override
    public void updateUser(User userToUpdate) {
        log.info("UserID to update " + userToUpdate.getId());
        log.info("User to update " + userToUpdate);
        User user = getUserByUserName(userToUpdate.getUsername());
        user.setUsername(userToUpdate.getUsername());
        user.setPassword(userToUpdate.getPassword());
        userRepository.save(user);
        log.info("User after update " + user);
    }

    @Override
    public void delete(User userToDelete) {
        User user = getUserByUserName(userToDelete.getUsername());
        log.info("Deleting user: " + user);
        userRepository.delete(user);
    }
}
