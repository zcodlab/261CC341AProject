/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.tpdv.view;

import uni.isw.tpdv.controller.CC_tpdv;
import uni.isw.tpdv.model.CatalogoDeProductos;
import uni.isw.tpdv.model.EspecificacionDeProducto;

/**
 *
 * @author HP
 */
public class IU_tpdv {
    private static CC_tpdv controlador;
    public static void main(String[] args){
        //1.Inicializar el Catalogo de Productos
        CatalogoDeProductos catalogo=new CatalogoDeProductos();
        catalogo.agregarProducto(new EspecificacionDeProducto(101,"Leche",3.50));
        catalogo.agregarProducto(new EspecificacionDeProducto(102,"Pan",0.50));
        catalogo.agregarProducto(new EspecificacionDeProducto(103,"Huevo x 12",6.00));        
        //controlador     
        controlador=new CC_tpdv(catalogo);
        //3.Simular una Venta
        System.out.println("Iniciando Nueva Venta");
        controlador.crearNuevaVenta();
        
        System.out.println("Agregando productos....");
        controlador.introducirProducto(101, 2);
        controlador.introducirProducto(102, 5);
        controlador.introducirProducto(103, 1);
        
        //4.Terminar venta
        controlador.terminarVenta();
        double total=controlador.getTotalVenta();
        System.out.println("Total de la Venta: S/." + total);
        
        //5.Efectuar Pago
        System.out.println("Efectuando Pago: S/." + total);
        controlador.efectuarPago(total);
        
        System.out.println("Venta Finalizada...");       
        
    }
    
}
