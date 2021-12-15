/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Internet
 */
public class LoginController implements Initializable {

    
    @FXML
    private Button btnLogin;
    @FXML
    private TextField etiquetaUsuario;
    @FXML
    private PasswordField etiquetaContra;
    @FXML
    private AnchorPane ap;

    public TextField getEtiquetaUsuario() {
        return etiquetaUsuario;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarMensaje(javafx.event.ActionEvent event) {
        Pattern expresion = Pattern.compile("^[a-z]{5}[0-9]{1,2}");
        Matcher validator = expresion.matcher(etiquetaUsuario.getText());
        if(!etiquetaUsuario.getText().isEmpty() && validator.matches() && !etiquetaContra.getText().isEmpty()){
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/menuFXML.fxml"));
                AnchorPane root = (AnchorPane) loader.load();

                MenuFXMLController controlador = (MenuFXMLController) loader.getController();
                controlador.setIdUsuario(etiquetaUsuario.getText());
                ap.getChildren().clear();
                ap.getChildren().add(root);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{
            
            JOptionPane.showMessageDialog(null,"Revisar Usuario y Contraseña","Error", JOptionPane.WARNING_MESSAGE);
        }  
        
    }
}
