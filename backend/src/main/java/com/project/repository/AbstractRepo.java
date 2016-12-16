package com.project.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sergeyy on 12/12/16.
 */
public abstract class AbstractRepo {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
        session().persist(entity);
    }

    public void delete(Object entity) {
        session().delete(entity);
    }

}
