package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fish")
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "confirm")
    private String confirm;
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinTable(name = "useraccount_fish" , joinColumns = @JoinColumn(name = "fish_id") , inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JoinColumn(name = "user_account")
    private UserAccount userAccount;

    public Fish(){

    }

    public Fish(int totalPrice , UserAccount userAccount) {
        this.totalPrice = totalPrice;
        this.userAccount = userAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
