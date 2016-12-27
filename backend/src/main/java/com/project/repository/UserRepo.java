package com.project.repository;

import com.project.model.User;

import java.util.List;

/**
 * Created by sergeyy on 12/13/16.
 */
public interface UserRepo {

     void createUser(User user);

     void deleteUser(Long id);

     void updateUser(User user);

     User findUserById(Long id);

     User findUserByEmail(String email);

     User loginUser(String email, String hashedPassword);

     List<User> getUserList();
}
