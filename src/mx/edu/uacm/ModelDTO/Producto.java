/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.ModelDTO;

/**
 *
 * @author DevLuu
 */
public class Producto {

    private int numProducto;
    private String nombre;
    private String cantidad;
    private String precio;
    private String marca;

    public Producto() {
    }

    public Producto(int numProducto, String nombre, String cantidad, String precio, String marca) {
        this.numProducto = numProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.marca = marca;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto{" + "numProducto=" + numProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", marca=" + marca + '}';
    }

}
