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
public class Prestamo {
    
    private String id;
    private Cliente cliente;
    private Aval aval;
    private float montoSolicitado; 
    private float totalPago;
    private int periodo;

    public Prestamo() {
    }

    public Prestamo(String id, Cliente cliente, Aval aval, float montoSolicitado, float totalPago, int periodo) {
        this.id = id;
        this.cliente = cliente;
        this.aval = aval;
        this.montoSolicitado = montoSolicitado;
        this.totalPago = totalPago;
        this.periodo = periodo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aval getAval() {
        return aval;
    }

    public void setAval(Aval aval) {
        this.aval = aval;
    }

    public float getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(float montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public float getTotaPago() {
        return totalPago;
    }

    public void setTotaPago(float totalPago) {
        this.totalPago = totalPago;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "==== Datos =====" + 
               "\nId: " + id + 
               "\nCliente: " + cliente.getNombre() + 
               "\nAval: " + aval.getNombre() + 
               "\nMontoSolicitado: " + montoSolicitado + 
               "\nTotal a Pagar: " + totalPago + 
               "\nPeriodo=" + periodo;
    }
    
    
    
}
