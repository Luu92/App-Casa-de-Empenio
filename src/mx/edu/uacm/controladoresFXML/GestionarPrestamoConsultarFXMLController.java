/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mx.edu.uacm.ModelDTO.Cliente;
import mx.edu.uacm.ModelDTO.Prestamo;

/**
 * FXML Controller class
 *
 * @author Internet
 */
public class GestionarPrestamoConsultarFXMLController implements Initializable {

    @FXML
    private ImageView btnRegresar;
    @FXML
    private Button btnBuscar;

    public List<Prestamo> listaPrestamos;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void regresarVentana(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/GestionarPrestamoFXML.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void bucarPrestamo(ActionEvent event) {
        
        
        
    }
    
}
