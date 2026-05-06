package dao;

import model.EmpleadoModel;
import connection.CreateConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {
    
    private final CreateConnection connf = new CreateConnection();

    //obtener id
    public EmpleadoModel obtenerId(int id) {
        //query
        String query = "SELECT *FROM empleado where id_emp = ?";
        //try1
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    return new EmpleadoModel(rs.getInt("id_emp"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("puesto"),
                            rs.getDouble("salario"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    //obtener todos
    public List<EmpleadoModel> obtenerTodos() {
        List<EmpleadoModel> lista = new ArrayList<>();
        //query
        String query = "SELECT *FROM empleado";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                EmpleadoModel emp = new EmpleadoModel(rs.getInt("id_emp"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("puesto"),
                        rs.getDouble("salario"));
                lista.add(emp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
        
    }

    //insertar
    public boolean guardar(EmpleadoModel emp) {
        //query
        String query = "INSERT INTO empleado(nombre, apellido,puesto,salario) VALUES (?,?,?,?)";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setString(3, emp.getPuesto());
            ps.setDouble(4, emp.getSalario());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean actualizar(EmpleadoModel emp) {
        //query
        String query = "UPDATE empleado SET nombre= ? , apellido = ? , puesto = ? , salario = ? where id_emp = ?";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setString(3, emp.getPuesto());
            ps.setDouble(4, emp.getSalario());
            ps.setInt(5, emp.getId_emp());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean eliminar(int id) {
        //query
        String query = "DELETE FROM empleado where id_emp = ?";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
