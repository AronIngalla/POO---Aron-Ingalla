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
import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import java.io.IOException;

public class MainGuiController {

    @FXML TabPane tabPane;
    @FXML MenuItem menuItem1, menuItem2, menuItem3, menuItem4;

    @FXML
    public void initialize() {
        menuItem1.setOnAction(e -> abrirProductos(LineaNegocio.TECNOLOGIA));
        menuItem2.setOnAction(e -> abrirProductos(LineaNegocio.MOTOS));
        menuItem3.setOnAction(e -> abrirProductos(LineaNegocio.TECNOLOGIA_DOMESTICA));
        menuItem4.setOnAction(e -> { Platform.exit(); System.exit(0); });
    }

    /** Carga el mismo formulario de productos, configurado para la línea elegida. */
    private void abrirProductos(LineaNegocio linea) {
        try {
            AppContext context = AppContext.getInstance();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_producto.fxml"));
            loader.setControllerFactory(tipo -> tipo == ProductoController.class
                    ? context.crearProductoController(linea)
                    : context.getBean(tipo));
            Parent root = loader.load();

            ScrollPane scroll = new ScrollPane(root);
            scroll.setFitToWidth(true);
            scroll.setFitToHeight(true);
            tabPane.getTabs().clear();
            tabPane.getTabs().add(new Tab(linea.getTitulo(), scroll));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
