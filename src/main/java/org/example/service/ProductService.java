package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductRepo;

import java.util.ArrayList;

public class ProductService {

    public void showTableForProduct(int code){
        ProductRepo productRepo = new ProductRepo();
        ArrayList<Product> products = productRepo.showTableForProduct(code);
        for (int i = 0; i <products.size() ; i++) {
            System.out.println(products.get(i));
        }
    }

    public Product findDataForProduct(int barcode){
        ProductRepo productRepo = new ProductRepo();
        Product product = productRepo.findDataForProduct(barcode);

        return product;
    }
}
