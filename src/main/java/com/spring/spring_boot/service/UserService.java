package web.service;


import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getById(int id);
    List<User> getUsers();
}
