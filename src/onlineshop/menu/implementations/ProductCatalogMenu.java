package onlineshop.menu.implementations;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.Product;
import onlineshop.menu.Menu;
import onlineshop.services.ProductManagementService;
import onlineshop.services.implementations.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu{

    private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

    {
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

    @Override
    public void start() {
        Menu menuToNavigate = null;
        
        while (true){

            printMenuHeader();
            printProductsToConsole();

            String userInput = readUserInput();

            if(context.getLoggedInUser() == null){

                menuToNavigate = new MainMenu();
                System.out.println("You are not logged in. Please, sign in or create new account");

                break;
            }

            if(userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)){

                menuToNavigate = new MainMenu();

                break;
            }

            if(userInput.equalsIgnoreCase(CHECKOUT_COMMAND)){
                
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("--- PRODUCT CATALOG ---");
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
    }

    private Product printProductsToConsole(){
        Product[] products = productManagementService.getProducts();
        for (Product product : products){
            System.out.println(product);
        }
    }

    private String readUserInput(){

        System.out.print("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");

		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();

		return userInput;
    }
    
}
