package com.aviles.util;

import com.aviles.entity.Credentials;
import com.aviles.entity.User;
import com.aviles.service.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CredentialsDbUtil {

    //get a list of credentials from DB
    public static List<Credentials> getCredentials(){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        String qString = "select c from Credentials c";
        TypedQuery<Credentials> q = entityManager.createQuery(qString, Credentials.class);

        List<Credentials> creds;

        try{
            creds = q.getResultList();
            if(creds == null || creds.isEmpty()){
                creds = null;
            }
        }
        finally {
            entityManager.close();
        }

        return creds;
    }

    //check if password is correct with what is in the db
    public static boolean checkCredentials(String username, String pass){

        List<Credentials> creds = getCredentials();
        boolean checkCreds=false;

        if(creds == null || creds.isEmpty()){
            checkCreds = false;
        }

        else {
            for (Credentials cred : creds){
                if(cred.getUsername().equalsIgnoreCase(username) && cred.getPass().equalsIgnoreCase(pass)){
                    checkCreds = true;
                }
            }
        }
        return checkCreds;
    }


    public static User getUserFromCreds(String username, String pass){

        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();

        //get credentials query
        String qString = "select c from Credentials c where c.username = :username AND c.pass = :password";
        TypedQuery<Credentials> q = entityManager.createQuery(qString, Credentials.class);
        q.setParameter("username", username);
        q.setParameter("password", pass);

        Credentials tempCred = null;

        try{
            //get values from db
            tempCred = q.getSingleResult();

            //get user query based on credentials ID
            String uString = "select u from User u where u.credentials = :credentials";
            TypedQuery<User> u = entityManager.createQuery(uString, User.class);
            u.setParameter("credentials", tempCred);

            User tempUser = u.getSingleResult();

            //set user to its corresponding credential
            tempCred.setUser(tempUser);

            //log results
            System.out.println("========>>> tempCred from CredentialsDbUtil: " + tempCred);
            System.out.println("========>>> User for TempCred from CredentialsDbUtil: " + tempCred.getUser());
        }
        catch(NoResultException e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

//        for (Credentials cred : creds){
//            if(cred.getUsername().equalsIgnoreCase(username) && cred.getPass().equalsIgnoreCase(pass)){
//               tempCred = entityManager.find(Credentials.class, cred.getCredentialsId());
//
//                System.out.println("========>>> tempCred from CredentialsDbUtil: " + tempCred);
//               break;
//            }
//         }
    return tempCred.getUser();
    }
}
