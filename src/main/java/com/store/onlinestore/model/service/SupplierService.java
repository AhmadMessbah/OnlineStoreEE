package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Supplier;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SupplierService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public Supplier save(Supplier supplier) throws Exception {
        entityManager.persist(supplier);
        return supplier;
    }

    public Supplier edit(Supplier supplier) throws Exception {
        Supplier findSupplier = entityManager.find(Supplier.class, supplier.getId());
        if (findSupplier != null) {
            entityManager.merge(supplier);
        }
        return supplier;
    }

    public Supplier remove(Long id) throws Exception {
        Supplier supplier = entityManager.find(Supplier.class, id);
        if (supplier != null) {
            supplier.setDeleted(true);
            entityManager.merge(supplier);
        }
        return supplier;
    }

    public List<Supplier> findAll() throws Exception {
        return entityManager.createQuery("select oo from supplierEntity oo where oo.deleted=false", Supplier.class).getResultList();
    }

    public Supplier findById(Long id) throws Exception {
        Supplier supplier = entityManager.find(Supplier.class, id);
        return supplier;
    }

    public List<Supplier> findByNameAndFamily(String name, String family) throws Exception {
        return entityManager.createQuery("select oo from supplierEntity oo where oo.name like :name and oo.family like :family", Supplier.class)
                .setParameter("name", name + "%")
                .setParameter("family", family + "%")
                .getResultList();
    }

    public Supplier findByMobilePhone(String mobilePhone) throws Exception {
        return entityManager.createQuery("select oo from supplierEntity oo where oo.mobilePhone=:mobilePhone", Supplier.class)
                .setParameter("mobilePhone", mobilePhone)
                .getSingleResult();
    }

    public Supplier fideByNationalCode(String nationalCode) throws Exception {
        return entityManager.createQuery("select oo from supplierEntity oo where oo.nationalCode=:nationalCode", Supplier.class)
                .setParameter("nationalCode", nationalCode)
                .getSingleResult();
    }

    public Supplier findByCompany(String company) throws Exception {
        return entityManager.createQuery("select oo from supplierEntity oo where oo.companyName=:companyName", Supplier.class)
                .setParameter("companyName", company)
                .getSingleResult();
    }
}
