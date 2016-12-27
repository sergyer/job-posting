package com.project.service;

import com.project.dto.UserDTO;

import java.util.List;

/**
 * Created by sergeyy on 12/14/16.
 */


public interface UserService {

    Long saveUser(UserDTO userDto);

    boolean deleteUser(Long id);

    boolean updateUser(UserDTO userDto);

    UserDTO getUserById(Long id);

    UserDTO loginUser(String email, String password);

    boolean updateUserPswd(UserDTO userDto);

    List<UserDTO> getAllUsers();


}
