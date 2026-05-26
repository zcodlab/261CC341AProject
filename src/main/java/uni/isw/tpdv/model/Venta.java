/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.tpdv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class Venta {
    private Date fecha;
    private boolean estaTerminada;
    private List<VentasLineaDeProducto> ventaDet;
    private Pago pago;

    public Venta() {
        this.fecha = new Date();
        this.estaTerminada = false;
        this.ventaDet = new ArrayList<>();        
    }
    
    public void seTermina(){
        estaTerminada=true;
    }
    public boolean isEstaTerminada(){
        return estaTerminada;
    }
    //Por el patron Creador
    public void hacerLineaDeProducto(EspecificacionDeProducto producto,int cantidad){
        ventaDet.add(new VentasLineaDeProducto(producto,cantidad));
    }
    
    //Por el Patron Bajo Acoplamiento
    public void efectuarPago(Pago pago){
        this.pago=pago;
    }
    //Por Patron Experto
    public double total(){
        double total=0;
        for(VentasLineaDeProducto linea:ventaDet)
            total+=linea.subTotal();
        return total;
    }
    
}
