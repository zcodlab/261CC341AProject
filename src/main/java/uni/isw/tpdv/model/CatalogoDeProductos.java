/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.tpdv.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CatalogoDeProductos {
    private List<EspecificacionDeProducto> listaProducto;

    public CatalogoDeProductos() {
        this.listaProducto = new ArrayList<>();
    }
    
    public void agregarProducto(EspecificacionDeProducto producto){
        listaProducto.add(producto);
    }
    public EspecificacionDeProducto getEspecificacion(int cup){
        for(EspecificacionDeProducto ep: listaProducto){
            if(ep.getCup()==cup)
                return ep;
        }
        return null;
    }
    
}
