package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends ArrayList<Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "count")
    private int count;
    @Column(name = "price")
    private int price;
    @Column(name = "barcode")
    private int barcode;
    @Column(name = "description")
    private String description;
    @Column(name = "code")
    private int code;
    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH })
    @JoinTable(name = "cart_product" , joinColumns = @JoinColumn(name = "product_id") , inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private List<Cart> carts;

    public Product(){
    }

    public Product(int barcode) {
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void add(Cart cart){
        if (carts == null){
            carts = new ArrayList<>();
        }
        carts.add(cart);
        cart.setProducts((List<Product>) this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", barcode=" + barcode +
                ", description='" + description + '\'' +
                ", code=" + code +
                '}';
    }
}
