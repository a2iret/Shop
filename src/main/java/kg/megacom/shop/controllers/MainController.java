package kg.megacom.shop.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kg.megacom.shop.HelloApplication;
import kg.megacom.shop.models.CustomerProduct;
import kg.megacom.shop.models.Product;
import kg.megacom.shop.services.ProductService;


public class MainController {

    private ProductService productService = ProductService.INSTANCE;
    private List<CustomerProduct> customerProducts = new ArrayList<>();


    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<String, String> columnCategory;

    @FXML
    private TableColumn<String, String> columnAmount;

    @FXML
    private TableColumn<String, String> columnName;

    @FXML
    private TableColumn<String, String> columnPrice;

    @FXML
    private TableColumn<String, String> columnTotalPrice;

    @FXML
    private Label lblTotal;

    @FXML
    private MenuItem menuItemProducts;

    @FXML
    private TableView<CustomerProduct> tbCustomerProducts;

    @FXML
    private TextField txtBarcode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem menuItemCategory;

    @FXML
    void onSearchBtnClicked(ActionEvent event) {
        String barcode = txtBarcode.getText();

        Product product = productService.findProductByBarcode(barcode);

        if (product == null) {
            System.out.println("Not found");
            return;
        }

        txtName.setText(product.getName());
        txtPrice.setText(String.valueOf(product.getPrice()));

        CustomerProduct customerProduct = getCustomerProductOrCreate(product);


        tbCustomerProducts.refresh();

        double totalPrice = getTotalPriceFromCustomerProducts();
        lblTotal.setText(String.valueOf(totalPrice));
    }

    private double getTotalPriceFromCustomerProducts() {
        double total = 0;
        for (CustomerProduct customerProduct:customerProducts) {
            total += customerProduct.getTotalPrice();
        }
        return total;
    }

    private CustomerProduct getCustomerProductOrCreate(Product product) {
        CustomerProduct customerProduct = null;
        for (CustomerProduct item:customerProducts) {
            if (item.getProductId() == product.getId()){
                customerProduct = item;
                customerProduct.setAmount(customerProduct.getAmount() + 1);
                break;
            }
        }
        if (customerProduct == null){
            customerProduct = new CustomerProduct();
            customerProduct.setName(product.getName());
            customerProduct.setCategory(product.getCategory().getName());
            customerProduct.setPrice(product.getPrice());
            customerProduct.setAmount(1);
            customerProduct.setProductId(product.getId());
            customerProducts.add(customerProduct);
        }
        customerProduct.setTotalPrice(customerProduct.getAmount() * customerProduct.getPrice());
        return customerProduct;
    }

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(menuItemCategory)){
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("category-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            stage.setTitle("Категории");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        columnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        tbCustomerProducts.setItems(FXCollections.observableList(customerProducts));
    }

}
