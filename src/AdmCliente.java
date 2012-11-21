import java.util.ArrayList;

public class AdmCliente {


    private ArrayList<Cliente> hoja;

    public AdmCliente() {

        hoja = new ArrayList<Cliente>();

    }

    public void validarDatosIncompletos(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto) throws BusinessException {

        String msg = "";

        if (nombres == null || nombres.isEmpty()) {
            msg = "El nombre del cliente no puede estar vacio o nulo";
        }

        if (apellidopat == null || apellidopat.isEmpty()) {
            msg = "El apellido paterno del cliente no puede estar vacio o nulo";
        }

        if (apellidomat == null || apellidomat.isEmpty()) {
            msg = "El apellido materno del cliente no puede estar vacio o nulo";
        }

        if (email == null || email.isEmpty()) {
            msg = "El email del cliente no puede estar vacio o nulo";
        }

        if (dni == null || dni.isEmpty()) {
            msg = "El DNI del cliente no puede estar vacio o nulo";
        }

        if (telefono == null || telefono.isEmpty()) {
            msg = "El número de teléfono o celular del cliente no puede estar vacio o nulo";
        }

        if (FechaContacto == null || FechaContacto.isEmpty()) {
            msg = "La fecha de contacto del cliente no puede estar vacio o nulo";
        }


        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }


    }

    public void validarDuplicidad(String nombres) throws BusinessException {

        if (Fn_buscar_nro_Hoja(nombres) != null) {

            String msg = "El cliente " + nombres + " ya existe.";
            throw new BusinessException(msg);
        }

    }

    public Cliente Fn_buscar_nro_Hoja(String nombres) {

        for (Cliente hoja : fn_getHoja()) {
            if (hoja.getNombres().trim().equals(nombres)) {
                return hoja;
            }
        }
        return null;
    }
//     public Ventas Fn_buscar_transacciones(String nombres) {
//
//        for (Ventas vtas : fn ) {
//            if (hoja.getNombres().trim().equals(nombres)) {
//                return hoja;
//            }
//        }
//        return null;
//    }

    private void validarExistenciaHoja(String nombres)
            throws BusinessException {

        if (Fn_buscar_nro_Hoja(nombres) == null) {
            String msg = "El cliente " + nombres + " no existe";
            throw new BusinessException(msg);
        }
    }


    public void registrarHoja(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {

        validarDatosIncompletos(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);

        validarDuplicidad(nombres);

        fn_getHoja().add(new Cliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado));

    }

    public void eliminarCliente(String nombres) throws BusinessException {

        validarExistenciaHoja(nombres);

        fn_getHoja().remove(Fn_buscar_nro_Hoja(nombres));

    }

    public void editarHoja(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {

        Cliente oven = Fn_buscar_nro_Hoja(nombres);
        int index = 0;

        oven.setApellidopat(apellidopat);
        oven.setApellidomat(apellidomat);
        oven.setEmail(email);
        oven.setDni(dni);
        oven.setTelefono(telefono);
        oven.setFechaContacto(FechaContacto);
        oven.setEstado(estado);
        
        index = hoja.indexOf(oven);
        hoja.set(index, oven);
    }

    public void convertir_a_Prospecto(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {

        Cliente oven = Fn_buscar_nro_Hoja(nombres);
        int index = 0;

        oven.setApellidopat(apellidopat);
        oven.setApellidomat(apellidomat);
        oven.setEmail(email);
        oven.setDni(dni);
        oven.setTelefono(telefono);
        oven.setFechaContacto(FechaContacto);
        oven.setEstado(estado);
        
        index = hoja.indexOf(oven);
        hoja.set(index, oven);
    }
    
    public void ingreso() {
        Cliente c = new Cliente();
    }

    public ArrayList<Cliente> fn_getHoja() {
        return hoja;
    }

}
