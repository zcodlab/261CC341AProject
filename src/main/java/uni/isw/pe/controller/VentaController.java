package uni.isw.pe.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uni.isw.pe.model.Cliente;
import uni.isw.pe.model.Producto;
import uni.isw.pe.model.VentaCab;
import uni.isw.pe.model.VentaDet;
import uni.isw.pe.model.dao.ClienteDAO;
import uni.isw.pe.model.dao.ProductoDAO;
import uni.isw.pe.model.dao.VentaDAO;
import uni.isw.pe.view.IVentaView;

public class VentaController implements VentaControllerListener {
    private IVentaView view;
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;
    private VentaDAO ventaDAO;
    private List<VentaDet> detalles;
    private double total = 0.0;
    private int numeroVenta = 0;

    public VentaController(IVentaView view) {
        this.view = view;
        this.clienteDAO = new ClienteDAO();
        this.productoDAO = new ProductoDAO();
        this.ventaDAO = new VentaDAO();
        this.detalles = new ArrayList<>();

        this.view.setListener(this);
        initData();
    }

    private void initData() {
        try {
            view.setClientes(clienteDAO.listar());
            List<Producto> productos = productoDAO.listar();
            view.setProductos(productos);
            
            numeroVenta = ventaDAO.getSiguienteNumero();
            view.setProximoNumeroVenta(numeroVenta);
            
            if (!productos.isEmpty()) {
                view.setPrecioProducto(productos.get(0).getPrecio());
            }

        } catch (SQLException e) {
            view.mostrarError("Error al cargar datos iniciales: " + e.getMessage());
        }
    }

    @Override
    public void onProductoSeleccionado(Producto p) {
        if (p != null) {
            view.setPrecioProducto(p.getPrecio());
        }
    }

    @Override
    public void onAgregarProducto() {
        try {
            Producto p = view.getProductoSeleccionado();
            if (p == null) return;

            int cant = Integer.parseInt(view.getCantidad());
            double dscto = Double.parseDouble(view.getDescuento());
            double pu = p.getPrecio();
            double subtotal = (pu * cant) - dscto;

            VentaDet det = new VentaDet();
            det.setCodigo(p.getCodigo());
            det.setPu(pu);
            det.setDscto(dscto);
            det.setCantidad(cant);
            det.setSubtotal(subtotal);
            
            detalles.add(det);
            
            view.agregarDetalleATabla(p.getCodigo(), p.getDescripcion(), pu, cant, dscto, subtotal);
            
            total += subtotal;
            view.setTotal(total);
            
        } catch (NumberFormatException e) {
            view.mostrarError("Ingrese valores numéricos válidos en cantidad y descuento.");
        }
    }

    @Override
    public void onProcesarVenta() {
        if (detalles.isEmpty()) {
            view.mostrarError("Debe agregar al menos un producto.");
            return;
        }

        try {
            Cliente c = view.getClienteSeleccionado();
            if (c == null) return;
            
            VentaCab cab = new VentaCab();
            cab.setNumero(numeroVenta);
            cab.setFecha(new Date(System.currentTimeMillis()));
            cab.setDni(c.getDni());
            
            ventaDAO.registrarVenta(cab, detalles);
            
            view.mostrarMensaje("Venta registrada con éxito.");
            resetVenta();
            
        } catch (SQLException e) {
            view.mostrarError("Error al registrar venta: " + e.getMessage());
        }
    }

    private void resetVenta() throws SQLException {
        detalles.clear();
        total = 0.0;
        numeroVenta = ventaDAO.getSiguienteNumero();
        view.limpiarVenta(numeroVenta);
    }
}
