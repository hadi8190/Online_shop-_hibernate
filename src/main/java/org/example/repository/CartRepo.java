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

public class CartRepo {

    public static final String SHOW_TABLE_FOR_CART_QUERY = "from Cart";
    public static final String GET_ALL_RECORDS_WITH_COUNT_QUERY = "SELECT count(*) from Cart";


    public void createCart(Cart cart){
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
        Cart cart1 = new Cart();
        session.save(cart);
        session.getTransaction().commit();
        System.out.println("Done!!");
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        session.close();
        factory.close();
    }
}
public void deleteCart(Cart cart){
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
            session.delete(cart);
        session.getTransaction().commit();
        System.out.println("Done!!");
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        session.close();
        factory.close();
    }
}
public ArrayList<Cart> showTableForCart(){
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
        Query<Cart> query = session.createQuery(SHOW_TABLE_FOR_CART_QUERY, Cart.class);
        Cart cart = query.getSingleResult();
        System.out.println(cart);
        session.getTransaction().commit();
        System.out.println("Your table");
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        session.close();
        factory.close();
    }
    return null;
}

    public int checkRecordCount() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserAccount.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Fish.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        int count = 1;
        try {
            session.beginTransaction();
//            int theId = 1;
            Query<Cart> query = session.createQuery(GET_ALL_RECORDS_WITH_COUNT_QUERY, Cart.class);
            int count1 = query.getTimeout();
            session.getTransaction().commit();
            return count1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
        return count;
    }
}
