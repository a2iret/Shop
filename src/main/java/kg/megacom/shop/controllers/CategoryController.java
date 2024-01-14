package kg.megacom.shop.controllers;

import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import kg.megacom.shop.models.Category;
import kg.megacom.shop.services.CategoryService;

public class CategoryController {

    private CategoryService categoryService = CategoryService.INSTANCE;

    @FXML
    private ListView<Category> ListViewCategories;

    @FXML
    private MenuItem menuItemAdd;

    @FXML
    private MenuItem menuItemEdit;

    @FXML
    private MenuItem nenuItemDelete;

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(nenuItemDelete)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Вы уверенны?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> choice = alert.showAndWait();
            if (choice.get().equals(ButtonType.YES)){
                System.out.println(": - )");
            }else
                System.out.println(": - (");
        }
    }

    @FXML
    void initialize() {
        List<Category> categories = categoryService.getCategories();
        ListViewCategories.setItems(FXCollections.observableList(categories));
    }

}
