package onlineshop.menu.implementations;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.User;
import onlineshop.entities.implementations.DefaultUser;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.implementations.DefaultUserManagementService;

public class SignUpMenu implements Menu{

    private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
    @Override
    public void start(){
        printMenuHeader();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please input FIRST NAME: ");
        String firstName = sc.next();

        System.out.println("Please input LAST NAME: ");
        String lastName = sc.next();

        System.out.println("Please input PASSWORD: ");
        String password = sc.next();

        System.out.println("Please input EMAIL: ");
        sc = new Scanner(System.in);
		String email = sc.nextLine();

		User user = new DefaultUser(firstName, lastName, password, email);

        String errorMessage = userManagementService.registerUser(user);

        if ( errorMessage == null || errorMessage.isEmpty()){
            context.setLoggedInUser(user);
            System.out.println("New user is created");
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public void printMenuHeader(){
        System.out.println("--- SIGN UP ---");
    }
}
