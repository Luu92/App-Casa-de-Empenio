/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Internet
 */
public class GestionarPersonalFXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button btnAlta;
    @FXML
    private Button btnBaja;
    @FXML
    private AnchorPane ap;
    @FXML
    private Pane paneTitle;
    @FXML
    private Label lbTitle;
    @FXML
    private Button btnMod;
    @FXML
    private Button btnCons;

    private void seleccionaAlta() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("mx/edu/uacm/vistasFXML/FXMLPersonaAlta.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            FXMLPersonalAltaController controlador = (FXMLPersonalAltaController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void seleccionaBaja() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLBaja_Personal.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            //FXMLBaja_PersonalController controlador = (FXMLBaja_PersonalController) loader.getController();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionaModificar() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLModificar.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            //FXMLModificarController controlador = (FXMLModificarController) loader.getController();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionaConsultar() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLConsultar.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            //FXMLConsultarController controlador = (FXMLConsultarController)loader.getController();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void seleccionaRegresar() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionar_Personal.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            //FXMLGestionar_PersonalController controlador = (FXMLGestionar_PersonalController)loader.getController();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void altaPersonal(javafx.event.ActionEvent event) {
        try {
            /*
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/FXMLPersonaAlta.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
             */
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mx/edu/uacm/vistasFXML/FXMLPersonaAlta.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            FXMLPersonalAltaController controlador = (FXMLPersonalAltaController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void bajaPersona(MouseEvent event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mx/edu/uacm/vistasFXML/FXMLPersonaAlta.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception error){
            error.printStackTrace(System.out);
        }
    }

}
