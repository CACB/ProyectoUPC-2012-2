
import java.util.ArrayList;

public class AdminCRM {

    private ArrayList<Cliente> pro;
    private ArrayList<Cliente> cli;
    private ArrayList<Ventas> ven;
    private ArrayList<Compras> com;
    private ArrayList<Usuario> usu;
    private ArrayList<Roles> rol;

    public AdminCRM() {
        pro = new ArrayList<Cliente>();
        cli = new ArrayList<Cliente>();
        ven = new ArrayList<Ventas>();
        com = new ArrayList<Compras>();
        usu = new ArrayList<Usuario>();
        rol = new ArrayList<Roles>();
    }

    
//------------------------USUARIO-------------------------------
    //-------------------------------------------------
    // VALIDAR DATOS INCOMPLETOS DE USUARIO
    //-------------------------------------------------
    public void validarDatosIncompletosUsuario(String dni, String nombre, String apellidopaterno, String apellidomaterno, String usuario, String contraseña, String correoelectronico, String fechaingreso, String cargo, String rol, String usuariocreacion, String fechacreacion, String usuarioactualizador, String fechaedicion) throws BusinessException {
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
        if (apellidomaterno == null || apellidomaterno.isEmpty()) {
            msg += "\napellido materno del usuario no pueder ser vacio o nulo";
        }
        if (usuario == null || usuario.isEmpty()) {
            msg += "\nDebe ingresar el usuario no puede ser vacio o nulo";
        }
        if (contraseña == null || contraseña.isEmpty()) {
            msg += "\nDebe ingresar la contraseña no puede ser vacio o nulo";
        }
        if (correoelectronico == null || correoelectronico.isEmpty()) {
            msg += "\ncorreo electronico del usuario no pueder ser vacio o nulo";
        }
        if (fechaingreso == null || fechaingreso.isEmpty()) {
            msg += "\nfecha ingreso del usuario no pueder ser vacio o nulo";
        }
        if (cargo == null || cargo.isEmpty()) {
            msg += "\ncargo del usuario no pueder ser vacio o nulo";
        }
        if (rol == null || rol.isEmpty()) {
            msg += "\nrol del usuario no pueder ser vacio o nulo";
        }
        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // REGISTRAR USUARIO
    //-------------------------------------------------
    public void registrarUsuario(String dni, String nombre, String apellidopaterno, String apellidomaterno, String usuario, String contraseña, String correoelectronico, String fechaingreso, String cargo, String rol, String usuariocreacion, String fechacreacion, String usuarioactualizador, String fechaedicion) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosUsuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion);
        // Validar que exista documento
        validarExistenciaRoles(rol);
        validarDuplicidadUsuario(usuario);
        fn_getUsuario().add(new Usuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion));
    }

    //-------------------------------------------------
    // BUSCAR USUARIO
    //-------------------------------------------------
    public Usuario Fn_buscar_usuario(String usuario) {
        for (Usuario usu : fn_getUsuario()) {
            if (usu.getUsuario().trim().equals(usuario)) {
                return usu;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // VALIDAR QUE EL USUARIO NO SE DUPLIQUE
    //-------------------------------------------------
    public void validarDuplicidadUsuario(String usuario) throws BusinessException {
        if (Fn_buscar_usuario(usuario) != null) {
            String msg = "El " + usuario + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // VALIDAR QUE EL USUARIO EXISTA
    //-------------------------------------------------
    private void validarExistenciaUsuario(String usuario) throws BusinessException {
        if (Fn_buscar_usuario(usuario) == null) {
            String msg = "El " + usuario + " no existe";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // VALIDAR ACCESO USUARIO Y CONTRASEÑA
    //-------------------------------------------------
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

    //-------------------------------------------------
    // EDITAR USUARIO (ACTUALIZAR)
    //-------------------------------------------------
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

    //-------------------------------------------------
    // ELIMINAR USUARIO
    //-------------------------------------------------
    public void eliminarUsuario(String usuario) throws BusinessException {
        validarExistenciaUsuario(usuario);
        fn_getUsuario().remove(Fn_buscar_usuario(usuario));
    }
    
    
    

//------------------------ROL-------------------------------
    //-------------------------------------------------
    // VALIDAR DATOS INCOMPLETOS DE ROL
    //-------------------------------------------------
    public void validarDatosIncompletosRol(String nombre, String descripcion, String creado, String fechacreacion, String modificado, String fechamodificacion, ArrayList<Permisos> detalle) throws BusinessException {
        String msg = "";
        if (nombre == null || nombre.isEmpty()) {
            msg = "El nombre del rol no puede ser vacio o nulo";
        }
        if (descripcion == null || descripcion.isEmpty()) {
            msg += "\nla descripcion del rol no pueder ser vacio o nulo";
        }
        if (creado == null || creado.isEmpty()) {
            msg += "\nel creado por no pueder ser vacio o nulo";
        }
        if (fechacreacion == null || fechacreacion.isEmpty()) {
            msg += "\nla fecha de creación no pueder ser vacio o nulo";
        }

        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // REGISTRAR ROL
    //-------------------------------------------------
    public void registrarRol(String nombre, String descripcion, String creado, String fechacreacion, String modificado, String fechamodificacion, ArrayList<Permisos> detalle) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosRol(nombre, descripcion, creado, fechacreacion, modificado, fechamodificacion, detalle);
        // Validar si el rol existe
        validarDuplicidadRol(nombre);
        fn_getRoles().add(new Roles(nombre, descripcion, creado, fechacreacion, modificado, fechamodificacion, detalle));
    }

    //-------------------------------------------------
    // BUSCAR ROLES POR NOMBRE
    //-------------------------------------------------
    public Roles Fn_buscar_Roles(String nombre) {
        for (Roles rol : fn_getRoles()) {
            if (rol.getNombre().trim().equals(nombre)) {
                return rol;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // VALIDAR QUE EL ROL NO SE DUPLIQUE
    //-------------------------------------------------
    public void validarDuplicidadRol(String nombre) throws BusinessException {
        if (Fn_buscar_Roles(nombre) != null) {
            String msg = "El " + nombre + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // VALIDAR QUE EL ROL EXISTA
    //-------------------------------------------------
    private void validarExistenciaRoles(String nombre) throws BusinessException {
        if (Fn_buscar_Roles(nombre) == null) {
            String msg = "El " + nombre + " no existe";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // EDITAR ROL (ACTUALIZAR)
    //-------------------------------------------------
    public void editarRoles(String nombre, String descripcion, String creado, String fechacreacion, String modificado, String fechamodificacion, ArrayList<Permisos> detalle) {
        int index = 0;
        Roles orol = Fn_buscar_Roles(nombre);

        orol.setNombre(nombre);
        orol.setDescripcion(descripcion);
        orol.setCreado(creado);
        orol.setFechacreacion(fechacreacion);
        orol.setModificado(modificado);
        orol.setFechamodificacion(fechamodificacion);
        orol.setDetalle(detalle);

        index = rol.indexOf(orol);
        rol.set(index, orol);
    }

    //-------------------------------------------------
    // ELIMINAR ROL
    //-------------------------------------------------
    public void eliminarRoles(String nombre, String descripcion, String creado, String fechacreacion, String modificado, String fechamodificacion, ArrayList<Permisos> detalle) throws BusinessException {
        validarExistenciaRoles(nombre);
        fn_getRoles().remove(Fn_buscar_Roles(nombre));
    }

    //-------------------------------------------------
    // VALIDAR DATOS INCOMPLETOS DE PERMISOS
    //-------------------------------------------------
    public void validarDatosIncompletosPermisos(String rol, String modulo, Boolean adicionar, Boolean editar, Boolean eliminar) throws BusinessException {
        String msg = "";
        if (rol == null || rol.isEmpty()) {
            msg = "El nombre del rol no puede ser vacio o nulo";
        }
        if (modulo == null || modulo.isEmpty()) {
            msg += "\nla descripcion del rol no pueder ser vacio o nulo";
        }
        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // REGISTRAR PERMISOS
    //-------------------------------------------------
    public void registrarPermisos(String rol, String modulo, Boolean adicionar, Boolean editar, Boolean eliminar) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosPermisos(rol, modulo, adicionar, editar, eliminar);
        // Validar que exista rol
        validarDuplicidadPermisos(rol, modulo);
        Roles orol = Fn_buscar_Roles(rol);
        orol.getDetalle().add(new Permisos(rol, modulo, adicionar, editar, eliminar));
    }

    //-------------------------------------------------
    // BUSCAR PERMISO POR MODULO 
    //-------------------------------------------------
    public Permisos Fn_buscar_Permiso(String rol, String modulo) {
        Roles orol = Fn_buscar_Roles(rol);

        for (Permisos per : orol.getDetalle()) {
            if (per.getModulo().trim().equals(modulo)) {
                return per;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // VALIDAR QUE LOS PERMISOS NO SE DUPLIQUE
    //-------------------------------------------------
    public void validarDuplicidadPermisos(String rol, String nombre) throws BusinessException {
        if (Fn_buscar_Permiso(rol, nombre) != null) {
            String msg = "El " + nombre + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    
    
//-------------------CLIENTES/PROSPECTOS-----------------------
    //-------------------------------------------------
    // VALIDAR DATOS INCOMPLETOS DE CLIENTES/PROSPECTOS
    //-------------------------------------------------
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

    //-------------------------------------------------
    // REGISTRAR PROSPECTO
    //-------------------------------------------------
    public void registrarProspecto(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, Boolean estado) throws BusinessException {
        validarDatosIncompletosClientes(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
        validarDuplicidadProspecto(nombres);
        fn_getProspecto().add(new Cliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado));
    }

    //-------------------------------------------------
    // BUSCAR PROSPECTO POR NOMBRE
    //-------------------------------------------------
    public Cliente Fn_buscar_Prospecto(String nombres) {
        for (Cliente cli : fn_getProspecto()) {
            if (cli.getNombres().trim().equals(nombres)) {
                return cli;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // VALIDAR QUE EL PROSPECTO NO SE DUPLIQUE
    //-------------------------------------------------
    public void validarDuplicidadProspecto(String nombres) throws BusinessException {
        if (Fn_buscar_Prospecto(nombres) != null) {
            String msg = "El prospecto " + nombres + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // VALIDAR QUE EL PROSPECTO EXISTA
    //-------------------------------------------------
    private void validarExistenciaProspecto(String nombres) throws BusinessException {
        if (Fn_buscar_Prospecto(nombres) == null) {
            String msg = "El prospecto " + nombres + " no existe";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // EDITAR PROSPECTO (ACTUALIZAR)
    //-------------------------------------------------
    public void editarProspecto(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, Boolean estado) throws BusinessException {
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

    //-------------------------------------------------
    // ELIMINAR PROSPECTO
    //-------------------------------------------------
    public void eliminarProspecto(String nombres) throws BusinessException {
        validarExistenciaProspecto(nombres);
        fn_getProspecto().remove(Fn_buscar_Prospecto(nombres));
    }

    //-------------------------------------------------
    // REGISTRAR CLIENTES
    //-------------------------------------------------
    public void registrarCliente(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, Boolean estado) throws BusinessException {
        validarDatosIncompletosClientes(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
        validarDuplicidadClientes(nombres);
        fn_getCliente().add(new Cliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado));
    }

    //-------------------------------------------------
    // VALIDAR QUE LOS CLIENTES NO SE DUPLIQUE
    //-------------------------------------------------
    public void validarDuplicidadClientes(String nombres) throws BusinessException {
        if (Fn_buscar_Cliente(nombres) != null) {
            String msg = "El cliente " + nombres + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // BUSCAR CLIENTE POR NOMBRE
    //-------------------------------------------------
    public Cliente Fn_buscar_Cliente(String nombres) {
        for (Cliente cli : fn_getCliente()) {
            if (cli.getNombres().trim().equals(nombres)) {
                return cli;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // MUESTRA EL LISTADO DE CLIENTES 
    //-------------------------------------------------
    public ArrayList<Cliente> Fn_MostrarClientes(String nombres, String apellidopaterno, String apellidomaterno, String email, String dni, String telefono, String fechacontacto) throws BusinessException {

        ArrayList<Cliente> acli = new ArrayList<Cliente>();

        if (nombres.trim().equals("")) {
            for (Cliente cli : fn_getCliente()) {
                acli.add(cli);
            }
            return acli;
        } else {
            for (Cliente cli : fn_getCliente()) {
                if (cli.getNombres().trim().equals(nombres) || cli.getApellidopat().trim().equals(apellidopaterno) || cli.getApellidomat().trim().equals(apellidomaterno) || cli.getEmail().trim().equals(email) || cli.getDni().trim().equals(dni) || cli.getTelefono().trim().equals(telefono) || cli.getFechaContacto().trim().equals(fechacontacto)) {
                    acli.add(cli);
                }
            }
            return acli;
        }
    }

    //-------------------------------------------------
    // VALIDAR QUE EL CLIENTE EXISTA
    //-------------------------------------------------
    private void validarExistenciaCliente(String nombres) throws BusinessException {
        if (Fn_buscar_Cliente(nombres) == null) {
            String msg = "El cliente " + nombres + " no existe";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // EDITAR CLIENTE (ACTUALIZAR)
    //-------------------------------------------------
    public void editarCliente(String nombres, String apellidopat, String apellidomat, String email, String dni, String telefono, String FechaContacto, Boolean estado) throws BusinessException {
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

    //-------------------------------------------------
    // ELIMINAR CLIENTE
    //-------------------------------------------------
    public void eliminarCliente(String nombres) throws BusinessException {
        validarExistenciaCliente(nombres);
        fn_getCliente().remove(Fn_buscar_Cliente(nombres));
    }

    
    
//-------------------------VENTAS--------------------------------
    //-------------------------------------------------
    // VALIDAR DATOS INCOMPLETOS DE VENTAS
    //-------------------------------------------------
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

    //-------------------------------------------------
    // REGISTRAR VENTAS
    //-------------------------------------------------
    public void registrarVenta(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda, String observaciones) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosVentas(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones);
        // Validar que exista documento
        validarDuplicidadVentas(numero);
        fn_getVentas().add(new Ventas(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones));
    }

    //-------------------------------------------------
    // BUSCAR VENTAS POR DOCUMENTO
    //-------------------------------------------------
    public Ventas Fn_buscar_nro_documento(String numero) {
        for (Ventas doc : fn_getVentas()) {
            if (doc.getNumero().trim().equals(numero)) {
                return doc;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // BUSCAR VENTAS POR NOMBRE CLIENTE
    //-------------------------------------------------
    public Ventas Fn_buscar_Venta_x_Cliente(String nombre) {
        for (Ventas doc : fn_getVentas()) {
            if (doc.getEmpresa().trim().equals(nombre)) {
                return doc;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // VALIDAR QUE LAS VENTAS NO SE DUPLIQUE
    //-------------------------------------------------
    public void validarDuplicidadVentas(String numero) throws BusinessException {
        if (Fn_buscar_nro_documento(numero) != null) {
            String msg = "Documento " + numero + " ya existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // VALIDAR QUE LA VENTA EXISTA
    //-------------------------------------------------
    private void validarExistenciaVenta(String numero)
            throws BusinessException {
        if (Fn_buscar_nro_documento(numero) == null) {
            String msg = "Numero de documento " + numero + " no existe.";
            throw new BusinessException(msg);
        }
    }

    //---------------------------------------------------
    // VALIDAR QUE EL CLIENTE NO TENGA VENTAS REGISTRADAS
    //---------------------------------------------------
    public void validarVentas_x_Clientes(String nombres) throws BusinessException {
        if (Fn_buscar_Venta_x_Cliente(nombres) != null) {
            String msg = "El cliente " + nombres + " ya tiene transacciones creadas.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // EDITAR VENTA (ACTUALIZAR)
    //-------------------------------------------------
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

    //-------------------------------------------------
    // ELIMINAR VENTA
    //-------------------------------------------------
    public void eliminarVenta(String numero) throws BusinessException {
        validarExistenciaVenta(numero);
        fn_getVentas().remove(Fn_buscar_nro_documento(numero));
    }
    
    
    
    
//-------------------------COMPRAS--------------------------------
    //-------------------------------------------------
    // REGISTRAR COMPRAS
    //-------------------------------------------------
    public void registrarCompra(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda, String observaciones) throws BusinessException {
        // Validar datos incompletos
        validarDatosIncompletosVentas(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones);
        // Validar que exista documento
        validarDuplicidadVentas(numero);
        fn_getCompras().add(new Compras(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones));
    }

    //-------------------------------------------------
    // BUSCAR COMPRAS POR DOCUMENTO
    //-------------------------------------------------
    public Compras Fn_buscar_compras_nro_documento(String numero) {
        for (Compras doc : fn_getCompras()) {
            if (doc.getNumero().trim().equals(numero)) {
                return doc;
            }
        }
        return null;
    }

    //-------------------------------------------------
    // VALIDAR QUE LA COMPRA EXISTA
    //-------------------------------------------------
    private void validarExistenciaCompra(String numero)
            throws BusinessException {
        if (Fn_buscar_compras_nro_documento(numero) == null) {
            String msg = "Numero de documento " + numero + " no existe.";
            throw new BusinessException(msg);
        }
    }

    //-------------------------------------------------
    // EDITAR COMPRA (ACTUALIZAR)
    //-------------------------------------------------
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

    //-------------------------------------------------
    // ELIMINAR COMPRA
    //-------------------------------------------------
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

    public ArrayList<Roles> fn_getRoles() {
        return rol;
    }
}