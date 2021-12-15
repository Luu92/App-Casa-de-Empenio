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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import mx.edu.uacm.ModelDTO.CrudProducto;
import mx.edu.uacm.ModelDTO.Producto;
import mx.edu.uacm.ModelDTO.ValidarDatos;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarProductoAltaFXMLController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    public TextField tfNumeroProducto;
    @FXML
    public ComboBox<String> cbCantidad;
    @FXML
    public TextField tfNombre;
    @FXML
    public TextField tfMarca;
    @FXML
    public TextField tfPrecio;
    @FXML
    private AnchorPane ap;

    File ruta;
    private final String[] cantidad = new String[100];
    ValidarDatos valida = new ValidarDatos();
    private final String ruta_txt = "productos.txt";
    CrudProducto rp = new CrudProducto();
    Producto p = new Producto();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 100; i++) {
            cantidad[i] = (i + 1) + "";
        }
        cbCantidad.getItems().addAll(cantidad);
        cargar_txt();
    }

    @FXML
    private void btningresarRegistro(MouseEvent event) {
        try {
            if (tfNombre.getText().isEmpty()) {
                mensaje("Ingresar Nombre");
            } else if (tfMarca.getText().isEmpty()) {
                mensaje("Ingresar Marca");
            } else if (cbCantidad.getValue().isEmpty()) {
                mensaje("Ingresar Cantidad");
            } else if (tfPrecio.getText().isEmpty()) {
                mensaje("Ingresar Precio");
            } else {
                p = new Producto(leerNumeroProducto(), leerNombre(), leerCantidad(), leerPrecio(), leerMarca());
                rp.agregarRegistro(p);
                grabar_txt();
                Limpiar();
                CrudProducto n = new CrudProducto();
                n.imprimeArray();
                JOptionPane.showMessageDialog(null, "¡Producto Agregado!", "Alta de Producto", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    @FXML
    private void btnseleccionaRegresar(MouseEvent event) {
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProducto2FXML.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
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
                p = new Producto();
                //int n = (int) (Math.random() * (999 - 1)) + 1;
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

    public void grabar_txt() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for (int i = 0; i < rp.cantidadRegistro(); i++) {
                p = rp.obtenerRegistro(i);
                pw.println(String.valueOf(p.getNumProducto() + ", " + p.getNombre() + ", " + p.getMarca() + ", " + p.getCantidad() + ", " + p.getPrecio()));
            }
            pw.close();

        } catch (IOException | HeadlessException ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public int leerNumeroProducto() {
        try {
            int numero = Integer.parseInt(tfNumeroProducto.getText().trim());
            return numero;
        } catch (Exception ex) {
            return -666;
        }
    }

    public String leerNombre() {
        try {
            String nombre = tfNombre.getText();
            return nombre;
        } catch (Exception ex) {
            return null;
        }
    }

    public String leerMarca() {
        try {
            String marca = tfMarca.getText();
            return marca;
        } catch (Exception e) {
            return null;
        }
    }

    public String leerCantidad() {
        try {
            String cantidadProducto = cbCantidad.getValue();
            return cantidadProducto;
        } catch (Exception ex) {
            return null;
        }
    }

    public String leerPrecio() {
        try {
            String precio = tfPrecio.getText();
            return precio;
        } catch (Exception ex) {
            return null;
        }
    }

    public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void Limpiar() {
        tfNombre.setText(null);
        tfMarca.setText(null);
        cbCantidad.setValue(null);
        tfPrecio.setText(null);
        tfNumeroProducto.setText(null);
    }

}
