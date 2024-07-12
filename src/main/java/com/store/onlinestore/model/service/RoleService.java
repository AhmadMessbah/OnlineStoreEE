package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Role;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Singleton
public class RoleService {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public Role save(Role role) throws Exception {
        entityManager.persist(role);
        return role;
    }

    public Role edit(Role role) throws Exception {
        Role foundRole = entityManager.find(Role.class, role.getId());
        if (foundRole != null) {
            entityManager.merge(role);
        }
        return role;
    }

    public Role remove(Long id) throws Exception {
        Role role = entityManager.find(Role.class, id);
        if (role != null) {
            role.setDeleted(true);
            entityManager.merge(role);
        }
        return role;
    }

    public List<Role> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from roleEntity oo where oo.deleted=false", Role.class)
                .getResultList();
    }

    public Role findById(Long id) throws Exception {
        Role role = entityManager.find(Role.class, id);
        return role;
    }

    public List<Role> FindByRole(String role) throws Exception {
        return entityManager
                .createQuery("select r from roleEntity r where r.role = :role", Role.class)
                .setParameter("role", role)
                .getResultList();
    }
}
