package kg.megacom.shop.services.impl;

import kg.megacom.shop.models.Product;
import kg.megacom.shop.services.CategoryService;
import kg.megacom.shop.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();
    private CategoryService categoryService = CategoryService.INSTANCE;

    public ProductServiceImpl() {
        products.add(new Product(1,"Веселый молочник", 70, 50, categoryService.findCategoryById(1), "123456"));
        products.add(new Product(2,"Мыло", 30, 10, categoryService.findCategoryById(2), "1213"));
    }


    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        for (Product product:products) {
            if (product.getBarcode().equals(barcode.trim())){
                return product;
            }
        }
        return null;
    }


}
