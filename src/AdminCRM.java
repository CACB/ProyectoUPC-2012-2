
import java.util.ArrayList;

public class AdminCRM {

    private ArrayList<Cliente> pro;
    private ArrayList<Cliente> cli;
    private ArrayList<Ventas> ven;
    private ArrayList<Compras> com;
    private ArrayList<Usuario> usu;

    public AdminCRM() {
        pro = new ArrayList<Cliente>();
        cli = new ArrayList<Cliente>();
        ven = new ArrayList<Ventas>();
        com = new ArrayList<Compras>();
        usu = new ArrayList<Usuario>();
    }

    //-------------------------[USUARIO]-----------------------------------
    //-------------------------------------
    //VALIDAR DATOS INCOMPLETOS USUARIO
    //-------------------------------------
    public void validarDatosIncompletosUsuario(String dni, String nombre,
            String apellidopaterno, String apellidomaterno, String usuario,
            String contraseña, String correoelectronico, String fechaingreso,
            String cargo, String rol, String usuariocreacion,
            String fechacreacion, String usuarioactualizador,
            String fechaedicion) throws BusinessException {

        String msg = "";
        if (dni == null || dni.isEmpty()) {
            msg = "El dni no puede ser vacio o nulo";
        }
        if (nombre == null || nombre.isEmpty()) {
            msg += "\nnombre de usuario no pueder ser vacio o nulo";
        }
        if (apellidopaterno == null || apellidopaterno.isEmpty()) {
            msg += "\napellido paterno del usuario no pueder ser vacio o nulo";
        }

        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }
    }

    //------------------------------------------------
    //REGISTRAR USUARIO
    //------------------------------------------------
    public void registrarUsuario(String dni, String nombre, String apellidopaterno, String apellidomaterno, String usuario, String contraseña, String correoelectronico, String fechaingreso, String cargo, String rol, String usuariocreacion, String fechacreacion, String usuarioactualizador, String fechaedicion) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosUsuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion);
        // Validar que exista documento
        validarDuplicidadUsuario(usuario);
        fn_getUsuario().add(new Usuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion));
    }

    //------------------------------------------------
    //VALIDAR QUE EL USUARIO INGRESADO NO SE DUPLIQUE
    //------------------------------------------------
    public void validarDuplicidadUsuario(String usuario) throws BusinessException {
        if (Fn_buscar_usuario(usuario) != null) {
            String msg = "El " + usuario + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //----------------------------------------------
    //BUSCAR USUARIO 
    //----------------------------------------------
    public Usuario Fn_buscar_usuario(String usuario) {
        for (Usuario usu : fn_getUsuario()) {
            if (usu.getUsuario().trim().equals(usuario)) {
                return usu;
            }
        }
        return null;
    }

    //----------------------------------------------
    //VALIDAR QUE EL USUARIO EXISTA
    //----------------------------------------------
    private void validarExistenciaUsuario(String usuario) throws BusinessException {
        if (Fn_buscar_usuario(usuario) == null) {
            String msg = "El " + usuario + " no existe";
            throw new BusinessException(msg);
        }
    }

    //----------------------------------------------
    //VALIDAR USUARIO Y CONTRASEÑA PARA EL ACCESO
    //----------------------------------------------
    public Boolean validarAcceso(String usuario, String contraseña) throws BusinessException {
        Boolean rpta = false;
        String msg = "";
        Usuario ousu = Fn_buscar_usuario(usuario);

        if (ousu == null) {
            rpta = false;
            msg = "El usuario no existe";
        } else {
            if (ousu.getContraseña().trim().equals(contraseña.trim())) {
                rpta = true;
            } else {
                msg = "La contraseña es invalida";
                rpta = false;
            }
        }

        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }


        return rpta;
    }

    //--------------------------------------------
    //EDITAR USUARIO (ACTUALIZAR)
    //--------------------------------------------
    public void editarUsuario(String dni, String nombre, String apellidopaterno, String apellidomaterno, String usuario, String contraseña, String correoelectronico, String fechaingreso, String cargo, String rol, String usuariocreacion, String fechacreacion, String usuarioactualizador, String fechaedicion) throws BusinessException {
        Usuario ousu = Fn_buscar_usuario(usuario);
        int index = 0;

        ousu.setDni(dni);
        ousu.setNombre(nombre);
        ousu.setApellidomaterno(apellidopaterno);
        ousu.setApellidomaterno(apellidomaterno);
        ousu.setContraseña(contraseña);
        ousu.setCorreoelectronico(correoelectronico);
        ousu.setFechaingreso(fechaingreso);
        ousu.setCargo(cargo);
        ousu.setRol(rol);
        ousu.setUsuariocreacion(usuariocreacion);
        ousu.setFechacreacion(fechacreacion);
        ousu.setUsuarioactualizado(usuarioactualizador);
        ousu.setFechaedicion(fechaedicion);

        index = usu.indexOf(ousu);
        usu.set(index, ousu);
    }

    //--------------------------------------------
    //ELIMINAR USUARIO 
    //--------------------------------------------
    public void eliminarUsuario(String usuario) throws BusinessException {
        validarExistenciaUsuario(usuario);
        fn_getUsuario().remove(Fn_buscar_usuario(usuario));
    }

    //----------------------[CLIENTE / PROSPECTO]-----------------------------
    //----------------------------------------------
    //VALIDAR DATOS INCOMPLETOS CLIENTE / PROSPECTO
    //----------------------------------------------
    public void validarDatosIncompletosClientes(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto) throws BusinessException {

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

    //--------------------------------------------------
    //REGISTRAR PROSPECTO
    //--------------------------------------------------
    public void registrarProspecto(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {
        validarDatosIncompletosClientes(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
        validarDuplicidadProspecto(nombres);
        fn_getProspecto().add(new Cliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado));
    }

    //--------------------------------------------------
    //VALIDAR QUE EL PROSPECTO INGRESADO NO SE DUPLIQUE
    //--------------------------------------------------
    public void validarDuplicidadProspecto(String nombres) throws BusinessException {
        if (Fn_buscar_Prospecto(nombres) != null) {
            String msg = "El prospecto " + nombres + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //--------------------------------------------------
    //BUSCAR PROSPECTO POR NOMBRE
    //------------------------------------------------
    public Cliente Fn_buscar_Prospecto(String nombres) {
        for (Cliente cli : fn_getProspecto()) {
            if (cli.getNombres().trim().equals(nombres)) {
                return cli;
            }
        }
        return null;
    }

    //--------------------------------------------------------------
    //VALIDAR QUE EL PROSPECTO EXISTA
    //--------------------------------------------------------------
    private void validarExistenciaProspecto(String nombres) throws BusinessException {
        if (Fn_buscar_Prospecto(nombres) == null) {
            String msg = "El prospecto " + nombres + " no existe";
            throw new BusinessException(msg);
        }
    }

    //--------------------------------------------
    //EDITAR PROSPECTO (ACTUALIZAR)
    //--------------------------------------------
    public void editarProspecto(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {
        Cliente opro = Fn_buscar_Prospecto(nombres);
        int index = 0;

        opro.setApellidopat(apellidopat);
        opro.setApellidomat(apellidomat);
        opro.setEmail(email);
        opro.setDni(dni);
        opro.setTelefono(telefono);
        opro.setFechaContacto(FechaContacto);
        opro.setEstado(estado);

        index = pro.indexOf(opro);
        pro.set(index, opro);
    }

    //--------------------------------------------------------------
    //ELIMINA PROSPECTO
    //--------------------------------------------------------------
    public void eliminarProspecto(String nombres) throws BusinessException {
        validarExistenciaProspecto(nombres);
        fn_getProspecto().remove(Fn_buscar_Prospecto(nombres));
    }

    //--------------------------------------------------
    //REGISTRAR CLIENTES
    //--------------------------------------------------
    public void registrarCliente(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {
        validarDatosIncompletosClientes(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
        validarDuplicidadClientes(nombres);
        fn_getCliente().add(new Cliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado));
    }

    //------------------------------------------------
    //VALIDAR QUE EL CLIENTE INGRESADO NO SE DUPLIQUE
    //------------------------------------------------
    public void validarDuplicidadClientes(String nombres) throws BusinessException {
        if (Fn_buscar_Cliente(nombres) != null) {
            String msg = "El cliente " + nombres + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //------------------------------------------------
    //BUSCAR CLIENTE POR NOMBRE
    //------------------------------------------------
    public Cliente Fn_buscar_Cliente(String nombres) {
        for (Cliente cli : fn_getCliente()) {
            if (cli.getNombres().trim().equals(nombres)) {
                return cli;
            }
        }
        return null;
    }

    //--------------------------------------------------------------
    //BUSCAR CLIENTE Y LISTAR SUS FILTROS INGRESADOS
    //--------------------------------------------------------------
    public ArrayList<Cliente> Fn_MostrarClientes(String nombres, String apellidopaterno, String apellidomaterno, String email, String dni, String telefono, String fechacontacto) throws BusinessException {

        ArrayList<Cliente> acli = new ArrayList<Cliente>();

        for (Cliente cli : fn_getCliente()) {
            if (cli.getNombres().trim().equals(nombres) || cli.getApellidopat().trim().equals(apellidopaterno) || cli.getApellidomat().trim().equals(apellidomaterno) || cli.getEmail().trim().equals(email) || cli.getDni().trim().equals(dni) || cli.getTelefono().trim().equals(telefono) || cli.getFechaContacto().trim().equals(fechacontacto)) {
                acli.add(cli);
            }
        }

        if (acli.size() < 0) {
            String msg = "No se encontraron registros para los filtros ingresados.";
            throw new BusinessException(msg);
        }
        return acli;
    }

    //--------------------------------------------------------------
    //VALIDAR QUE EL CLIENTE EXISTA
    //--------------------------------------------------------------
    private void validarExistenciaCliente(String nombres) throws BusinessException {
        if (Fn_buscar_Cliente(nombres) == null) {
            String msg = "El cliente " + nombres + " no existe";
            throw new BusinessException(msg);
        }
    }

    //--------------------------------------------
    //EDITAR CLIENTE (ACTUALIZAR)
    //--------------------------------------------
    public void editarCliente(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, int estado) throws BusinessException {
        Cliente oven = Fn_buscar_Cliente(nombres);
        int index = 0;

        oven.setApellidopat(apellidopat);
        oven.setApellidomat(apellidomat);
        oven.setEmail(email);
        oven.setDni(dni);
        oven.setTelefono(telefono);
        oven.setFechaContacto(FechaContacto);
        oven.setEstado(estado);

        index = cli.indexOf(oven);
        cli.set(index, oven);
    }

    //--------------------------------------------------------------
    //ELIMINAR CLIENTE
    //--------------------------------------------------------------
    public void eliminarCliente(String nombres) throws BusinessException {
        validarExistenciaCliente(nombres);
        fn_getCliente().remove(Fn_buscar_Cliente(nombres));
    }

    //-------------------------[VENTAS]-----------------------------------
    //-------------------------------------
    //VALIDAR DATOS INCOMPLETOS VENTAS
    //-------------------------------------
    public void validarDatosIncompletosVentas(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda, String observacion) throws BusinessException {
        String msg = "";
        if (numero == null || numero.isEmpty()) {
            msg = "El numero de documento no puede ser vacio o nulo";
        }
        if (fecha_emision == null || fecha_emision.isEmpty()) {
            msg += "\nFecha de Emision no pueder ser vacio o nulo";
        }
        if (fecha_vencimiento == null || fecha_vencimiento.isEmpty()) {
            msg += "\nFecha de vencimiento no pueder ser vacio o nulo";
        }

        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }
    }

    //------------------------------------------------
    //REGISTRAR VENTAS
    //------------------------------------------------
    public void registrarVenta(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda, String observaciones) throws BusinessException {
        validarDatosIncompletosVentas(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones);
        // Validar que exista documento
        validarDuplicidadVentas(numero);
        fn_getVentas().add(new Ventas(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones));
    }

    //----------------------------------------------
    //VALIDAR QUE LA VENTA INGRESADA NO SE DUPLIQUE
    //----------------------------------------------
    public void validarDuplicidadVentas(String numero) throws BusinessException {
        if (Fn_buscar_nro_documento(numero) != null) {
            String msg = "Documento " + numero + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //------------------------------------------------
    //BUSCAR VENTAS POR NUMERO DOCUMENTO
    //------------------------------------------------
    public Ventas Fn_buscar_nro_documento(String numero) {
        for (Ventas doc : fn_getVentas()) {
            if (doc.getNumero().trim().equals(numero)) {
                return doc;
            }
        }
        return null;
    }

    //------------------------------------------------
    //BUSCAR VENTAS POR NOMBRE CLIENTE
    //------------------------------------------------
    public Ventas Fn_buscar_Venta_x_Cliente(String nombre) {
        for (Ventas doc : fn_getVentas()) {
            if (doc.getEmpresa().trim().equals(nombre)) {
                return doc;
            }
        }
        return null;
    }

    //------------------------------------------------
    //VALIDAR QUE LA VENTA EXISTA
    //------------------------------------------------
    private void validarExistenciaVenta(String numero)
            throws BusinessException {
        if (Fn_buscar_nro_documento(numero) == null) {
            String msg = "Numero de documento " + numero + " no existe.";
            throw new BusinessException(msg);
        }
    }
    
    //---------------------------------------------------
    //VALIDAR QUE EL CLIENTE NO TENGA VENTAS REGISTRADAS
    //---------------------------------------------------
    
    public void validarVentas_x_Clientes(String nombres) throws BusinessException {
        if (Fn_buscar_Venta_x_Cliente(nombres) != null) {
            String msg = "El cliente " + nombres + " ya tiene transacciones creadas.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------
    //EDITAR VENTA (ACTUALIZAR)
    //-------------------------------------
    public void editarVenta(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda) throws BusinessException {
        Ventas oven = Fn_buscar_nro_documento(numero);
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

        index = ven.indexOf(oven);
        ven.set(index, oven);
    }

    //-------------------------------------
    //ELIMINAR VENTA
    //-------------------------------------
    public void eliminarVenta(String numero) throws BusinessException {
        validarExistenciaVenta(numero);
        fn_getVentas().remove(Fn_buscar_nro_documento(numero));
    }

    //-------------------------[COMPRAS]-----------------------------------
    //------------------------------------------------
    //REGISTRAR COMPRAS
    //------------------------------------------------
    public void registrarCompra(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda, String observaciones) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosVentas(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones);
        // Validar que exista documento
        validarDuplicidadVentas(numero);
        fn_getCompras().add(new Compras(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones));
    }

    //-------------------------------------
    //BUSCAR COMPRAS POR NUMERO DOCUMENTO
    //-------------------------------------
    public Compras Fn_buscar_compras_nro_documento(String numero) {
        for (Compras doc : fn_getCompras()) {
            if (doc.getNumero().trim().equals(numero)) {
                return doc;
            }
        }
        return null;
    }

    //-------------------------------------
    //VALIDAR QUE LA COMPRA EXISTA
    //-------------------------------------
    private void validarExistenciaCompra(String numero)
            throws BusinessException {
        if (Fn_buscar_compras_nro_documento(numero) == null) {
            String msg = "Numero de documento " + numero + " no existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------
    //EDITAR COMPRA (ACTUALIZAR)
    //-------------------------------------
    public void editarCompra(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda) throws BusinessException {
        Compras ocom = Fn_buscar_compras_nro_documento(numero);
        int index = 0;

        ocom.setFecha_emision(fecha_emision);
        ocom.setFecha_vencimiento(fecha_vencimiento);
        ocom.setEmpresa(empresa);
        ocom.setFecha_pago(fecha_pago);
        ocom.setEstado(estado);
        ocom.setConcepto(concepto);
        ocom.setSubtotal(subtotal);
        ocom.setIgv(igv);
        ocom.setTotal(total);
        ocom.setMoneda(moneda);

        index = com.indexOf(ocom);
        com.set(index, ocom);
    }

    //-------------------------------------
    //ELIMINAR COMPRA
    //-------------------------------------
    public void eliminarCompra(String numero) throws BusinessException {
        validarExistenciaCompra(numero);
        fn_getCompras().remove(Fn_buscar_compras_nro_documento(numero));
    }

    
    public void ValidarEsNumerico(String numero) throws BusinessException {
        if (!numero.matches("\\d*")) {
            String mensaje = "Debe de ingresar solo números.";
            throw new BusinessException(mensaje);
        }
    }

    
    
    public ArrayList<Ventas> fn_getVentas() {
        return ven;
    }

    public ArrayList<Compras> fn_getCompras() {
        return com;
    }

    public ArrayList<Cliente> fn_getCliente() {
        return cli;
    }

    public ArrayList<Cliente> fn_getProspecto() {
        return pro;
    }

    public ArrayList<Usuario> fn_getUsuario() {
        return usu;
    }

    
}
