package kg.megacom.shop.services;

import kg.megacom.shop.models.Product;
import kg.megacom.shop.services.impl.ProductServiceImpl;

import java.util.List;

public interface ProductService {

    ProductService INSTANCE = new ProductServiceImpl();
    List<Product> getProducts();


    Product findProductByBarcode(String barcode);
}
