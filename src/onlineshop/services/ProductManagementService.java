package onlineshop.services;

import onlineshop.entities.Product;

public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);
    
}
