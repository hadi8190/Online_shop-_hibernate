package org.example.service;

import org.example.model.UserAccount;
import org.example.repository.UserAccountRepo;

public class UserAccountService {
    private static UserAccount loggedInUser = null;
    public boolean
    register(String username, String nationalcode) {
        UserAccountRepo userAccountRepo = new UserAccountRepo();
        if (userAccountRepo.findUserAccountByPassword(nationalcode) == null) {
            UserAccount userAccount = new UserAccount(username, nationalcode);
            userAccountRepo.createAdmin(userAccount);
            System.out.println("Account Created Successfully!");
            return true;
        }//catch
        System.out.println("You Signed up with this password Before!");
        return false;
    }
        public boolean login(String nationalcode) {
        UserAccountRepo userAccountRepo = new UserAccountRepo();
        UserAccount userAccount = userAccountRepo.findUserAccountByPassword(nationalcode);
        if (userAccount != null) {
            if (userAccount.getNationalcode().equals(nationalcode)){
                this.loggedInUser = userAccount;
                System.out.println(userAccount.getUsername()+" with [YOU: "+ nationalcode
                        + "] Logged in Successfully");
                return true;
            }
        }//catch
        System.out.println("Password is Incorrect!");
        return false;
    }
}
