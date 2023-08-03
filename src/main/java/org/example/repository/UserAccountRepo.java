package org.example.repository;

import org.example.model.Cart;
import org.example.model.Fish;
import org.example.model.Product;
import org.example.model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserAccountRepo {
    private static final String SELECT_BY_PASSWORD = "from UserAccount where nationalcode =: nationalcode";

    public void createAdmin(UserAccount userAccount) {
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
            session.save(userAccount);
            session.getTransaction().commit();
            System.out.println("Done!");


        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

    public  UserAccount findUserAccountByPassword(String inputNationalcode) {
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
            Query<UserAccount> query = session.createQuery(SELECT_BY_PASSWORD, UserAccount.class);
            query.setParameter("nationalcode",inputNationalcode);
            UserAccount userAccount = query.uniqueResult();
            System.out.println(userAccount);
            session.getTransaction().commit();
            return userAccount;

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
        return null;
    }
}
