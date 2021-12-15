/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.ModelDTO;

/**
 *
 * @author Internet
 */
public class Personal {

    private int numEmpleado;
    private String nombre;
    private String apellido;
    private String edad;
    private String telefono;

    public Personal() {
    }

    public Personal(int numEmpleado, String nombre, String apellido, String edad, String telefono) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return numEmpleado + ", " + nombre + ", " + apellido + ", " + edad + ", " + telefono + "\n";
    }
}
