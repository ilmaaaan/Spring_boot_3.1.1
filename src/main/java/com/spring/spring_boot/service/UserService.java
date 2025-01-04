package com.spring.spring_boot.service;




import com.spring.spring_boot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getById(int id);
    List<User> getUsers();
}
