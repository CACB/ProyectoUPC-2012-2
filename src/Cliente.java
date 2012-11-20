
public class Cliente {
    
    private String nombres;
    private String apellidopat;
    private String apellidomat;
    private String email;
    private String dni;
    private String telefono;
    private String FechaContacto;

    public Cliente() {
    }

    public Cliente(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto) {
        this.nombres = nombres;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.FechaContacto = FechaContacto;
    }
    
    public String getFechaContacto () {
        return FechaContacto;
    }

    public void setFechaContacto (String val) {
        this.FechaContacto = val;
    }

    public String getApellidomat () {
        return apellidomat;
    }

    public void setApellidomat (String val) {
        this.apellidomat = val;
    }

    public String getApellidopat () {
        return apellidopat;
    }

    public void setApellidopat (String val) {
        this.apellidopat = val;
    }

    public String getDni () {
        return dni;
    }

    public void setDni (String val) {
        this.dni = val;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String val) {
        this.email = val;
    }

    public String getNombres () {
        return nombres;
    }

    public void setNombres (String val) {
        this.nombres = val;
    }

    public String getTelefono () {
        return telefono;
    }

    public void setTelefono (String val) {
        this.telefono = val;
    }

}

