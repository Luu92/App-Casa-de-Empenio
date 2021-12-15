/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.controladoresFXML;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.stream.Stream;
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
import mx.edu.uacm.ModelDTO.CrudProducto;
import mx.edu.uacm.ModelDTO.Producto;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarProductoBajaFXMLController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private AnchorPane ap;
    @FXML
    private TableView tvProducto;
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

    CrudProducto rp = new CrudProducto();
    Producto p = new Producto();
    private final String ruta_txt = "productos.txt";
    File ruta;
    int clic_tabla;
    private ObservableList<Producto> listaProducto = null;
    int indexSelect;
    @FXML
    private Pane paneTitle;
    @FXML
    private Label lbTitle1;
    @FXML
    private Label lbTitle2;
    @FXML
    private Button btnBajaEmp;
    @FXML
    private Label lbTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargar_txt();
        llenarTabla();
    }

    @FXML
    private void btnborrar(MouseEvent event) {
        listaProducto.remove(indexSelect);
    }

    @FXML
    private void btnseleccionaRegresar(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionar_Producto.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            GestionarProductoFXMLController controlador = (GestionarProductoFXMLController) loader.getController();

            ap.getChildren().clear();
            ap.getChildren().add(root);

            grabar_txt();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void borrarRegistro(MouseEvent event) {
        indexSelect= tvProducto.getSelectionModel().getSelectedIndex();
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

    public Stream<String> leerAchivoExterno(String ruta) {
        Stream<String> lineas = null;

        try {
            lineas = Files.lines(Paths.get(ruta_txt), Charset.forName("UTF-8"));
        } catch (IOException ex) {
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lineas;
    }

    public void grabar_txt() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for (int i = 0; i < (rp.cantidadRegistro() - 1); i++) {
                p = rp.obtenerRegistro(i);
                pw.println(String.valueOf(p.getNumProducto() + ", " + p.getNombre() + ", " + p.getMarca() + ", " + p.getCantidad() + ", " + p.getPrecio()));
            }
            pw.close();

        } catch (IOException | HeadlessException ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
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

        tvProducto.setItems(listaProducto);

    }

}
