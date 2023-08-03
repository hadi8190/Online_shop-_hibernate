package org.example.service;

import org.example.model.Fish;
import org.example.model.Product;
import org.example.repository.FishRepo;
import org.example.repository.ProductRepo;

public class FishService {
    public void createConfirm() {
        FishRepo fishRepo = new FishRepo();
        fishRepo.createFish();
    }

    public void updatetotalPrice(int totalPrice) {
        FishRepo fishRepo = new FishRepo();
        fishRepo.updateTotalPrice(totalPrice);
    }

    public void totalPriceForUser(int barcode, int number){
        FishService fishService = new FishService();
        ProductRepo productRepo = new ProductRepo();
        Product price = productRepo.findDataForProduct(barcode);
        number = number * price.getPrice();
        fishService.updatetotalPrice(number);
    }

    public void changeConfirm(int confirm) {
        FishRepo fishRepo = new FishRepo();
        Fish fish1 = fishRepo.updateConfirm(confirm);
        if (fish1 != null) {
            if (confirm == 1) {
                fish1.setConfirm("Yes");
                fishRepo.updateConfirm(1);
                System.out.println("Confirm Changed to 'Yes'");
            } else
                System.out.println("Confirm is Already 'Yes'!");
        } else if (confirm == 2) {
            fish1.setConfirm("No");
            fishRepo.updateConfirm(2);
            System.out.println("Confirm Changed to 'No'");
        } else {
            System.out.println("Confirm is Already 'No'!");
        }
    }

    public void changeConfirmAgain(int confirm) {
        FishService fishService = new FishService();
        fishService.changeConfirm(confirm);
    }
}
