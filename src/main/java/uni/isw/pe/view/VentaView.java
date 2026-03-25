package uni.isw.pe.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import uni.isw.pe.controller.VentaControllerListener;
import uni.isw.pe.model.Cliente;
import uni.isw.pe.model.Producto;

public class VentaView extends JFrame implements IVentaView {
    private JComboBox<Cliente> cbClientes;
    private JComboBox<Producto> cbProductos;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtDescuento;
    private JTable tblDetalles;
    private DefaultTableModel tableModel;
    private JButton btnAgregar;
    private JButton btnProcesar;
    private JLabel lblTotal;
    private JLabel lblNumeroVenta;
    private VentaControllerListener listener;

    public VentaView() {
        setTitle("Sistema de Ventas - MVC");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pnlNorte = new JPanel(new GridLayout(4, 2));
        pnlNorte.add(new JLabel("Cliente:"));
        cbClientes = new JComboBox<>();
        pnlNorte.add(cbClientes);

        pnlNorte.add(new JLabel("Venta Nº:"));
        lblNumeroVenta = new JLabel("0");
        pnlNorte.add(lblNumeroVenta);

        pnlNorte.add(new JLabel("Producto:"));
        cbProductos = new JComboBox<>();
        pnlNorte.add(cbProductos);
        
        btnAgregar = new JButton("Agregar al carrito");
        pnlNorte.add(btnAgregar);

        JPanel pnlPrecios = new JPanel(new GridLayout(1, 6));
        pnlPrecios.add(new JLabel("P.U.:"));
        txtPrecio = new JTextField();
        txtPrecio.setEditable(false);
        pnlPrecios.add(txtPrecio);
        pnlPrecios.add(new JLabel("Cant:"));
        txtCantidad = new JTextField();
        pnlPrecios.add(txtCantidad);
        pnlPrecios.add(new JLabel("Dscto:"));
        txtDescuento = new JTextField("0");
        pnlPrecios.add(txtDescuento);

        JPanel pnlSuperior = new JPanel(new BorderLayout());
        pnlSuperior.add(pnlNorte, BorderLayout.NORTH);
        pnlSuperior.add(pnlPrecios, BorderLayout.SOUTH);
        add(pnlSuperior, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Código", "Descripción", "P.U.", "Cant.", "Dscto", "Subtotal"}, 0);
        tblDetalles = new JTable(tableModel);
        add(new JScrollPane(tblDetalles), BorderLayout.CENTER);

        JPanel pnlSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal = new JLabel("Total: 0.00");
        pnlSur.add(lblTotal);
        btnProcesar = new JButton("Procesar Venta");
        pnlSur.add(btnProcesar);
        add(pnlSur, BorderLayout.SOUTH);

        setupUIListeners();
    }

    private void setupUIListeners() {
        cbProductos.addActionListener(e -> {
            if (listener != null) listener.onProductoSeleccionado((Producto) cbProductos.getSelectedItem());
        });
        btnAgregar.addActionListener(e -> {
            if (listener != null) listener.onAgregarProducto();
        });
        btnProcesar.addActionListener(e -> {
            if (listener != null) listener.onProcesarVenta();
        });
    }

    @Override
    public void setClientes(List<Cliente> clientes) {
        cbClientes.removeAllItems();
        for (Cliente c : clientes) cbClientes.addItem(c);
    }

    @Override
    public void setProductos(List<Producto> productos) {
        cbProductos.removeAllItems();
        for (Producto p : productos) cbProductos.addItem(p);
    }

    @Override
    public void setProximoNumeroVenta(int numero) {
        lblNumeroVenta.setText(String.valueOf(numero));
    }

    @Override
    public void setPrecioProducto(double precio) {
        txtPrecio.setText(String.valueOf(precio));
    }

    @Override
    public Cliente getClienteSeleccionado() {
        return (Cliente) cbClientes.getSelectedItem();
    }

    @Override
    public Producto getProductoSeleccionado() {
        return (Producto) cbProductos.getSelectedItem();
    }

    @Override
    public String getCantidad() {
        return txtCantidad.getText();
    }

    @Override
    public String getDescuento() {
        return txtDescuento.getText();
    }

    @Override
    public void agregarDetalleATabla(int codigo, String descripcion, double pu, int cant, double dscto, double subtotal) {
        tableModel.addRow(new Object[]{codigo, descripcion, pu, cant, dscto, subtotal});
    }

    @Override
    public void setTotal(double total) {
        lblTotal.setText("Total: " + String.format("%.2f", total));
    }

    @Override
    public void limpiarVenta(int nuevoNumero) {
        tableModel.setRowCount(0);
        txtCantidad.setText("");
        txtDescuento.setText("0");
        lblNumeroVenta.setText(String.valueOf(nuevoNumero));
        lblTotal.setText("Total: 0.00");
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void setListener(VentaControllerListener listener) {
        this.listener = listener;
    }
}
