package dao;

import connection.CreateConnection;
import model.EmpleadoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {

    private final CreateConnection connf = new CreateConnection();

    public EmpleadoModel obtenerId(int id) {
        //query
        String query = "SELECT *FROM personas where id_emp = ?";
        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EmpleadoModel emp = new EmpleadoModel(
                            rs.getInt("id_emp"),
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

    public List<EmpleadoModel> obtenerTodos() {
        //lista
        List<EmpleadoModel> lista = new ArrayList<>();
        //query
        String query = "SELECT *FROM personas";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EmpleadoModel emp = new EmpleadoModel(
                        rs.getInt("id_emp"),
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

    public boolean guardar(EmpleadoModel emp) {
        //query
        String query = "INSERT INTO personas(nombre,apellido,puesto,salario) values (?,?,?,?)";
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

}
