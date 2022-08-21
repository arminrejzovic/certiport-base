package com.ematura.hello.services;

import com.ematura.hello.entities.Certificate;
import com.ematura.hello.entities.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class SupplierService {

    @PersistenceContext
    EntityManager entityManager;

    public Supplier createSupplier(Supplier supplier){
        entityManager.persist(supplier);
        return supplier;
    }

    public Supplier updateSupplier(Supplier supplier){
        entityManager.merge(supplier);
        return supplier;
    }

    public List<Supplier> filterSuppliers(String name, String city){
        return entityManager.createNamedQuery(Supplier.FILTER, Supplier.class)
                .setParameter("name", name)
                .setParameter("city", city)
                .getResultList();
    }

    public Supplier findSupplierById(Integer id){
        return entityManager.find(Supplier.class, id);
    }

    public List<Supplier> getAllSuppliers(){
        return entityManager.createQuery("SELECT s FROM Supplier s").getResultList();
    }
}
