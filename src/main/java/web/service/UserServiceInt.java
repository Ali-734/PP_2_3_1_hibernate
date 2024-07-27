package web.service;

import web.model.User;

import java.util.List;

public interface UserServiceInt {
    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
