package dao;

import connection.CreateConnection;
import model.EmpleadoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {

    //instancion create
    private final CreateConnection connf = new CreateConnection();

    public EmpleadoModel obtenerId(int id) {
        //query
        String query = "SELECT *FROM empleado where id_emp = ?";
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            //resulset
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    return new EmpleadoModel(
                            rs.getInt("id_emp"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("puesto"),
                            rs.getDouble("salario"));

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<EmpleadoModel> obtenerTodos() {
        //query
        String query = "SELECT *FROM empleados";
        //arraylist
        List<EmpleadoModel> lista = new ArrayList<>();

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

}
