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
import mx.edu.uacm.ModelDTO.CrudProducto;
import mx.edu.uacm.ModelDTO.Producto;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarProductoModificarFXMLController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnActualizar;
    @FXML
    private AnchorPane ap;
    @FXML
    private TableView tvTabla;
    @FXML
    private TableColumn<Producto, Integer> tcNumProducto;
    @FXML
    private TableColumn<Producto, String> tcNombre;
    @FXML
    private TableColumn<Producto, String> tcMarca;
    @FXML
    private TableColumn<Producto, String> tcCantidad;
    @FXML
    private TableColumn<Producto, String> tcPrecio;
    @FXML
    public TextField tfNombre;
    @FXML
    public TextField tfMarca;
    @FXML
    public TextField tfPrecio;
    @FXML
    public TextField tfNumProducto;
    @FXML
    public TextField tfCantidad;

    private final String ruta_txt = "productos.txt";
    Producto p = new Producto();
    CrudProducto rp = new CrudProducto();
    File ruta;
    private ObservableList<Producto> listaProducto = null;
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
    private void seleccionaRegistro(MouseEvent event) {
        Object newValue = null;
        indexSelect = tvTabla.getSelectionModel().getSelectedIndex();

        String nombre = tcNombre.getCellData(indexSelect).toString();
        String apellido = tcMarca.getCellData(indexSelect).toString();
        String edad = tcCantidad.getCellData(indexSelect).toString();
        String tel = tcPrecio.getCellData(indexSelect).toString();
        String num = tcNumProducto.getCellData(indexSelect).toString();

        tfNombre.setText(nombre);
        tfMarca.setText(apellido);
        tfCantidad.setText(edad);
        tfPrecio.setText(tel);
        tfNumProducto.setText(num);
    }

    public int leerNumeroProducto() {
        try {
            int numero = Integer.parseInt(tfNumProducto.getText().trim());
            return numero;
        } catch (Exception ex) {
            return -666;
        }
    }

    @FXML
    private void btnseleccionaRegresar(MouseEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProductoFXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            //GestionarProductoAltaFXMLController controlador = (GestionarProductoAltaFXMLController) loader.getController();
            ap.getChildren().clear();
            ap.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnmodificarRegistro(MouseEvent event) {
        try {
            int numero = rp.buscaNumProducto(leerNumeroProducto());
            p = new Producto(Integer.parseInt(tfNumProducto.getText()), tfNombre.getText(), tfMarca.getText(), tfCantidad.getText(), tfPrecio.getText());

            if (numero == -1) {
                rp.agregarRegistro(p);
            } else {
                rp.modificarRegistro(numero, p);
            }

            grabar_txt();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa", "Alta de Producto", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
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
            while ((linea = bu.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                p = new Producto();
                p.setNumProducto(Integer.parseInt(st.nextToken()));
                p.setNombre(st.nextToken());
                p.setMarca(st.nextToken());
                p.setCantidad(st.nextToken());
                p.setPrecio(st.nextToken());
                rp.agregarRegistro(p);
            }
            bu.close();
        } catch (Exception ex) {
            mensaje("Error al cargar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    private void llenarTabla() {

        listaProducto = FXCollections.observableArrayList(rp.getA());

        tcNumProducto.setCellValueFactory(new PropertyValueFactory<>("numProducto"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        tcCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tvTabla.setItems(listaProducto);

    }

    public void grabar_txt() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for (int i = 0; i < (rp.cantidadRegistro()); i++) {
                p = rp.obtenerRegistro(i);
                pw.println(String.valueOf(p.getNumProducto() + ", " + p.getNombre() + ", " + p.getMarca() + ", " + p.getCantidad() + ", " + p.getPrecio()));
            }
            pw.close();

        } catch (IOException | HeadlessException ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void Limpiar() {
        tfNombre.setText(null);
        tfMarca.setText(null);
        tfCantidad.setText(null);
        tfPrecio.setText(null);
        tfNumProducto.setText(null);
    }

}
