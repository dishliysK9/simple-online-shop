package onlineshop.menu.implementations;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class ChangeEmailMenu implements Menu{

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {

        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();

        context.getLoggedInUser().setEmail(userInput);
        System.out.println("Your email has been successfully changed");

    }

    @Override
    public void printMenuHeader() {
        System.out.println("--- CHANGE EMAIL ---");
        System.out.println("Enter new email: ");
    }
    
}
