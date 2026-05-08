package controller;

import dao.ClienteDao;
import java.time.LocalDateTime;
import model.ClienteModel;

import java.util.List;

public class ClienteController {

    private final ClienteDao dao = new ClienteDao();

    //insertar
    public boolean insertarCliente(String nombre, String apellido, String dpi, String direccion, String telefono, String email) {

        ClienteModel cliente = new ClienteModel(nombre, apellido, dpi, direccion, telefono, email);

        return dao.insertar(cliente);
    }

    //actualizar
    public boolean actualizarCliente(int id, String nombre, String apellido, String dpi, String direccion, String telefono, String email) {
        ClienteModel cliente = new ClienteModel(id, nombre, apellido, dpi, direccion, telefono, email, LocalDateTime.now(), true);//se cambio a now porque me daba error para insertar en postgress
        return dao.Actualizar(cliente);
    }

    //eliminar--cambiar estado
    public boolean cambiarEstadoCliente(int id, boolean estado) {
        return dao.cambiarEstado(id, estado);
    }

    //consulatar
    public List<ClienteModel> listarClientes() {

        return dao.listar();
    }

}
