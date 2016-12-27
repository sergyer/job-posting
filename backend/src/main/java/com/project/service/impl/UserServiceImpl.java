package com.project.service.impl;


import com.project.dto.UserDTO;
import com.project.model.User;
import com.project.repository.UserRepo;
import com.project.service.UserService;
import com.project.utils.CommonUtils;
import org.dozer.Mapper;
import org.hibernate.TransientObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public boolean updateUserPswd(UserDTO userDto) {

        if (userDto != null) {
            userDto.setPassword(CommonUtils.hashPassword(userDto.getPassword()));
            userRepo.updateUser(dtoMapper.map(userDto, User.class));

            return true;
        }

        return false;

    }

    public Long saveUser(UserDTO userDto) {
        Long id = null;


        if (userDto != null && emailIsFree(userDto)) {
            String hashedPassword = CommonUtils.hashPassword(userDto.getPassword());
            userDto.setPassword(hashedPassword);
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

    @Override
    public UserDTO loginUser(String email, String password) {
        UserDTO entity = null;

        String hashedPassword = CommonUtils.hashPassword(password);

        try {
            User userFromDB = userRepo.loginUser(email, hashedPassword);

            if (userFromDB != null) {
//                userFromDB.setLastVisitedDate(new Date());
                entity = dtoMapper.map(userFromDB, UserDTO.class);

                return entity;
            }

        } catch (Exception e) {
            return null;
        }
        return entity;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> finalList = new ArrayList<>();

        List<User> usersListFromDB= userRepo.getUserList();


        for (User u:usersListFromDB) {
            UserDTO userDTO=dtoMapper.map(u,UserDTO.class);
            finalList.add(userDTO);
        }

        return finalList;

    }
















}
