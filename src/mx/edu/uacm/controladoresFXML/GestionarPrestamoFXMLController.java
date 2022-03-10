/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearPrestamo(MouseEvent event) {
        try {
                Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/GestionarPrestamoCrearFXML.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
              
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

    @FXML
    private void consultarPrestamo(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/GestionarPrestamoConsultarFXML.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void regresarVentana(MouseEvent event) {
        try {
                Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/menuFXML.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
              
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
    
}
