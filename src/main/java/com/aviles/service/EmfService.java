package com.aviles.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfService {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
