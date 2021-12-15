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
import javafx.scene.control.TextField;
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
public class GestionarPersonalModificarFXMLController implements Initializable {

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
    private Label lbNombre;
    @FXML
    private Label lbApellido;
    @FXML
    private Label lbTel;
    @FXML
    private Label lbEmpleado;
    @FXML
    private Label lbEdad;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfTelefono;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField tfEdad;
    @FXML
    private Label tfNumero;

    private final String ruta_txt = "empleados.txt";
    Personal p = new Personal();
    Crud rp = new Crud();
    File ruta;
    private ObservableList<Personal> listaPersonal = null;
    int indexSelect;
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
    private void tablaSeleccionaRegistro(MouseEvent event) {
        Object newValue = null;
        indexSelect = tvTabla.getSelectionModel().getSelectedIndex();

        String nombre = tcNombre.getCellData(indexSelect);
        String apellido = tcApellido.getCellData(indexSelect);
        String edad = tcEdad.getCellData(indexSelect);
        String tel = tcTel.getCellData(indexSelect);
        String num = tcNumero.getCellData(indexSelect).toString();

        tfNombre.setText(nombre);
        tfApellido.setText(apellido);
        tfEdad.setText(edad);
        tfTelefono.setText(tel);
        tfNumero.setText(num);
    }

    @FXML
    private void btnmodificarRegistro(MouseEvent event) {
         try{
                int numero = rp.buscaNumEmpleado(leerNumeroEmpleado());
                p = new Personal(Integer.parseInt(tfNumero.getText().trim()), tfNombre.getText().trim(),tfApellido.getText().trim() ,tfEdad.getText().trim(), tfTelefono.getText().trim());
                
                if(numero == -1)rp.agregarRegistro(p);
                else rp.modificarRegistro(numero, p);
                
                grabar_txt();
                JOptionPane.showMessageDialog(null, "Modificacion Exitosa","Alta de Personal",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }

    @FXML
    private void btnseleccionaRegresar(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionarPersonalFXML.fxml"));
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
    
    public int leerNumeroEmpleado(){
        try{
            int numero = Integer.parseInt(tfNumero.getText().trim());
            return numero;
        }catch(Exception ex){
            return -666;
        }
    }
    
     public void grabar_txt(){
        FileWriter fw;
        PrintWriter pw;
        try{
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);
            
            for(int i = 0; i < rp.cantidadRegistro(); i++){
                p = rp.obtenerRegistro(i);
                pw.println(String.valueOf(p.getNumEmpleado()+", "+p.getNombre()+", "+p.getApellido()+", "+p.getEdad()+", "+p.getTelefono()));
            }
             pw.close();
            
        }catch(IOException | HeadlessException ex){
            mensaje("Error al grabar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
     
    public void vaciarCampos(){
        tfNombre.setText(null);
        tfApellido.setText(null);
        tfEdad.setText(null);
        tfTelefono.setText(null);
        tfNumero.setText(null);
        
    } 
    
}
