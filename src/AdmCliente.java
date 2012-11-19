import java.util.ArrayList;

public class AdmCliente {
    
    private ArrayList <Cliente> hoja;
    
    public AdmCliente(){
        
        hoja = new ArrayList<Cliente>();
     
    }

public ArrayList<Cliente> fn_getHoja(){
    
    return hoja;
    
}

 public void validarDatosIncompletos (String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto) throws BusinessException{
     
     String msg = "";
     
     if (nombres == null || nombres.isEmpty())
     msg = "El nombre del cliente no puede estar vacio o nulo";
     
     if (apellidopat == null || apellidopat.isEmpty())
     msg = "El apellido paterno del cliente no puede estar vacio o nulo"; 
  
     if (apellidomat == null || apellidomat.isEmpty())
     msg = "El apellido materno del cliente no puede estar vacio o nulo";      
     
     if (email == null || email.isEmpty())
     msg = "El email del cliente no puede estar vacio o nulo"; 
     
     if (dni == null || dni.isEmpty())
     msg = "El DNI del cliente no puede estar vacio o nulo";      
     
     if (telefono == null || telefono.isEmpty())
     msg = "El número de teléfono o celular del cliente no puede estar vacio o nulo";
     
     if (FechaContacto == null || FechaContacto.isEmpty())
     msg = "La fecha de contacto del cliente no puede estar vacio o nulo";
          
  
     if (! msg.isEmpty())
         throw new BusinessException(msg);
         
         
         }
    
    public Cliente Fn_buscar (String nombres) {
        
//   //     for Cliente hoja : fngetHoja())
//            if (hoja.getNombres().trim().equals(nombres))
                //return hoja;
        return null;
    }
 
 
 
 
 
    
    public void ingreso(){
        Cliente c = new Cliente();  
    }
    

    }
    
