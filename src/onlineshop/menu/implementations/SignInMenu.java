package onlineshop.menu.implementations;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.User;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.implementations.DefaultUserManagementService;

public class SignInMenu implements Menu{

    private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

		System.out.print("Please, enter your email: ");
		String userEmail = sc.next();

		System.out.print("Please, enter your password: ");
		String userPassword = sc.next();

       User user = userManagementService.getUserByEmail(userEmail);
       
    }

    @Override
    public void printMenuHeader() {

       System.out.println("--- SIGN IN ---");

    }
    
}
