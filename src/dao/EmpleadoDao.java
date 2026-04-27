
package dao;
import connection.CreateConnection;
import model.EmpleadoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDao {
    private final CreateConnection connF = new CreateConnection();
    
    //obtener id
    public EmpleadoModel obtenerId(int id){
        //query
      String query =   "SELECT *FROM empledo where id_emp = ?";
        try
            (Connection conn = connF.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            
            ps.setInt(1, id);
            
            //resulset
           try (ResultSet rs = ps.executeQuery()){
               while(rs.next()){
                   return new EmpleadoModel(
                    rs.getInt("id"),
                   rs.getString("nombre"),
                   rs.getString("apellido"),
                   rs.getString("puesto"),
                   rs.getDouble("salario"));
               }
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
