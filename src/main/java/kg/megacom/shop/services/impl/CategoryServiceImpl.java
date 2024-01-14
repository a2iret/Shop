package kg.megacom.shop.services.impl;

import kg.megacom.shop.models.Category;
import kg.megacom.shop.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();

    public CategoryServiceImpl() {
        categories.add(new Category("Milks", true));
        categories.add(new Category("Sneaks", true));
    }

    @Override
    public boolean createCategory(Category category) {
        return false;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }
}
