package onlineshop.menu.implementations;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class ChangePasswordMenu implements Menu{

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
       printMenuHeader();
       Scanner sc = new Scanner(System.in);
       String userInput = sc.next();

       context.getLoggedInUser().setPassword(userInput);
       System.out.println("Your password has been successfully changed");


    }

    @Override
    public void printMenuHeader() {
        System.out.println("--- CHANGE PASSWORD ---");
        System.out.println("Enter new password: ");
    }
    
}
