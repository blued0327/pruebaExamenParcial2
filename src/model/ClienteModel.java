
package model;

import java.time.LocalDateTime;


public class ClienteModel {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String dpi;
    private String  direccion;
    private String telefono;
    private String email;
    private LocalDateTime fecha_registro;
    private boolean  estado;

    public ClienteModel(int id_cliente, String nombre, String apellido, String dpi, String direccion, String telefono, String email, LocalDateTime fecha_registro, boolean estado) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public ClienteModel(String nombre, String apellido, String dpi, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    //sin estado

    public ClienteModel(int id_cliente, String nombre, String apellido, String dpi, String direccion, String telefono, String email, LocalDateTime fecha_registro) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_registro = fecha_registro;
    }
    

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
 

  
    
   
}
