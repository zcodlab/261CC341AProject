/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.tpdv.controller;

import uni.isw.tpdv.model.CatalogoDeProductos;
import uni.isw.tpdv.model.EspecificacionDeProducto;
import uni.isw.tpdv.model.Pago;
import uni.isw.tpdv.model.Venta;

/**
 *
 * @author HP
 */
public class CC_tpdv {
    private Venta venta;
    private CatalogoDeProductos catalogo;

    public CC_tpdv(CatalogoDeProductos catalogo) {        
        this.catalogo = catalogo;
    }
    
    public void crearNuevaVenta(){
        venta=new Venta();
    }
    
    public void introducirProducto(int cup, int cantidad){
        EspecificacionDeProducto ep=catalogo.getEspecificacion(cup);
        if(ep!=null && venta!=null)
            venta.hacerLineaDeProducto(ep, cantidad);
    }
    
    public void terminarVenta(){
        if(venta!=null)
            venta.seTermina();
    }
    
    public void efectuarPago(double monto){
        if(venta!=null && venta.isEstaTerminada()){
            Pago pago=new Pago(monto);
            venta.efectuarPago(pago);
        }
    }
    
    public double getTotalVenta(){
        return (venta!=null) ? venta.total() : 0.0;
    }
    
}
