package pl.indexpz.charity.domain.service;

import pl.indexpz.charity.domain.model.User;

public interface UserServiceInterface  {

    User getUserById(Long id);

    User getUserByUserName(String username);

    void updateUser(User user);

    void delete(User user);

}
