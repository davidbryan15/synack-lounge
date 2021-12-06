package com.aviles.util;

import com.aviles.entity.Product;
import com.aviles.entity.User;
import com.aviles.service.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDBUtil {

    public static List<Product> getProducts(){
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        String qString= "select p from Product p";
        TypedQuery p = entityManager.createQuery(qString, Product.class);

        List<Product> products = null;

        try {
            products = p.getResultList();

            if(products == null || products.isEmpty()){
                products = null;
            }


        }
        catch (NoResultException e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        return products;
    }


    public static Product getProduct(Integer productId) {
        EntityManager entityManager = EmfService.getEntityManagerFactory().createEntityManager();
        Product tempProduct = null;

        try {
            tempProduct = entityManager.find(Product.class, productId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        return tempProduct;
    }
}
