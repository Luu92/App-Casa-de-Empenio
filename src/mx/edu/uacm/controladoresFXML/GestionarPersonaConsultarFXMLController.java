/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import mx.edu.uacm.ModelDTO.Crud;
import mx.edu.uacm.ModelDTO.Personal;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarPersonaConsultarFXMLController implements Initializable {

    @FXML
    private Pane paneTitle;
    @FXML
    private Label lbTitle1;
    @FXML
    private Label lbTitle2;
    @FXML
    private TableView tvTabla;
    @FXML
    private TableColumn<Personal, Integer> tcNumero;
    @FXML
    private TableColumn<Personal, String> tcNombre;
    @FXML
    private TableColumn<Personal, String> tcApellido;
    @FXML
    private TableColumn<Personal, String> tcEdad;
    @FXML
    private TableColumn<Personal, String> tcTel;
    @FXML
    private Label lbTitle3;
    @FXML
    private Button btnRegresar;

    private final String ruta_txt = "empleados.txt";
    Personal p = new Personal();
    Crud rp = new Crud();
    File ruta;
    private ObservableList<Personal> listaPersonal = null;
    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargar_txt();
        llenarTabla();
    }

    @FXML
    private void seleccionaRegresar(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            GestionarPersonalFXMLController controlador = (GestionarPersonalFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void cargar_txt() {
        ruta = new File(ruta_txt);
        try {

            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);

            String linea = null;
            while ((linea = bu.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                p = new Personal();
                p.setNumEmpleado(Integer.parseInt(st.nextToken()));
                p.setNombre(st.nextToken());
                p.setApellido(st.nextToken());
                p.setEdad(st.nextToken());
                p.setTelefono(st.nextToken());
                rp.agregarRegistro(p);
            }
            bu.close();
        } catch (Exception ex) {
            mensaje("Error al cargar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    private void llenarTabla() {

        listaPersonal = FXCollections.observableArrayList(rp.getA());

        tcNumero.setCellValueFactory(new PropertyValueFactory<>("numEmpleado"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tcTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tvTabla.setItems(listaPersonal);

    }

}
