
public class Cliente {
    
    private String nombres;
    private String apellidopat;
    private String apellidomat;
    private String email;
    private String dni;
    private String telefono;
    private String FechaContacto;
    private Boolean estado; // true = cliente, false = prospecto

    public Cliente() {
    }

    public Cliente(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, Boolean estado) {
        this.nombres = nombres;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.FechaContacto = FechaContacto;
        this.estado = estado;
    }

    public String getFechaContacto() {
        return FechaContacto;
    }

    public void setFechaContacto(String FechaContacto) {
        this.FechaContacto = FechaContacto;
    }

    public String getApellidomat() {
        return apellidomat;
    }

    public void setApellidomat(String apellidomat) {
        this.apellidomat = apellidomat;
    }

    public String getApellidopat() {
        return apellidopat;
    }

    public void setApellidopat(String apellidopat) {
        this.apellidopat = apellidopat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}

