package com.ematura.hello.services;

import com.ematura.hello.entities.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class WorkerService {
    @PersistenceContext
    EntityManager entityManager;

    public Worker createWorker(Worker Worker){
        entityManager.persist(Worker);
        return Worker;
    }

    public Worker updateWorker(Worker Worker){
        entityManager.merge(Worker);
        return Worker;
    }

    public Worker findWorkerById(Integer id){
        return entityManager.find(Worker.class, id);
    }

    public List<Worker> getAllWorkers(){
        return entityManager.createQuery("SELECT w FROM Worker w").getResultList();
    }
}
