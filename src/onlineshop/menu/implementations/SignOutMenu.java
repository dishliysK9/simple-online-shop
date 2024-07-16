package onlineshop.menu.implementations;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class SignOutMenu implements Menu{
    
    private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

    public void start(){
        printMenuHeader();
        context.setLoggedInUser(null);
    }

    public void printMenuHeader(){

        System.out.println("--- SIGN OUT ---");
		System.out.println("Have a nice day! Look forward to welcoming back!");		
    }
}
