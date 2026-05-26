/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.tpdv.model;

/**
 *
 * @author HP
 */
public class VentasLineaDeProducto {
    private EspecificacionDeProducto producto;
    private int cantidad;    

    public VentasLineaDeProducto(EspecificacionDeProducto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }    
    //Por el patron experto
    public double subTotal(){
        return cantidad * producto.getPrecio();
    }
    
    
    
}
