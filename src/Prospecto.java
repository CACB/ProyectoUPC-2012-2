
public class Prospecto extends Cliente {

    private int estado;

    public Prospecto(int estado) {
        this.estado = estado;
    }

   
  
    public Prospecto(int estado, String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto) {
        super(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
        this.estado = estado;
    }

    

    public int getEstado () {
        return estado;
    }

    public void setEstado (int val) {
        this.estado = val;
    }

   
    
}




