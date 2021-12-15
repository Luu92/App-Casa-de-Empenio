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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import mx.edu.uacm.ModelDTO.Crud;
import mx.edu.uacm.ModelDTO.Personal;
import mx.edu.uacm.ModelDTO.ValidarDatos;

/**
 *
 * @author Internet
 */
class FXMLPersonalAltaController {

    @FXML
    private Button btnRegresar;
    @FXML
    public ComboBox<String> cbEdad;
    @FXML
    public TextField tfNombre;
    @FXML
    public TextField tfApellido;
    @FXML
    public TextField tfTel;
    @FXML
    private AnchorPane ap;
    @FXML
    public Label tfNumero;

    File ruta;
    String generaEmpString;

    private final String[] edad = {"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45"};

    private final String ruta_txt = "empleados.txt";

    Crud rp = new Crud();
    Personal p = new Personal();
    ValidarDatos d = new ValidarDatos();

    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        cbEdad.getItems().addAll(edad);
        cargar_txt();
        generaNoEmpleado();
        leerNumeroEmpleado();

    }
    
    @FXML
    private void seleccionaRegresar() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionar_Personal.fxml"));
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
        } catch (IOException | NumberFormatException ex) {
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
                pw.println(String.valueOf(p.getNumEmpleado() + ", " + p.getNombre() + ", " + p.getApellido() + ", " + p.getEdad() + ", " + p.getTelefono()));
            }
            pw.close();

        } catch (IOException | HeadlessException ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void ingresarRegistro() {
        try {
            if (tfNombre.getText().isEmpty() || !ValidarDatos.validarNombre(tfNombre.getText())) {
                JOptionPane.showMessageDialog(null, "Campo vacio o formato incorrecto", "Nombre", JOptionPane.INFORMATION_MESSAGE);
            } else if (tfApellido.getText().isEmpty() || !ValidarDatos.validarApellidos(tfApellido.getText())) {
                JOptionPane.showMessageDialog(null, "Campo vacio o formato incorrecto", "Apellido", JOptionPane.INFORMATION_MESSAGE);
            } else if (cbEdad.getValue().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vacio o formato incorrecto", "Edad", JOptionPane.INFORMATION_MESSAGE);
            } else if (tfTel.getText().isEmpty() || !ValidarDatos.validarTelefono(tfTel.getText())) {
                JOptionPane.showMessageDialog(null, "Campo vacio o formato incorrecto", "Telefono", JOptionPane.INFORMATION_MESSAGE);
            } else {
                p = new Personal(leerNumeroEmpleado(), leerNombre(), leerApellido(), leerEdad(), leerTelefono());
                rp.agregarRegistro(p);

                grabar_txt();
                vaciarCampos();
                Crud n = new Crud();
                JOptionPane.showMessageDialog(null, "¡Empleado Agregado!", "Alta de Personal", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    public int leerNumeroEmpleado() {
        String num = generaEmpString;
        try {
            tfNumero.setText(num);
            int numero = Integer.parseInt(num);
            return numero;
        } catch (Exception ex) {
            return -666;
        }
    }

    public String leerNombre() {
        try {
            String nombre = tfNombre.getText().trim();
            return nombre;
        } catch (Exception ex) {
            return null;
        }
    }

    public String leerApellido() {
        try {
            String apellido = tfApellido.getText().trim();
            return apellido;
        } catch (Exception e) {
            return null;
        }
    }

    public String leerEdad() {
        try {
            String edadPersonal = cbEdad.getValue().trim();
            return edadPersonal;
        } catch (Exception ex) {
            return null;
        }
    }

    public String leerTelefono() {
        try {
            String tel = tfTel.getText().trim();
            return tel;
        } catch (Exception ex) {
            return null;
        }
    }

    public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);

    }

    public void vaciarCampos() {
        tfNombre.setText(null);
        tfApellido.setText(null);
        cbEdad.setValue(null);
        tfTel.setText(null);
        generaNoEmpleado();
        tfNumero.setText(generaEmpString);

    }

    public String generaNoEmpleado() {
        int M = 1000;
        int N = 9999;
        int generaNumero = (int) Math.floor(Math.random() * (N - M + 1) + M);
        generaEmpString = String.valueOf(generaNumero);

        return generaEmpString;
    }
    
    

}
