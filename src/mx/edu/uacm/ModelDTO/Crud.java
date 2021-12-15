package mx.edu.uacm.ModelDTO;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author DevSolutions
 */
public class Crud {

    private ArrayList<Personal> a = new ArrayList<>();
    // FXMLPersonalAltaController n = new FXMLPersonalAltaController();
    File ruta_txt = new File("empleadosActual.txt");
    Personal p = new Personal();

    public Crud() {
    }

    public Crud(ArrayList<Personal> a) {
        this.a = a;
    }

    public void agregarRegistro(Personal p) {
        this.a.add(p);
    }

    public void modificarRegistro(int i, Personal p) {
        this.a.set(i, p);
    }

    public void eliminarRegistro(int i) {
        this.a.remove(i);
    }

    public Personal obtenerRegistro(int i) {
        return (Personal) a.get(i);
    }

    public ArrayList<Personal> getA() {
        return a;
    }

    public void setA(ArrayList<Personal> a) {
        this.a = a;
    }

    public int cantidadRegistro() {
        return this.a.size();
    }

    public int buscaNumEmpleado(int num) {
        for (int i = 0; i < cantidadRegistro(); i++) {
            if (num == obtenerRegistro(i).getNumEmpleado()) {
                return i;
            }
        }
        return -1;
    }

}
