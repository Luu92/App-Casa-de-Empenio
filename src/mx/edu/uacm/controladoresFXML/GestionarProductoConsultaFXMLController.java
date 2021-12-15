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
import mx.edu.uacm.ModelDTO.CrudProducto;
import mx.edu.uacm.ModelDTO.Producto;

/**
 * FXML Controller class
 *
 * @author DevLuu
 */
public class GestionarProductoConsultaFXMLController implements Initializable {

    @FXML    private Button btnRegresar;
    @FXML    private AnchorPane ap;
    @FXML    private TableView tvTabla;
    @FXML    private TableColumn<Producto,Integer> tcNumero;
    @FXML    private TableColumn<Producto,String> tcNombre;
    @FXML    private TableColumn<Producto,String> tcMarca;
    @FXML    private TableColumn<Producto,String> tcCantidad;
    @FXML    private TableColumn<Producto,String> tcPrecio;
    
    private final String ruta_txt = "productos.txt"; 
    Producto p = new Producto();
    CrudProducto rp = new CrudProducto();
    File ruta;
    private ObservableList<Producto> listaPersonal = null;
    @FXML
    private Pane paneTitle;
    @FXML
    private Label lbTitle1;
    @FXML
    private Label lbTitle2;
    @FXML
    private Label lbTitle3;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargar_txt();
        llenarTabla();
    }    

    @FXML
    private void btnseleccionaRegresar(MouseEvent event) {
         try{
	        
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/uacm/vistasFXML/GestionarProductoFXML.fxml"));
	    AnchorPane root = (AnchorPane)loader.load();	
	        	
	    GestionarProductoFXMLController controlador = (GestionarProductoFXMLController)loader.getController();

	    ap.getChildren().clear();
	    ap.getChildren().add(root);
			      
	    } catch (IOException e) {

		e.printStackTrace();
	    }       
    }
    
    public void cargar_txt(){
         ruta = new File(ruta_txt);
        try{
            
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);
            
            
            String linea = null;
            while((linea = bu.readLine())!=null){
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
        }catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
    private void llenarTabla() {  
           
            listaPersonal = FXCollections.observableArrayList(rp.getA());
            
            tcNumero.setCellValueFactory(new PropertyValueFactory<>("numProducto"));
            tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tcMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
            tcCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
            tcPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
            
            tvTabla.setItems(listaPersonal);
            
    }
    
}
