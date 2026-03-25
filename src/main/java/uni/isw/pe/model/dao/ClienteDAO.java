package uni.isw.pe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uni.isw.pe.model.Cliente;
import uni.isw.pe.util.DbConnection;

public class ClienteDAO {
    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT dni, apellidos, nombre, fecha_nac, tfno FROM cliente";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setDni(rs.getString("dni"));
                c.setApellidos(rs.getString("apellidos"));
                c.setNombre(rs.getString("nombre"));
                c.setFechaNac(rs.getDate("fecha_nac"));
                c.setTfno(rs.getString("tfno"));
                clientes.add(c);
            }
        }
        return clientes;
    }
    
    public Cliente buscarPorDni(String dni) throws SQLException {
        String sql = "SELECT dni, apellidos, nombre, fecha_nac, tfno FROM cliente WHERE dni = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setDni(rs.getString("dni"));
                    c.setApellidos(rs.getString("apellidos"));
                    c.setNombre(rs.getString("nombre"));
                    c.setFechaNac(rs.getDate("fecha_nac"));
                    c.setTfno(rs.getString("tfno"));
                    return c;
                }
            }
        }
        return null;
    }
}
