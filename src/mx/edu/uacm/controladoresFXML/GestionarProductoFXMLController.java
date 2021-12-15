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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarProductoFXMLController implements Initializable {

    @FXML
    private Pane paneTitle;
    @FXML
    private Label lbTitle;
    @FXML
    private Button btnAlta;
    @FXML
    private Button btnBaja;
    @FXML
    private Button btnMod;
    @FXML
    private Button btnCons;
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
    private void btnseleccionaAlta(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProductoAltaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnseleccionaBaja(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProductoBajaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnseleccionaModificar(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProductoModificarFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnseleccionaConsultar(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProductoConsultaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            GestionarProductoConsultaFXMLController controlador = (GestionarProductoConsultaFXMLController) loader.getController();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void regresa(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/menuFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
