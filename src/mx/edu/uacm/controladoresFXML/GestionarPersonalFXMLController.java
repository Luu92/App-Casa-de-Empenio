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
public class GestionarPersonalFXMLController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Label label;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void altaPersonal(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonalAltaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            GestionarPersonalAltaFXMLController controlador = (GestionarPersonalAltaFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void bajaPersona(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonalBajaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            GestionarPersonalBajaFXMLController controlador = (GestionarPersonalBajaFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionaModificar(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonalModificarFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            GestionarPersonalModificarFXMLController controlador = (GestionarPersonalModificarFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionaConsultar(MouseEvent event) {
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonaConsultarFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            GestionarPersonaConsultarFXMLController controlador = (GestionarPersonaConsultarFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
        
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/menuFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            //GestionarPersonalFXMLController controlador = (GestionarPersonalFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    
}
