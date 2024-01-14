module kg.megacom.shop {
    requires javafx.controls;
    requires javafx.fxml;


    opens kg.megacom.shop to javafx.fxml;
    exports kg.megacom.shop;
    exports kg.megacom.shop.controllers;
    opens kg.megacom.shop.controllers to javafx.fxml;
}