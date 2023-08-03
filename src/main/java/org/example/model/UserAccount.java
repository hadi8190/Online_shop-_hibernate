package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
    @Entity
    @Table(name = "user_account")
    public class UserAccount {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "username")
        private String username;
        @Column(name = "national_code")
        private String nationalcode;
        @OneToMany(mappedBy = "userAccount",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
        private List<Cart> carts;
        @OneToMany(mappedBy = "userAccount" ,fetch = FetchType.LAZY , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
        private List<Fish> fishs;

        public UserAccount(int id, String username, String nationalcode) {
            this.id = id;
            this.username = username;
            this.nationalcode = nationalcode;
        }

        public UserAccount(String username, String nationalcode) {
            this.username = username;
            this.nationalcode = nationalcode;
        }

        public UserAccount(int id) {
            this.id = id;
        }

        public UserAccount() {

        }

        public UserAccount(String nationalcode) {
            this.nationalcode = nationalcode;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }


        public String getNationalcode() {
            return nationalcode;
        }

        public void add(Cart cart){
            if (carts == null){
                carts = new ArrayList<>();
            }
            carts.add(cart);
            cart.setUserAccount(this);
        }

        public void add(Fish fish){
            if (fishs == null){
                fishs = new ArrayList<>();
            }
            fishs.add(fish);
            fish.setUserAccount(this);
        }

    }
