package org.example.service;

public class MenuService {
    public static void firsrMenu(){
        System.out.println("\tPress your choice: ");
        System.out.println("\t1. Login");
        System.out.println("\t2. Register");
    }

    public static void secondMenu(){
        System.out.println("*************************************");
        System.out.println("       WELCOME TO YOUR SHOP");
        System.out.println("**************************************");
        System.out.println("\tPress your choice: ");
        System.out.println("\t1. ELECTRONIC");
        System.out.println("\t2. SHOES");
        System.out.println("\t3. STATIONERY");
        System.out.println("\t4. Edit Cart");
        System.out.println("\t5. Show your cart");
    }

    public static void electricMenu(){
        System.out.println("--------------------------------------");
        System.out.println("          ELECTRIC CATEGORY           ");
        System.out.println("--------------------------------------");
        System.out.println("\tPress your choice: ");
        System.out.println("\t1. TV");
        System.out.println("\t2. RADIO");
        System.out.println("\t0. QUIT");
    }

    public static void shoesMenu(){
        System.out.println("......................................");
        System.out.println("            SHOES CATEGORY            ");
        System.out.println("......................................");
        System.out.println("\tPress your choice: ");
        System.out.println("\t3. SHOES");
        System.out.println("\t4. SNEAKERS");
        System.out.println("\t0. QUIT");
    }

    public static void stationeryMenu(){
        System.out.println("======================================");
        System.out.println("          STATIONERY CATEGORY         ");
        System.out.println("======================================");
        System.out.println("\tPress your choice: ");
        System.out.println("\t5. BOOK");
        System.out.println("\t6. MAGAZINE");
        System.out.println("\t0. QUIT");
    }
    public static void editMenu(){
        System.out.println("######################################");
        System.out.println("              EDIT MENU               ");
        System.out.println("######################################");
        System.out.println("\tPress your choice: ");
        System.out.println("\t1. Delete Item");
        System.out.println("\t2. Confirm your cart");
        System.out.println("\t3. Quit");
    }
}
