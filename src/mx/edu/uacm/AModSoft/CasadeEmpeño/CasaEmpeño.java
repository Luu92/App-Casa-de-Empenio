/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.AModSoft.CasadeEmpeño;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Internet
 */
public class CasaEmpeño extends Application {
    @Override
    public void start(Stage arg0) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            arg0.setScene(scene);
            arg0.setTitle("Sistema Casa de Empeño");
            arg0.setResizable(false);
            arg0.getIcons().add(new Image(CasaEmpeño.class.getResourceAsStream("/mx/edu/uacm/img/intercambio.png")));
            arg0.show();
        } catch (IOException error) {
            System.out.println("Error al cargar la vista " + error);
        }

    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
