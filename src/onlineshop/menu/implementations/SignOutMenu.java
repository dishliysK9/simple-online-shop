package onlineshop.menu.implementations;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class SignOutMenu implements Menu{
    
    private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
}
