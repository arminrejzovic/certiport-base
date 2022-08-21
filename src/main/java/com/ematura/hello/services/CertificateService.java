package com.ematura.hello.services;

import com.ematura.hello.entities.Certificate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class CertificateService {
    @PersistenceContext
    EntityManager entityManager;

    public Certificate createCertificate(Certificate certificate){
        entityManager.persist(certificate);
        return certificate;
    }

    public Certificate updateCertificate(Certificate certificate){
        entityManager.merge(certificate);
        return certificate;
    }

    public void deleteCertificate(Integer id){
        Certificate certificate = findCertificateById(id);
        if(certificate == null) return;
        entityManager.remove(certificate);
    }

    public Certificate findCertificateById(Integer id){
        return entityManager.find(Certificate.class, id);
    }

    public List<Certificate> getAllCertificates(){
        return entityManager.createQuery("SELECT c FROM Certificate c").getResultList();
    }
}
