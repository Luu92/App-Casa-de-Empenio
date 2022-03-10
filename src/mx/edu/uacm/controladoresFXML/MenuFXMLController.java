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
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane ap;

    public void setIdUsuario(String idUsuario) {
        this.idUsuario.setText(idUsuario);
    }

    @FXML
    private void gestionarPersonal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void gestionarCompra(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProducto2FXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void gestionarPrestamo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPrestamoFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/GestionarPrestamoFXML.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
         */
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
