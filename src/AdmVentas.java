
import java.util.ArrayList;


public class AdmVentas {

    
    private ArrayList<Ventas> doc;
    
    public AdmVentas() {
        doc = new ArrayList<Ventas>();
    }
    
    public void validarDatosIncompletos(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda) throws BusinessException {
        String msg = "";
        if (numero == null || numero.isEmpty())
            msg = "El numero de documento no puede ser vacio o nulo";
        if (fecha_emision == null || fecha_emision.isEmpty())
            msg += "\nFecha de Emision no pueder ser vacio o nulo";
        if (fecha_vencimiento == null || fecha_vencimiento.isEmpty())
            msg += "\nFecha de vencimiento no pueder ser vacio o nulo";
        
        if (! msg.isEmpty())
            throw new BusinessException(msg);
    }
    
    public void validarDuplicidad(String numero) throws BusinessException {
        if (Fn_buscar_nro_documento(numero) != null){
            String msg = "Documento " + numero + " ya existe.";
            throw  new BusinessException(msg);
        }
    }
    
    public void ValidarEsNumerico(String numero) throws BusinessException {

        if (!numero.matches("\\d*")) {

            String mensaje = "Debe de ingresar solo números.";
            throw new BusinessException(mensaje);
        }
    }
    
     public Ventas Fn_buscar_nro_documento(String numero) {
         for(Ventas doc : fn_getDoc())
            if (doc.getNumero().trim().equals(numero))
               return doc;
        return null;
    }    
    
    private void validarExistenciaDocumento(String numero)
            throws BusinessException {
        if (Fn_buscar_nro_documento(numero) == null){
            String msg = "Numero de documento "+ numero + " no existe.";
            throw new BusinessException(msg);
        }
    }
    
    public void registrarDocumento(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda) throws BusinessException {

        // Validar datos incompletos
        validarDatosIncompletos(numero,fecha_emision,fecha_vencimiento,empresa,fecha_pago,estado,concepto,subtotal,igv,total,moneda);
        // Validar que exista documento
        validarDuplicidad(numero);
       
        fn_getDoc().add(new Ventas(numero,fecha_emision,fecha_vencimiento,empresa,fecha_pago,estado,concepto,subtotal,igv,total,moneda));    
    }
    
    public void eliminarDocumento(String numero) throws BusinessException {
        validarExistenciaDocumento(numero);
        fn_getDoc().remove(Fn_buscar_nro_documento(numero));
    }
    
    public void editarDocumento(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda) throws BusinessException {
        Ventas oven= Fn_buscar_nro_documento(numero);
         int index = 0;
        
        oven.setFecha_emision(fecha_emision);
        oven.setFecha_vencimiento(fecha_vencimiento);
        oven.setEmpresa(empresa);
        oven.setFecha_pago(fecha_pago);
        oven.setEstado(estado);        
        oven.setConcepto(concepto);        
        oven.setSubtotal(subtotal);        
        oven.setIgv(igv);        
        oven.setTotal(total);        
        oven.setMoneda(moneda);    
        
        index = doc.indexOf(oven);
        doc.set(index, oven);
    }
    
    public ArrayList<Ventas> fn_getDoc() {
        return doc;
    }    
}
