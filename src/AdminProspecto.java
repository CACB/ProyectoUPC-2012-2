
import java.util.ArrayList;


public class AdminProspecto 
{
    private ArrayList<Prospecto> pros;

    public AdminProspecto() 
    {
        pros= new ArrayList<Prospecto>();
    }
    
    public void validarDatosIncompletos (int estado, String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto)
    {
        String mensaje = "";
        if (nombres == null || nombres.isEmpty())
            mensaje = "El nombre no puede ser vacio o nulo ";
        if (apellidopat == null || apellidopat.isEmpty())
            mensaje = "El apellido paterno no puede ser vacio o nulo";
        if (apellidomat == null || apellidomat.isEmpty());
            mensaje = "El apellido paterno no puede ser vacio o nulo";
        if (email == null || email.isEmpty());
            mensaje = "El email email no puede ser vacio o nulo";
        if (dni == null || dni.isEmpty());
            mensaje = "El dni no puede ser vacio o nulo";
        if (telefono == null || telefono.isEmpty());
            mensaje = "El telefono no puede ser vacio o nulo";
        if (FechaContacto == null || FechaContacto.isEmpty());
            mensaje = "La Fecha de Contacto no puede ser vacio o nulo";
    }
    
 
    
    public void Editar()
    {
        
    }
    public void Nuevo()
    {
    }
    
    public void Buscar()
    {
    }
    public void Eliminar()
    {
    }
    public void DarAlta()
    {
    }        
      
}


