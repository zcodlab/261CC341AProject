/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.tpdv.model;

/**
 *
 * @author HP
 */
public class EspecificacionDeProducto {
    private int cup;
    private String descripcion;
    private double precio;

    public EspecificacionDeProducto(int cup, String descripcion, double precio) {
        this.cup = cup;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCup() {
        return cup;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    
    
    
}
