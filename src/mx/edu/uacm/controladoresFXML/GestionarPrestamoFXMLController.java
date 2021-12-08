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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarPrestamoFXMLController implements Initializable {

    @FXML
    private Button btnCrear;
    @FXML
    private Button btnConsultar;
    @FXML
    private ImageView btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearPrestamo(MouseEvent event) {
    }

    @FXML
    private void consultarPrestamo(MouseEvent event) {
    }

    @FXML
    private void regresarVentana(MouseEvent event) {
        
    }
    
}
