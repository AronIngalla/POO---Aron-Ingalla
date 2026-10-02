package pe.edu.upeu.lacuracao.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import pe.edu.upeu.lacuracao.config.AppContext;

import java.io.IOException;

public class MainGuiController {

    @FXML TabPane tabPane;
    @FXML MenuItem menuItem1, menuItem2, menuItem3;

    @FXML
    public void initialize() {
        menuItem1.setOnAction(e -> abrirProductos());
        menuItem3.setOnAction(e -> abrirClientes());
        menuItem2.setOnAction(e -> { Platform.exit(); System.exit(0); });
    }


    private void abrirClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_cliente.fxml"));
            loader.setControllerFactory(AppContext.getInstance()::getBean);
            Parent root = loader.load();

            ScrollPane scroll = new ScrollPane(root);
            scroll.setFitToWidth(true);
            scroll.setFitToHeight(true);
            tabPane.getTabs().clear();
            tabPane.getTabs().add(new Tab("Clientes", scroll));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void abrirProductos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_producto.fxml"));
            loader.setControllerFactory(AppContext.getInstance()::getBean);
            Parent root = loader.load();

            ScrollPane scroll = new ScrollPane(root);
            scroll.setFitToWidth(true);
            scroll.setFitToHeight(true);
            tabPane.getTabs().clear();
            tabPane.getTabs().add(new Tab("Productos", scroll));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
