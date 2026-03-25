package uni.isw.pe.controller;

import uni.isw.pe.model.Producto;

public interface VentaControllerListener {
    void onProductoSeleccionado(Producto p);
    void onAgregarProducto();
    void onProcesarVenta();
}
