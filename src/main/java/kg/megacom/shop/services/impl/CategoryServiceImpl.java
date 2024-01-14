package kg.megacom.shop.services.impl;

import kg.megacom.shop.models.Category;
import kg.megacom.shop.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();

    public CategoryServiceImpl() {
        categories.add(new Category(1,"dairy", true));
        categories.add(new Category(2, "Sneaks", true));
    }

    @Override
    public boolean createCategory(Category category) {
        return false;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category findCategoryById(int id) {
        for (Category category:categories) {
            if (category.getId() == id)
                return category;
        }
        return null;
    }
}
