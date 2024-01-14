package kg.megacom.shop.services;

import kg.megacom.shop.models.Category;
import kg.megacom.shop.services.impl.CategoryServiceImpl;

import java.util.List;

public interface CategoryService {

    CategoryServiceImpl INSTANCE = new CategoryServiceImpl();

    boolean createCategory(Category category);

    List<Category> getCategories();

    Category findCategoryById(int id);
}
