package org.example.repository;

import org.example.model.Cart;
import org.example.model.Fish;
import org.example.model.Product;
import org.example.model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FishRepo {

    public static final String UPDATE_TOTALPRICE = "update Fish set totalPrice =: totalPrice + totalPrice";
    public static final String UPDATE_CONFIRM = "update Fish set confirm =:n where confirm =:i";
    public void createFish(){
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
            Fish fish1 = new Fish();
            session.save(fish1);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

    public Fish updateTotalPrice(int totalPrice) {
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
            Query q=session.createQuery(UPDATE_TOTALPRICE);
            q.setParameter("totalPrice",totalPrice);
            int status=q.executeUpdate();
            System.out.println(status);
            session.getTransaction().commit();
            System.out.println("Done!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Fish updateConfirm(int confirm1){
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
            Query<Fish> query = session.createQuery(UPDATE_CONFIRM,Fish.class);

            if(confirm1 == 1)
                query.setParameter("n","Yes");
            else if (confirm1 == 2)
                query.setParameter("i","No");

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
        return null;
    }
}