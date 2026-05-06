package controller;

import dao.EmpleadoDao;
import model.EmpleadoModel;

import java.util.List;

public class EmpleadoController {

    private EmpleadoDao dao = new EmpleadoDao();

    //obtener id
    public void obtenerId(int id) {
        dao.obtenerId(id);
    }

    //obtener empleados
    public List<EmpleadoModel> obtenerEmpleados() {
        return dao.obtenerTodos();

    }

    //guardar empleados
    public void guardarEmpleados(String nombre, String apellido, String puesto, double salario) {
        EmpleadoModel emp = new EmpleadoModel(0, nombre, apellido, puesto, salario);
        dao.guardar(emp);

    }

    //actualizar
    public void actualizarEmpleados(int id, String nombre, String apellido, String puesto, double salario) {
        EmpleadoModel emp = new EmpleadoModel(id, nombre, apellido, puesto, salario);
        dao.actualizar(emp);
    }
    
    //eliminar
    public void eliminarEmpleado(int id){
        dao.eliminar(id);
    }

}
