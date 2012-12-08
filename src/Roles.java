
import java.util.ArrayList;


public class Roles {
    
    private String nombre;
    private String descripcion;
    private String creado;
    private String fechacreacion;    
    private String modificado;
    private String fechamodificacion;
    private ArrayList<Permisos> detalle;

    public Roles(String nombre, String descripcion, String creado, String fechacreacion, String modificado, String fechamodificacion, ArrayList<Permisos> detalle) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creado = creado;
        this.fechacreacion = fechacreacion;
        this.modificado = modificado;
        this.fechamodificacion = fechamodificacion;
        this.detalle = detalle;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Permisos> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Permisos> detalle) {
        this.detalle = detalle;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(String fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
