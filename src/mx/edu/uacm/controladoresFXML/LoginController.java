/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.awt.event.ActionEvent;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void mostrarMensaje(ActionEvent event){
        Pattern expresion = Pattern.compile("^[a-z]{5}[0-9]{1,2}");
        Matcher validator = expresion.matcher(etiquetaUsuario.getText());
        if(!etiquetaUsuario.getText().isEmpty() && validator.matches() && !etiquetaContra.getText().isEmpty()){
            /*En esta parte metemos la vista*/
            try {
                
                Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                /*
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menuFXML.fxml"));
                Parent root = loader.load();
               // MenuFXMLController ventanaMenu = (MenuFXMLController)loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage nuevoStage = (Stage) btnLogin.getScene().getWindow();
                nuevoStage.close();*/
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            JOptionPane.showMessageDialog(null,"Iniciando Sesión");
        }
        else{
            
            JOptionPane.showMessageDialog(null,"Revisar Usuario y Contraseña","Error", JOptionPane.WARNING_MESSAGE);
        }     
    }

    @FXML
    private void mostrarMensaje(javafx.event.ActionEvent event) {
        Pattern expresion = Pattern.compile("^[a-z]{5}[0-9]{1,2}");
        Matcher validator = expresion.matcher(etiquetaUsuario.getText());
        if(!etiquetaUsuario.getText().isEmpty() && validator.matches() && !etiquetaContra.getText().isEmpty()){
            /*En esta parte metemos la vista*/
            try {
                
                Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("/mx/edu/uacm/vistasFXML/menuFXML.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                /*
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menuFXML.fxml"));
                Parent root = loader.load();
               // MenuFXMLController ventanaMenu = (MenuFXMLController)loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage nuevoStage = (Stage) btnLogin.getScene().getWindow();
                nuevoStage.close();*/
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Iniciando Sesión");
        }
        else{
            
            JOptionPane.showMessageDialog(null,"Revisar Usuario y Contraseña","Error", JOptionPane.WARNING_MESSAGE);
        }  
        
    }
}
