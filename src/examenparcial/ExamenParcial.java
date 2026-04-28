/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenparcial;

import connection.CreateConnection;
import dao.EmpleadoDao;
import model.EmpleadoModel;
/**
 *
 * @author jdmm0
 */
public class ExamenParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //prueba conexion
        CreateConnection conn = new CreateConnection();
        conn.getConnection();
        EmpleadoDao dao = new EmpleadoDao();
        //pruebas
        EmpleadoModel emp = dao.obtenerId(1);
    }

}
