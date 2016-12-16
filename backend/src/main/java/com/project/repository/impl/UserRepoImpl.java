package com.project.repository.impl;

import com.project.model.User;
import com.project.repository.AbstractRepo;
import com.project.repository.UserRepo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by sergeyy on 12/13/16.
 */


@Transactional
@Repository
public class UserRepoImpl extends AbstractRepo implements UserRepo {

    public void createUser(User user) {

        user.setRegisteredDate(new Date());

        session().save(user);
        session().flush();

    }

    public void deleteUser(Long id) {
        User userToBeDeleted = findUserById(id);
        delete(userToBeDeleted);

    }

    public void updateUser(User user) {
        session().update(user);


    }

    public User findUserById(Long id) {
        return (User) session().get(User.class, id);
    }

    public User findUserByEmail(String email) {
        Query query = session().createQuery("select c from User c WHERE c.email=:email")
                .setParameter("email", email);
        User userFromDb = (User) query.uniqueResult();
        return userFromDb;
    }
}
