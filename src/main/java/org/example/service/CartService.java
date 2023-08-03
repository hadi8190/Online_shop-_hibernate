package org.example.service;

import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.UserAccount;
import org.example.repository.CartRepo;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    public void createCart(int count,Product barcode) {
        CartRepo cartRepo = new CartRepo();
        Cart cart = new Cart(count,barcode);
        cartRepo.createCart(cart);
    }
    public  void deleteItem(int barcode) {
        CartRepo cartRepo = new CartRepo();
        Product product = new Product(barcode);
        Cart cart = new Cart((List<Product>) product);
        cartRepo.deleteCart(cart);
    }

    public void showTableForCart(){
        CartRepo cartRepo = new CartRepo();
        ArrayList<Cart> carts = cartRepo.showTableForCart();
        for (int i = 0; i <carts.size() ; i++) {
            System.out.println(carts.get(i));
        }
    }
    public void checkCount(){
        CartRepo cartRepo = new CartRepo();
        int recoredCount = cartRepo.checkRecordCount();
        if (recoredCount > 5){
            cartRepo.checkRecordCount();
            throw new RuntimeException("Your cart is full!");
        }
    }
}
