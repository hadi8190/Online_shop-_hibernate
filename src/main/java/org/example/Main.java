package org.example;

import org.example.model.Product;
import org.example.model.UserAccount;
import org.example.service.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        ProductService productService = new ProductService();


        boolean quit = false;
        boolean quit1 = false;

        while (!quit) {
            try {
                MenuService.firsrMenu();
                System.out.println("Enter your choice: ");
                int choice = scanner.nextByte();
                Integer.valueOf(choice);
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        main.login();
                        while (!quit1){
                            MenuService.secondMenu();
                            int choice1 = scanner.nextByte();
                            scanner.nextLine();
                            switch (choice1){
                                case 1:
                                    MenuService.electricMenu();
                                    System.out.println("Enter your choice: ");
                                    int choice10 = scanner.nextInt();
                                    if (choice10 != 1 && choice10 != 2 && choice10 != 0){
                                        System.out.println("Please enter number 1 , 2 , 0");
                                    }else if (choice10 == 0) {
                                        break;
                                    }else {
                                        productService.showTableForProduct(choice10);
                                        quit1 = false;
                                        main.addItem();}
                                    break;
                                case 2:
                                    MenuService.shoesMenu();
                                    System.out.println("Enter your choice: ");
                                    int choice11 = scanner.nextInt();
                                    if (choice11 != 3 && choice11 != 4 && choice11 != 0){
                                        System.out.println("Please enter number 3 , 4 , 0");
                                    }else if(choice11 == 0) {
                                        break;
                                    }else {
                                        productService.showTableForProduct(choice11);
                                        main.addItem();
                                    }
                                    break;
                                case 3:
                                    MenuService.stationeryMenu();
                                    System.out.println("Enter your choice: ");
                                    int choice12 = scanner.nextInt();
                                    if (choice12 != 5 && choice12 != 6 && choice12 != 0){
                                        System.out.println("Please enter number 5 , 6 , 0");
                                    } else if (choice12 == 0) {
                                        break;
                                    }else {
                                        productService.showTableForProduct(choice12);
                                        main.addItem();
                                    }
                                    break;
                                case 4:
                                    MenuService.editMenu();
                                    main.deleteItem();
                                    break;
                                case 5:
                                    main.showTable();
                                    System.out.println("Enter 0 for exit.");
                                    if (scanner.nextInt() == 0) {
                                        quit = true;
                                    }
                                    break;
                            }
                        }
                    case 2:
                        main.adduser();
                        break;
                }

            }catch (InputMismatchException e){
                System.out.println("Please enter correct number");
                break;
            }
        }
    }

    boolean quit = false;
    boolean quit6 = false;



    public void login(){
        UserAccountService userAccountService = new UserAccountService();
        System.out.println("Enter your national code: ");
        String nationalcode = scanner.nextLine();
        userAccountService.login(nationalcode);
    }
    public void adduser(){
        UserAccountService userAccountService = new UserAccountService();
        try {
            System.out.println("Enter your userName: ");
            String username = scanner.nextLine();
            System.out.println("Enter your National Code: ");
            String natioanlcode = scanner.next();
            Integer.valueOf(natioanlcode);
            userAccountService.register(username,natioanlcode);
        }catch (NumberFormatException e){
            System.out.println("Please enter your national code.");
        }
    }
    public void addItem() {
        FishService fishService = new FishService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        while (!quit) {
            System.out.println("Enter barcode: ");
            int barcode = scanner.nextInt();
            Product productForNew = new Product(barcode);
            System.out.println("Enter your number: ");
            int number = scanner.nextInt();
            Product product = productService.findDataForProduct(barcode);
            if (number > product.getCount()) {
                System.out.println("Sorry we don't have it.");
                break;
            } else {
                try {
                    cartService.checkCount();
                    cartService.createCart(number,productForNew);
                    fishService.createConfirm();
                    fishService.totalPriceForUser(barcode, number);
                } catch (RuntimeException e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("Do you want continue?: 1.NO  2.YES");
                if (scanner.nextInt() == 1) {
                    quit = true;
                }
            }
        }
    }

    public void deleteItem() {
        CartService cartService = new CartService();
        FishService fishService = new FishService();
        while (!quit6) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextByte();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter barcode: ");
                    int id = scanner.nextInt();
                    cartService.deleteItem(id);
                    break;
                case 2:
                    System.out.println("Do you want confirm your cart:  1.YES   2.NO ");
                    int confirm = scanner.nextInt();
                    fishService.changeConfirmAgain(confirm);
                    break;
                case 3:
                    quit6 = true;
            }

        }quit6 = false;
    }

    public void showTable(){
        CartService cartService = new CartService();
        cartService.showTableForCart();
    }
    }