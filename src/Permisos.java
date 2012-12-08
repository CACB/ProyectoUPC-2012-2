
public class Permisos {
    
   private String rol; 
   private String modulo;
   private Boolean adicionar;
   private Boolean editar;
   private Boolean eliminar;

    public Permisos(String rol, String modulo, Boolean adicionar, Boolean editar, Boolean eliminar) {
        this.rol = rol;
        this.modulo = modulo;
        this.adicionar = adicionar;
        this.editar = editar;
        this.eliminar = eliminar;
    }

    public Boolean getAdicionar() {
        return adicionar;
    }

    public void setAdicionar(Boolean adicionar) {
        this.adicionar = adicionar;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
