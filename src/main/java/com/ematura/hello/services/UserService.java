package com.ematura.hello.services;

import com.ematura.hello.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class UserService {
    @PersistenceContext
    EntityManager entityManager;

    public User createUser(User User){
        entityManager.persist(User);
        return User;
    }

    public User updateUser(User User){
        entityManager.merge(User);
        return User;
    }

    public User findUserById(Integer id){
        return entityManager.find(User.class, id);
    }

    public List<User> getAllUsers(){
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }
}
