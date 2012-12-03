
public class Usuario {

    private String dni = "25738895";
    private String nombre = "Carlos";
    private String apellidopaterno = "Carrasco";
    private String apellidomaterno = "Perez";
    private String usuario = "ccarrasco";
    private String contraseña = "666";
    private String correoelectronico = "ccarrasco@gmail.com";
    private String fechaingreso = "02/12/2012";
    private String cargo = "Jefe de TI";
    private String rol = "Administrador";
    private String usuariocreacion = "rperez";
    private String fechacreacion = "02/12/2012";
    private String usuarioactualizador = "";
    private String fechaedicion = "";

    public Usuario() {
    }
    
    //CONSTRUCTOR

    public Usuario(String dni,String nombre,String apellidopaterno,String apellidomaterno,String usuario,String contraseña,String correoelectronico,String fechaingreso,String cargo,String rol,String usuariocreacion,String fechacreacion,String usuarioactualizador,String fechaedicion) {
         
     this.dni = dni;
    this.nombre = nombre;
    this.apellidopaterno = apellidopaterno;
    this.apellidomaterno = apellidomaterno;
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.correoelectronico = correoelectronico;
    this.fechaingreso = fechaingreso;
    this.cargo = cargo;
    this.rol = rol;
    this.usuariocreacion = usuariocreacion;
    this.fechacreacion = fechacreacion;
    this.usuarioactualizador = usuarioactualizador;
    this.fechaedicion = fechaedicion;    
    }

    //METODOS GETTER Y SETTER
    
    public String getUsuarioactualizado() {
        return usuarioactualizador;
    }

    public void setUsuarioactualizado(String usuarioactualizador) {
        this.usuarioactualizador = usuarioactualizador;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFechaedicion() {
        return fechaedicion;
    }

    public void setFechaedicion(String fechaedicion) {
        this.fechaedicion = fechaedicion;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }
    
    
}
