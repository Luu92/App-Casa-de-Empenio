/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarPrestamoCrearFXMLController implements Initializable {

    @FXML
    private TextField clienteNombre;
    @FXML
    private TextField clienteApellido;
    @FXML
    private TextField avalNombre;
    @FXML
    private TextField avalApellido;
    @FXML
    private Label idPrestamo;
    @FXML
    private TextField cantidadField;
    @FXML
    private MenuButton plazoPago;
    @FXML
    private Label totalPago;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int num1 = 1;
       int num2 = 1000;
       idPrestamo.setText("P-" + (int)Math.floor(Math.random()*(num1-num2)+num2));
        MenuItem plazo1 = new MenuItem("3");
        MenuItem plazo2 = new MenuItem("6");
        MenuItem plazo3 = new MenuItem("9");
        MenuItem plazo4 = new MenuItem("12");
       plazoPago.getItems().add(plazo1);
       plazoPago.getItems().add(plazo2);
       plazoPago.getItems().add(plazo3);
       plazoPago.getItems().add(plazo4);
    }    

    @FXML
    private void guardarRegistro(MouseEvent event) {
        
    }

    @FXML
    private void carcelarRegistro(MouseEvent event) {
    }
    
}
