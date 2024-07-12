package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.User;
import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;
@ApplicationScoped
@Singleton
public class UserService implements Serializable {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;


    public User save(User user) throws Exception {
        entityManager.persist(user);
        return user;
    }

    public User edit(User user) throws Exception {
        User foundAdmin = entityManager.find(User.class, user.getUsername());
        if (foundAdmin != null) {
            entityManager.merge(user);
        }
        return user;
    }

    public User remove(Long id) throws Exception {
        User user = entityManager.find(User.class,id );
        if (user != null) {
            user.setDeleted(true);
            entityManager.merge(user);
        }
        return user;
    }

    public List<User> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from userEntity oo where oo.deleted=false", User.class)
                .getResultList();
    }
    public User findById(Long id) throws Exception {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public List<User> findByUsername(String username) throws Exception {
        return entityManager
                .createQuery("select u from userEntity u where u.username=:username", User.class)
                .setParameter("username", username )
                .getResultList();
    }

    public List<User> findByUsernameAndPassword(String username, String password) throws Exception {
        return entityManager
                .createQuery("select u from userEntity u where u.username=:username and u.password=:password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
    }

}
