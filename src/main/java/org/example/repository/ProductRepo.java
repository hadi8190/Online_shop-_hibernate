package org.example.repository;

import org.example.model.Cart;
import org.example.model.Fish;
import org.example.model.Product;
import org.example.model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;


public class ProductRepo {

    private static final String SELECT_BY_BARCODE = "from Product where barcode=: barcode";
    public static final String SHOW_TABLE_FOR_CART_QUERY = "from Product where code =: code";


    public ArrayList<Product> showTableForProduct(int code) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserAccount.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Fish.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();


        try {
            session.beginTransaction();
            ArrayList<Product> products = new ArrayList<>();
            Query<Product> query = session.createQuery(SHOW_TABLE_FOR_CART_QUERY, Product.class);
            query.setParameter("code",code);
            List product = query.getResultList();
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println("Your table for product");
            return products;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }



    public Product findDataForProduct(int barcode) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserAccount.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Fish.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();
            Query<Product> query = session.createQuery(SELECT_BY_BARCODE, Product.class);
            query.setParameter("barcode",barcode);
            Product product = query.getSingleResult();
            session.getTransaction().commit();
            return product;
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
        return null;
    }
}
