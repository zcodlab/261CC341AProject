package uni.isw.pe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import uni.isw.pe.model.VentaCab;
import uni.isw.pe.model.VentaDet;
import uni.isw.pe.util.DbConnection;

public class VentaDAO {
    
    public int getSiguienteNumero() throws SQLException {
        String sql = "SELECT COALESCE(MAX(numero), 0) + 1 FROM venta_cab";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 1;
    }

    public void registrarVenta(VentaCab cab, List<VentaDet> detalles) throws SQLException {
        String sqlCab = "INSERT INTO venta_cab (numero, fecha, dni) VALUES (?, ?, ?)";
        String sqlDet = "INSERT INTO venta_det (numero, codigo, pu, dscto, cantidad, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = DbConnection.getConnection();
            conn.setAutoCommit(false);
            
            try (PreparedStatement psCab = conn.prepareStatement(sqlCab)) {
                psCab.setInt(1, cab.getNumero());
                psCab.setDate(2, cab.getFecha());
                psCab.setString(3, cab.getDni());
                psCab.executeUpdate();
            }
            
            try (PreparedStatement psDet = conn.prepareStatement(sqlDet)) {
                for (VentaDet det : detalles) {
                    psDet.setInt(1, cab.getNumero());
                    psDet.setInt(2, det.getCodigo());
                    psDet.setDouble(3, det.getPu());
                    psDet.setDouble(4, det.getDscto());
                    psDet.setInt(5, det.getCantidad());
                    psDet.setDouble(6, det.getSubtotal());
                    psDet.executeUpdate();
                }
            }
            
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
            }
        }
    }
}
