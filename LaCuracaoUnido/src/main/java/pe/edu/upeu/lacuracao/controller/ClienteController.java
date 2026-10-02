package pe.edu.upeu.lacuracao.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import pe.edu.upeu.lacuracao.components.ColumnInfo;
import pe.edu.upeu.lacuracao.components.TableViewHelper;
import pe.edu.upeu.lacuracao.components.Toast;
import pe.edu.upeu.lacuracao.components.ToltipCustom;
import pe.edu.upeu.lacuracao.model.Cliente;
import pe.edu.upeu.lacuracao.service.IClienteService;

import java.util.*;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService cs;

    @FXML
    private TextField txtDni, txtNumero, txtNombres;

    @FXML
    private TableView<Cliente> tableView;

    @FXML
    private Label lbnMsg;

    @FXML
    private AnchorPane miContenedor;

    private final ToltipCustom ttc = new ToltipCustom();

    private Validator validator;
    private ObservableList<Cliente> listarCliente;
    private Cliente formulario;
    private Long idClienteCE = 0L;
    private Stage stage;

    @FXML
    public void initialize() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TableViewHelper<Cliente> tableViewHelper = new TableViewHelper<>();

        LinkedHashMap<String, ColumnInfo> columns = new LinkedHashMap<>();
        columns.put("ID", new ColumnInfo("idCliente", 60.0));
        columns.put("DNI", new ColumnInfo("dni", 130.0));
        columns.put("Número", new ColumnInfo("numero", 150.0));
        columns.put("Nombres", new ColumnInfo("nombres", 260.0));

        Consumer<Cliente> updateAction = this::editForm;

        Consumer<Cliente> deleteAction = cliente -> {
            stage = (Stage) miContenedor.getScene().getWindow();
            cs.delete(cliente.getIdCliente());
            double w = stage.getWidth() / 1.5;
            double h = stage.getHeight() / 2;
            Toast.showToast(stage, "Se eliminó correctamente", 2000, w, h);
            listar();
        };

        tableViewHelper.addColumnsInOrderWithSize(
                tableView, columns, updateAction, deleteAction
        );

        tableView.setTableMenuButtonVisible(true);
        listar();
    }

    public void listar() {
        try {
            tableView.getItems().clear();
            listarCliente = FXCollections.observableArrayList(cs.findAll());
            tableView.getItems().addAll(listarCliente);
        } catch (Exception e) {
            e.printStackTrace();
            lbnMsg.setText("No se pudo cargar la tabla");
            lbnMsg.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
        }
    }

    @FXML
    public void validarFormulario() {
        formulario = new Cliente();
        formulario.setDni(txtDni.getText().trim());
        formulario.setNumero(txtNumero.getText().trim());
        formulario.setNombres(txtNombres.getText().trim());

        Set<ConstraintViolation<Cliente>> violaciones = validator.validate(formulario);

        List<ConstraintViolation<Cliente>> ordenadas = violaciones.stream()
                .sorted(Comparator.comparing(v -> v.getPropertyPath().toString()))
                .toList();

        if (ordenadas.isEmpty()) {
            procesarFormulario();
        } else {
            mostrarErroresValidacion(ordenadas);
        }
    }

    private void mostrarErroresValidacion(List<ConstraintViolation<Cliente>> violaciones) {
        limpiarError();

        Map<String, Control> campos = new LinkedHashMap<>();
        campos.put("dni", txtDni);
        campos.put("numero", txtNumero);
        campos.put("nombres", txtNombres);

        final Control[] primerCtrl = {null};

        for (String campo : campos.keySet()) {
            violaciones.stream()
                    .filter(v -> v.getPropertyPath().toString().equals(campo))
                    .findFirst()
                    .ifPresent(v -> {
                        Control c = campos.get(campo);
                        if (c != null) {
                            ttc.marcarError(c, v.getMessage().trim());
                            if (primerCtrl[0] == null) {
                                primerCtrl[0] = c;
                            }
                        }
                    });
        }

        if (!violaciones.isEmpty()) {
            lbnMsg.setText(violaciones.get(0).getMessage());
            lbnMsg.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            if (primerCtrl[0] != null) {
                Platform.runLater(primerCtrl[0]::requestFocus);
            }
        }
    }

    private void procesarFormulario() {
        stage = (Stage) miContenedor.getScene().getWindow();

        try {
            if (idClienteCE > 0L) {
                formulario.setIdCliente(idClienteCE);
                cs.update(idClienteCE, formulario);
                mostrarMensaje("Cliente actualizado correctamente", true);
                Toast.showToast(stage, "Se actualizó correctamente", 2000,
                        stage.getWidth() / 1.5, stage.getHeight() / 2);
            } else {
                cs.save(formulario);
                mostrarMensaje("Cliente guardado correctamente", true);
                Toast.showToast(stage, "Se guardó correctamente", 2000,
                        stage.getWidth() / 1.5, stage.getHeight() / 2);
            }

            clearForm();
            listar();

        } catch (Exception e) {
            lbnMsg.setText("No se pudo guardar el cliente: " + e.getMessage());
            lbnMsg.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");
        }
    }

    public void editForm(Cliente cliente) {
        txtDni.setText(cliente.getDni());
        txtNumero.setText(cliente.getNumero());
        txtNombres.setText(cliente.getNombres());
        idClienteCE = cliente.getIdCliente();
        limpiarError();
    }

    @FXML
    public void clearForm() {
        txtDni.clear();
        txtNumero.clear();
        txtNombres.clear();
        idClienteCE = 0L;
        lbnMsg.setText("");
        limpiarError();
    }

    private void mostrarMensaje(String mensaje, boolean correcto) {
        lbnMsg.setText(mensaje);
        lbnMsg.setStyle(correcto
                ? "-fx-text-fill: green; -fx-font-size: 16px;"
                : "-fx-text-fill: red; -fx-font-size: 16px;");
    }

    private void limpiarError() {
        List.of(txtDni, txtNumero, txtNombres).forEach(c -> {
            c.getStyleClass().remove("text-field-error");
            ttc.limpiarCampo(c);
        });
    }
}
