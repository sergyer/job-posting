package com.project.service.impl;


import com.project.dto.UserDTO;
import com.project.model.User;
import com.project.repository.UserRepo;
import com.project.service.UserService;
import org.dozer.Mapper;
import org.hibernate.TransientObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by sergeyy on 12/14/16.
 */

@Component
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Mapper dtoMapper;


    public Long saveUser(UserDTO userDto) {
        Long id = null;


        if (userDto != null && emailIsFree(userDto)) {
            User userToBeSaved = dtoMapper.map(userDto, User.class);


            try {
                userRepo.createUser(userToBeSaved);
                id = userToBeSaved.getId();
            } catch (Exception e) {
                return null;
            }


        }


        return id;
    }

    public boolean deleteUser(Long id) {
        if (id != null) {
            try {
                userRepo.deleteUser(id);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }


        }

        return false;

    }

    public boolean updateUser(UserDTO userDto) {
        if (userDto != null) {

            try {
                userRepo.updateUser(dtoMapper.map(userDto, User.class));
            } catch (TransientObjectException e) {
                return false;
            }

            return true;

        }

        return false;
    }

    public UserDTO getUserById(Long id) {
        UserDTO userDto = null;
        if (id != null) {
            User user = userRepo.findUserById(id);
            if (user != null) {
                userDto = dtoMapper.map(user, UserDTO.class);

            }

        }
        return userDto;
    }

    private boolean emailIsFree(UserDTO userDto) {
        String email = userDto.getEmail();
        User userFromDb;

        try {
            userFromDb = userRepo.findUserByEmail(email);
        } catch (Exception e) {
            return false;
        }

        if (userFromDb == null) {
            return true;
        } else
            return false;


    }
}
