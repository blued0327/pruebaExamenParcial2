
package model;


public class ClienteModel {
    private int id_cliente;
    private int apellido;
    private String dpi;
    private String  direccion;
    private String telefono;
    private String email;
    private String fecha_registro;
    private boolean  estado;

    public ClienteModel(int id_cliente, int apellido, String dpi, String direccion, String telefono, String email, String fecha_registro, boolean estado) {
        this.id_cliente = id_cliente;
        this.apellido = apellido;
        this.dpi = dpi;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getApellido() {
        return apellido;
    }

    public void setApellido(int apellido) {
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
   
}
