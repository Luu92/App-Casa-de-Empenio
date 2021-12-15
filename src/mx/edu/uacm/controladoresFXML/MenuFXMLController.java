/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mx.edu.uacm.AModSoft.CasadeEmpeño.CasaEmpeño;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class MenuFXMLController implements Initializable {

    @FXML
    private Label idUsuario;
    @FXML
    private Button btnGesPersonal;
    @FXML
    private Button btnGesCompra;
    @FXML
    private Button btnGesPrestamo;
    
    public String usuario;

    public void setIdUsuario(String idUsuario) {
        this.idUsuario.setText("Hola");
    }
    
    @FXML
    private void gestionarPersonal(ActionEvent event) {
         try {
                Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/GestionarPersonalFXML.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
              
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    
    
    }

    @FXML
    private void gestionarCompra(ActionEvent event) {
    }

    @FXML
    private void gestionarPrestamo(ActionEvent event) {
        
        try {
                Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/gestionarPrestamoFXML.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
              
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idUsuario.setText("Hola");
    }

}
