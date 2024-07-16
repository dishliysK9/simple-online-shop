package onlineshop.menu.implementations;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.Order;
import onlineshop.entities.implementations.DefaultOrder;
import onlineshop.menu.Menu;
import onlineshop.services.OrderManagementService;
import onlineshop.services.implementations.DefaultOrderManagementService;

public class CheckoutMenu implements Menu{

    private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

    @Override
    public void start() {

       while (true){

        printMenuHeader();

        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();

        if (!createOrder(userInput)){
            continue;
        }

        context.getSessionCart().clear();
        break;


       }
       System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");

    }

    private boolean createOrder(String creditCardNumber){
        Order order = new DefaultOrder();

        if (!order.isCreditCardNumberValid(creditCardNumber)){
            return false;
        }

        order.setCreditCardNumber(creditCardNumber);
        order.setProducts(context.getSessionCart().getProducts());
        order.setCustomerId(context.getLoggedInUser().getId());
        orderManagementService.addOrder(order);
        return true;

    }

    @Override
    public void printMenuHeader() {

        System.out.println("--- CHECKOUT MENU ---");

        System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
    }
    
}
