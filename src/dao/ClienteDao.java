package dao;

import connection.CreateConnection;
import model.ClienteModel;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class ClienteDao {

    private final CreateConnection connf = new CreateConnection();

    //insertar
    public boolean insertar(ClienteModel cliente) {
        String query = "INSERT INTO clientes(nombre,apellido,dpi,direccion,telefono,email) values (?,?,?,?,?,?)";

        try (Connection con = connf.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDpi());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    //actualizar

    public boolean Actualizar(ClienteModel cliente) {
        //query
        String query = "UPDATE clientes SET nombre=?,apellido=?,dpi=?,direccion=?,telefono=?,email=?,fecha_registro = ? where id_cliente = ?";
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDpi());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());
            ps.setTimestamp(7, Timestamp.valueOf(cliente.getFecha_registro()));
            ps.setInt(8, cliente.getId_cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //eliminar 
    /*
    public boolean eliminar(int id) {
        //query
        String query = "DELETE from clientes where id_cliente = ? ";

        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
     */
    //consultar
    public List<ClienteModel> listar() {
        List<ClienteModel> lista = new ArrayList<>();
        //query
        String query = "SELECT *FROM clientes order by id_cliente";

        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ClienteModel cliente = new ClienteModel(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dpi"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_registro").toLocalDateTime(),
                        rs.getBoolean("estado"));

                lista.add(cliente);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    //cambiar estado
    public boolean cambiarEstado(int id, boolean estado) {
        //query
        String query = "UPDATE clientes set estado = ? where id_cliente = ?";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setBoolean(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
