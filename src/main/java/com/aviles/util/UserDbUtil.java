package com.aviles.util;

import com.aviles.entity.Credentials;
import com.aviles.entity.User;
import com.aviles.service.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDbUtil {

    //get multiple users
    public static List<User> getUsers(){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        String qString = "select u from User u";
        TypedQuery<User> q = entityManager.createQuery(qString, User.class);

        List<User> users;

        try{
            users = q.getResultList();
            if(users == null || users.isEmpty()){
                users = null;
            }
        }
        finally {
            entityManager.close();
        }

        return users;
    }

    //get user by Id
    public static User getUser(int id){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        User tempUser = null;

        try {
            tempUser = entityManager.find(User.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        return tempUser;
    }


    //add user
    public static void addUser(User user){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

    //remove user
    public static void removeUser(int id){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User user = getUser(id);

        try{
            transaction.begin();
            entityManager.remove(entityManager.merge(user));
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

    //UPDATE USER
    public static void updateUser(User user){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //get user from DB
        User tempUser = getUser(user.getUserId());

        //update DB user with servlet user info
        tempUser.setFirstName(user.getFirstName());
        tempUser.setLastName(user.getLastName());
        tempUser.setEmail(user.getEmail());

        try{
            transaction.begin();
            entityManager.merge(tempUser);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }



    }




}
