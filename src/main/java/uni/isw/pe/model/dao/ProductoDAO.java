package uni.isw.pe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uni.isw.pe.model.Producto;
import uni.isw.pe.util.DbConnection;

public class ProductoDAO {
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT codigo, ruc, descripcion, precio FROM producto";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt("codigo"));
                p.setRuc(rs.getString("ruc"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                productos.add(p);
            }
        }
        return productos;
    }

    public Producto buscarPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT codigo, ruc, descripcion, precio FROM producto WHERE codigo = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto();
                    p.setCodigo(rs.getInt("codigo"));
                    p.setRuc(rs.getString("ruc"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setPrecio(rs.getDouble("precio"));
                    return p;
                }
            }
        }
        return null;
    }
}
