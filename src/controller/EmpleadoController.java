package controller;

import model.EmpleadoModel;
import dao.EmpleadoDao;

import java.util.List;

public class EmpleadoController {

    private final EmpleadoDao dao = new EmpleadoDao();

    //obtenerID
    public void obtenerId(int id) {
        dao.obtenerId(id);
    }

    //obtenertodos
    public List<EmpleadoModel> obtenerEmpleados() {
        return dao.obtenerTodos();
    }

    //guardar
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
    public void eliminarEmpleado(int id) {
        dao.eliminar(id);
    }
}
