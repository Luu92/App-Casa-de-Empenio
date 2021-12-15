/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class GestionarPersonalBajaFXMLController implements Initializable {

    @FXML
    private Pane paneTitle;
    @FXML
    private Label lbTitle1;
    @FXML
    private Label lbTitle2;
    @FXML
    private Button btnBajaEmp;
    @FXML
    private Button btnRegresar;
    @FXML
    private TableView<Personal> tvPersonal;
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
    private AnchorPane ap;

    Crud rp = new Crud();
    Personal p = new Personal();
    private final String ruta_txt = "empleados.txt";
    File ruta;
    private ObservableList<Personal> listaPersonal = null;
    int indexSelect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargar_txt();
        llenarTabla();
    }

    @FXML
    private void btnborrarRegistro(MouseEvent event) {
        listaPersonal.remove(indexSelect);
        try {
            int s = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este registro?", "Si/No", 0);
            if (s == 0) {
                rp.eliminarRegistro(indexSelect);

                grabar_txt();
            }

        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    @FXML
    private void btnRegresar(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarPersonaFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionaRegistro(MouseEvent event) {
        indexSelect = tvPersonal.getSelectionModel().getSelectedIndex();
        System.out.println("Seleccion" + indexSelect);
    }

    public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void cargar_txt() {
        ruta = new File(ruta_txt);
        try {

            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);

            String linea = null;
            while ((linea = bu.readLine().trim()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                p = new Personal();
                p.setNumEmpleado(Integer.parseInt(st.nextToken().trim()));
                p.setNombre(st.nextToken().trim());
                p.setApellido(st.nextToken().trim());
                p.setEdad(st.nextToken().trim());
                p.setTelefono(st.nextToken().trim());
                rp.agregarRegistro(p);
            }
            bu.close();
        } catch (Exception ex) {
            mensaje("Error al cargar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    private void llenarTabla() {

        listaPersonal = FXCollections.observableArrayList(rp.getA());

        tcNumero.setCellValueFactory(new PropertyValueFactory<>("numEmpleado"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tcTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tvPersonal.setItems(listaPersonal);

    }

    public void grabar_txt() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for (int i = 0; i < rp.cantidadRegistro(); i++) {
                p = rp.obtenerRegistro(i);
                pw.println(String.valueOf(p.getNumEmpleado() + ", " + p.getNombre() + ", " + p.getApellido() + ", " + p.getEdad() + ", " + p.getTelefono()));
            }
            pw.close();

        } catch (IOException | HeadlessException ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

}
