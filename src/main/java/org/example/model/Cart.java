package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "count")
    private int count;
    @ManyToOne(fetch = FetchType.LAZY , cascade = { CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH })
    @JoinTable(name = "userAccount_cart" , joinColumns = @JoinColumn(name = "cart_id") , inverseJoinColumns = @JoinColumn(name = "user_id"))
    private UserAccount userAccount;
    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH })
    @JoinTable(name = "cart_product" , joinColumns = @JoinColumn(name = "cart_id") , inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Cart(){

    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public Cart(int count, Product products) {
        this.count = count;
        this.products = (List<Product>) products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void add(Product product){
        if (products == null){
            products = new ArrayList<>();
        }
        products.add(product);
        product.setCarts((List<Cart>) this);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "count=" + count +
                ", userAccount=" + userAccount +
                ", products=" + products +
                '}';
    }
}
