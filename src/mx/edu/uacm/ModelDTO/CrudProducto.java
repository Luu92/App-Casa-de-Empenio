/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.ModelDTO;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DevLuu
 */
public class CrudProducto {

    private ArrayList<Producto> a = new ArrayList<>();

    File ruta_txt = new File("productosActual.txt");
    Producto p = new Producto();

    public CrudProducto() {
    }

    public CrudProducto(ArrayList<Producto> a) {
        this.a = a;
    }

    public void agregarRegistro(Producto p) {
        this.a.add(p);
    }

    public void modificarRegistro(int i, Producto p) {
        this.a.set(i, p);
    }

    public void eliminarRegistro(int i) {
        this.a.remove(i);
    }

    public Producto obtenerRegistro(int i) {
        return (Producto) a.get(i);
    }

    public ArrayList<Producto> getA() {
        return a;
    }

    public int cantidadRegistro() {
        return this.a.size();
    }

    public int buscaNumProducto(int num) {
        for (int i = 0; i < cantidadRegistro(); i++) {
            if (num == obtenerRegistro(i).getNumProducto()) {
                return i;
            }
        }
        return -1;
    }

    public void imprimeArray() {
        System.out.println(a.toString());
    }

    public void borrarProducto(String elemento) {
        a.remove(elemento);

        ArrayList<Producto> copia = a;
        a = new ArrayList<>();

        agregarRegistro(p);
        grabar_txt();

    }

    public void grabar_txt() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for (int i = 0; i < cantidadRegistro(); i++) {
                p = obtenerRegistro(i);
                pw.println(String.valueOf(p.getNumProducto() + ", " + p.getNombre() + ", " + p.getMarca() + ", " + p.getCantidad() + ", " + p.getPrecio()));
            }
            pw.close();

        } catch (IOException | HeadlessException ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

}
