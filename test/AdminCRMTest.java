
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminCRMTest {

    AdminCRM oAdmCRM;

    public AdminCRMTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        oAdmCRM = new AdminCRM();
    }

    @After
    public void tearDown() {
        oAdmCRM = null;
    }

//-----------------------USUARIO--------------------------------
    //-------------------------------------------------
    // REGISTRAR USUARIO
    //-------------------------------------------------
    @Test
    public void testRegistrarUsuario() throws Exception {
        testRegistrarRoles();
        String dni = "25738895";
        String nombre = "Carlos";
        String apellidopaterno = "Carrasco";
        String apellidomaterno = "Perez";
        String usuario = "ccarrasco";
        String contraseña = "666";
        String correoelectronico = "ccarrasco@gmail.com";
        String fechaingreso = "02/12/2012";
        String cargo = "Jefe de TI";
        String rol = "Administrador"; //Administradorx (El test no permitira ingresar el usuario porque el rol Administradorx NO EXISTE)
        String usuariocreacion = "rperez";
        String fechacreacion = "02/12/2012";
        String usuarioactualizador = "";
        String fechaedicion = "";

        oAdmCRM.registrarUsuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion);

        Usuario oUsuario = oAdmCRM.Fn_buscar_usuario(usuario);
        assertNotNull(oUsuario);
    }

    //-------------------------------------------------
    // EDITAR USUARIO (ACTUALIZAR)
    //-------------------------------------------------
    @Test
    public void testEditarUsuario() throws Exception {
        testRegistrarUsuario();

        String dni = "25738895";
        String nombre = "Carlos";
        String apellidopaterno = "Carrasco";
        String apellidomaterno = "Perez";
        String usuario = "ccarrasco";
        String contraseña = "6667";
        String correoelectronico = "mcarrasco@gmail.com";
        String fechaingreso = "02/12/2012";
        String cargo = "Gerente de TI";
        String rol = "Auditor";
        String usuariocreacion = "rperez";
        String fechacreacion = "02/12/2012";
        String usuarioactualizador = "msarmiento";
        String fechaedicion = "02/12/2012";

        oAdmCRM.editarUsuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion);

        Usuario oUsuario = oAdmCRM.Fn_buscar_usuario(usuario);

        assertEquals(contraseña, oUsuario.getContraseña());
        assertEquals(correoelectronico, oUsuario.getCorreoelectronico());
        assertEquals(cargo, oUsuario.getCargo());
        assertEquals(rol, oUsuario.getRol());
    }

    //-------------------------------------------------
    // ELIMINAR USUARIO (ACTUALIZAR)
    //-------------------------------------------------
    @Test
    public void testEliminarUsuario() throws Exception {
        testRegistrarUsuario();
        String usuario = "ccarrasco";

        oAdmCRM.eliminarUsuario(usuario);
        Usuario oUsuario = oAdmCRM.Fn_buscar_usuario(usuario);
        assertNull(oUsuario);
    }

    //-------------------------------------------------
    // VALIDAR USUARIO Y CONTRASEÑA ES INCORRECTA
    //-------------------------------------------------
    @Test
    public void testValidarUsuarioContraseña() throws Exception {
        testRegistrarUsuario();

        String usuario = "ccarrasco"; // cambiar nombre para el mensaje
        String contraseña = "666";
        Boolean respuesta_esperada = true;

        Boolean rpta = oAdmCRM.validarAcceso(usuario, contraseña);

        assertEquals(rpta, respuesta_esperada);
    }

    
    
//-----------------------ROLES--------------------------------
    //-------------------------------------------------
    // REGISTRAR ROL
    //-------------------------------------------------
    @Test
    public void testRegistrarRoles() throws Exception {
        Permisos per;
        String[] nombre = {"Administrador", "Auditor"};
        String[] descripcion = {"Acceso total a las aplicaciones", "Supervisa y administra el modulo de ventas"};
        String[] creado = {"ccaballero", "rbecerra"};
        String[] fechacreacion = {"07/12/2012", "25/12/2012"};
        String[] modificado = {"", ""};
        String[] fechamodificacion = {"", ""};

        ArrayList<Permisos> detalle = new ArrayList<Permisos>();
        per = new Permisos("Administrador", "Ventas", true, true, true);
        detalle.add(per);
        per = new Permisos("Administrador", "Compras", true, true, true);
        detalle.add(per);

        for (int i = 0; i < nombre.length; i++) {
            oAdmCRM.registrarRol(nombre[i], descripcion[i], creado[i], fechacreacion[i], modificado[i], fechamodificacion[i], detalle);
        }

        for (int i = 0; i < nombre.length; i++) {
            Roles orol = oAdmCRM.Fn_buscar_Roles(nombre[i]);
            assertNotNull(orol);
        }
    }

    //-------------------------------------------------
    // EDITAR ROL (ACTUALIZAR)
    //-------------------------------------------------
    @Test
    public void testEditarRoles() throws Exception {
        testRegistrarRoles();

        Permisos per;
        String nombre = "Administrador";
        String descripcion = "Como administrador tendrá acceso ilimitado";
        String creado = "ccaballero";
        String fechacreacion = "07/12/2012";
        String modificado = "rbecerra";
        String fechamodificacion = "25/12/2012";

        ArrayList<Permisos> detalle = new ArrayList<Permisos>();
        per = new Permisos(nombre, "Ventas", true, false, true);
        detalle.add(per);
        per = new Permisos(nombre, "Compras", false, false, false);
        detalle.add(per);
        per = new Permisos(nombre, "Contabilidad", true, true, true);
        detalle.add(per);

        oAdmCRM.editarRoles(nombre, descripcion, creado, fechacreacion, modificado, fechamodificacion, detalle);

        Roles orol = oAdmCRM.Fn_buscar_Roles(nombre);

        assertEquals(descripcion, orol.getDescripcion());
        assertEquals(modificado, orol.getModificado());
        assertEquals(fechamodificacion, orol.getFechamodificacion());
        assertEquals(detalle, orol.getDetalle());

    }

    //-------------------------------------------------
    // ELIMINAR ROL
    //-------------------------------------------------
    @Test
    public void testEliminarRoles() throws Exception {
        testRegistrarRoles();

        Permisos per;
        String nombre = "Administrador";
        String descripcion = "Como administrador tendrá acceso ilimitado";
        String creado = "ccaballero";
        String fechacreacion = "07/12/2012";
        String modificado = "rbecerra";
        String fechamodificacion = "25/12/2012";

        ArrayList<Permisos> detalle = new ArrayList<Permisos>();
        per = new Permisos(nombre, "Ventas", true, false, true);
        detalle.add(per);
        per = new Permisos(nombre, "Compras", false, false, false);
        detalle.add(per);
        per = new Permisos(nombre, "Contabilidad", true, true, true);
        detalle.add(per);

        oAdmCRM.eliminarRoles(nombre, descripcion, creado, fechacreacion, modificado, fechamodificacion, detalle);

        Roles orol = oAdmCRM.Fn_buscar_Roles(nombre);

        assertNull(orol);

    }

    //-------------------------------------------------
    // REGISTRAR PERMISOS
    //-------------------------------------------------
    @Test
    public void testRegistrarPermisos() throws Exception {
        testRegistrarRoles();

        Permisos per;
        String rol = "Administrador"; // Este rol ya debe existir
        String modulo = "Almacen";
        Boolean adicionar = true;
        Boolean editar = true;
        Boolean eliminar = true;


        oAdmCRM.registrarPermisos(rol, modulo, adicionar, editar, eliminar);
//        assertEquals(permisos_actuales+1, oAdmCRM.fn_getRoles().size());
    }
    
    

//------------------ CLIENTE/PROSPECTO ------------------------
    //-------------------------------------------------
    // REGISTRAR PROSPECTO
    //-------------------------------------------------
    @Test
    public void testRegistrarProspecto() {
        String[] nombres = {"Juan", "Carlos", "Ruth", "Lisbet"};
        String[] apellidopat = {"Perez,", "Caballero", "Becerra", "Gonzales"};
        String[] apellidomat = {"Diaz", "Perez", "Caballero", "Toledo"};
        String[] email = {"juang@gmail.com", "carlosc@gmail.com", "ruthb@gmail.com", "lisbetg@gmail.com"};
        String[] dni = {"45080508", "54668844", "32456899", "22857766"};
        String[] telefono = {"4682458", "4332458", "4222458", "4552458"};
        String[] FechaContacto = {"20-11-2012", "20-11-2012", "20-11-2012", "20-11-2012"};
        Boolean[] estado = {false, false, false, false};


        try {
            for (int i = 0; i < dni.length; i++) {
                oAdmCRM.registrarProspecto(nombres[i], apellidopat[i], apellidomat[i], email[i], dni[i], telefono[i], FechaContacto[i], estado[i]);
            }

        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < dni.length; i++) {
            Cliente clnt = oAdmCRM.Fn_buscar_Prospecto(nombres[i]);
            assertNotNull("Error, el prospecto " + nombres[i] + " no se ha ingresado", clnt);
        }

    }

    //-------------------------------------------------
    // EDITAR PROSPECTO
    //-------------------------------------------------
    @Test
    public void testEditarProspecto() throws Exception {
        testRegistrarProspecto();

        String nombres = "Juan";
        String apellidopat = "Gamarra";
        String apellidomat = "Falcao";
        String email = "gamarraf@outlook.com";
        String dni = "43080208";
        String telefono = "4212458";
        String FechaContacto = "19-11-2012";
        Boolean estado = false;

        Cliente clnt = oAdmCRM.Fn_buscar_Prospecto(nombres);
        assertNotNull(clnt);

        oAdmCRM.editarProspecto(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado);
        clnt = oAdmCRM.Fn_buscar_Prospecto(nombres);

        assertEquals(nombres, clnt.getNombres());
        assertEquals(apellidopat, clnt.getApellidopat());
        assertEquals(apellidomat, clnt.getApellidomat());
        assertEquals(email, clnt.getEmail());
        assertEquals(dni, clnt.getDni());
        assertEquals(telefono, clnt.getTelefono());
        assertEquals(FechaContacto, clnt.getFechaContacto());
    }

    //--------------------------------------------------------
    // NO PUEDO DAR DE ALTA UN PROSPECTO SI YA ESTE ES CLIENTE
    //--------------------------------------------------------
    @Test
    public void testNoPuedoRegistrarProspectoQueSeaCliente() {
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        Boolean estado = false;

        //  testRegistrarCliente();
        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNull("No se puede ingresar el prospecto " + nombres + ", porque, ya está ingresado en el maestro de Clientes.", clnt);

        try {
            oAdmCRM.registrarCliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado);
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
    }

    //-------------------------------------------------
    // ELIMINAR PROSPECTO
    //-------------------------------------------------
    @Test
    public void testEliminarProspecto() throws Exception {
        testRegistrarProspecto();

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Prospecto(nombres);
        assertNotNull(clnt);
        oAdmCRM.eliminarProspecto(nombres);
        clnt = oAdmCRM.Fn_buscar_Prospecto(nombres);
        assertNull(clnt);
    }

    //-------------------------------------------------
    // REGISTRAR CLIENTE
    //-------------------------------------------------
    @Test
    public void testRegistrarCliente() {
        String[] nombres = {"Juan", "Carlos", "Ruth", "Lisbet"};
        String[] apellidopat = {"Perez,", "Caballero", "Becerra", "Gonzales"};
        String[] apellidomat = {"Diaz", "Perez", "Caballero", "Toledo"};
        String[] email = {"juang@gmail.com", "carlosc@gmail.com", "ruthb@gmail.com", "lisbetg@gmail.com"};
        String[] dni = {"45080508", "54668844", "32456899", "22857766"};
        String[] telefono = {"4682458", "4332458", "4222458", "4552458"};
        String[] FechaContacto = {"20-11-2012", "20-11-2012", "20-11-2012", "20-11-2012"};
        Boolean[] estado = {false, false, false, false};

        try {
            for (int i = 0; i < dni.length; i++) {
                oAdmCRM.registrarCliente(nombres[i], apellidopat[i], apellidomat[i], email[i], dni[i], telefono[i], FechaContacto[i], estado[i]);
            }

        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < dni.length; i++) {
            Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres[i]);
            assertNotNull(clnt);
        }
    }

    //-------------------------------------------------
    // EDITAR CLIENTE (ACTUALIZAR)
    //-------------------------------------------------
    @Test
    public void testEditarCliente() throws Exception {
        testRegistrarCliente();

        String nombres = "Juan"; // El dato a buscar para EDITAR

        // Datos a editar del cliente JUAN
        String apellidopat = "Gamarra"; // apellido paterno original Perez 
        String apellidomat = "Falcao"; // apellido materno origianl Diaz
        String email = "gamarraf@outlook.com"; // correo original juang@gmail.com
        String dni = "43080208";
        String telefono = "4212458";
        String FechaContacto = "19-11-2012";
        Boolean estado = true;

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
        // Para generar error cambiar el apellido paterno por "gammmmmm"
        oAdmCRM.editarCliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);

        assertEquals(nombres, clnt.getNombres());
        assertEquals(apellidopat, clnt.getApellidopat());
        assertEquals(apellidomat, clnt.getApellidomat());
        assertEquals(email, clnt.getEmail());
        assertEquals(dni, clnt.getDni());
        assertEquals(telefono, clnt.getTelefono());
        assertEquals(FechaContacto, clnt.getFechaContacto());
    }

    //-------------------------------------------------
    // ELIMINAR CLIENTE
    //-------------------------------------------------
    @Test
    public void testEliminarCliente() throws Exception {
        testRegistrarCliente();

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
        oAdmCRM.eliminarCliente(nombres);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNull(clnt);
    }

    
    
//-------------------------- VENTAS -----------------------------
    //-------------------------------------------------
    // REGISTRAR VENTAS
    //-------------------------------------------------
    @Test
    public void testRegistrarDocumento() {
        String[] numero = {"666", "777", "888"};
        String[] fecha_emision = {"16/06/2012", "17/06/2012", "18/06/2012"};
        String[] fecha_vencimiento = {"16/06/2012", "17/06/2012", "18/06/2012"};
        String[] empresa = {"Juan", "Carlos", "Ruth"};
        String[] fecha_pago = {"16/06/2012", "17/06/2012", "18/06/2012"};
        String[] estado = {"0", "0", "0"};
        String[] concepto = {"Java", "Linux", ".NET"};
        double[] subtotal = {100.0, 250.0, 400};
        double[] igv = {19.0, 20.00, 35.00};
        double[] total = {119.0, 280.0, 450.0};
        String[] moneda = {"MN", "MN", "MN"};
        String[] observacion = {"", "", ""};

        try {
            //Act
            for (int i = 0; i < numero.length; i++) {
                oAdmCRM.registrarVenta(numero[i], fecha_emision[i], fecha_vencimiento[i], empresa[i], fecha_pago[i], estado[i], concepto[i], subtotal[i], igv[i], total[i], moneda[i], observacion[i]);
            }

            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO review the generated test code and remove the default call to fail.
        for (int i = 0; i < numero.length; i++) {
            Ventas oVentas = oAdmCRM.Fn_buscar_nro_documento(numero[i]);
            assertNotNull(oVentas);
        }

    }

    //-------------------------------------------------
    // REGISTRAR VENTA VALIDANDO QUE EL CLIENTE EXISTA
    //------------------------------------------------- 
    @Test
    public void testRegistrarDocumento_ValidandoQueClienteExista() {
        testRegistrarCliente();

        String numero = "666";
        String fecha_emision = "16/06/2012";
        String fecha_vencimiento = "16/06/2012";
        String empresa = "Juan";
        String fecha_pago = "16/06/2012";
        String estado = "0";
        String concepto = "Java";
        double subtotal = 100.0;
        double igv = 19.0;
        double total = 119.0;
        String moneda = "MN";
        String observacion = "";

        Cliente cli = oAdmCRM.Fn_buscar_Cliente(empresa);
        assertNotNull("No se puede realizar una venta con el cliente " + empresa + ", porque, ese cliente no existe.", cli);

        try {
            //Act
            oAdmCRM.registrarVenta(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observacion);
            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Ventas oVentas = oAdmCRM.Fn_buscar_nro_documento(numero);
        assertNotNull(oVentas);
    }

    //-------------------------------------------------
    // EDITAR VENTA (ACTUALIZAR)
    //------------------------------------------------- 
    @Test
    public void testEditarDocumento() throws Exception {
        testRegistrarDocumento();

        String numero = "666";
        String fecha_emision = "17/07/2012";
        String fecha_vencimiento = "17/07/2012";
        String empresa = "Peru";
        String fecha_pago = "17/07/2012";
        String estado = "1";
        String concepto = "C#";
        double subtotal = 200.0;
        double igv = 38.0;
        double total = 238.0;
        String moneda = "ME";

        oAdmCRM.editarVenta(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda);

        Ventas oVentas = oAdmCRM.Fn_buscar_nro_documento(numero);

        assertEquals(fecha_emision, oVentas.getFecha_emision());
        assertEquals(fecha_vencimiento, oVentas.getFecha_vencimiento());
        assertEquals(empresa, oVentas.getEmpresa());
        assertEquals(fecha_pago, oVentas.getFecha_pago());
        assertEquals(estado, oVentas.getEstado());
        assertEquals(concepto, oVentas.getConcepto());
        assertEquals(subtotal, oVentas.getSubtotal(), 0);
        assertEquals(igv, oVentas.getIgv(), 0);
        assertEquals(total, oVentas.getTotal(), 0);
        assertEquals(moneda, oVentas.getMoneda());
    }

    //-------------------------------------------------
    // ELIMINAR VENTA
    //------------------------------------------------- 
    @Test
    public void testEliminarDocumento() throws Exception {
        testRegistrarDocumento();
        String numero = "666";

        oAdmCRM.eliminarVenta(numero);
        Ventas oVentas = oAdmCRM.Fn_buscar_nro_documento(numero);
        assertNull(oVentas);
    }

    //-----------------------------------------------------------------
    // NO PUEDO CONVERTIR A PROSPECTO UN CLIENTE CON VENTAS REGISTRADAS
    //-----------------------------------------------------------------
    @Test
    public void testValidar_NoPuedoConvertir_a_Prospecto_ClienteConVentas() {
        testRegistrarCliente();
//        testRegistrarDocumento();

        //CLIENTE
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        Boolean c_estado = false;

        Ventas vta = oAdmCRM.Fn_buscar_Venta_x_Cliente(nombres);
        assertNull("El Cliente " + nombres + ", no se puede convertir a Prospecto, porque, tiene ventas realizadas", vta);

        try {
            oAdmCRM.editarCliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, c_estado);
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cliente cli = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertEquals(c_estado, cli.getEstado());
    }

    //-------------------------------------------------
    // NO PUEDO ELIMINAR CLIENTE CON VENTAS REGISTRADAS
    //-------------------------------------------------
    @Test
    public void testNoPuedoEliminarClienteConVentas() throws Exception {
        testRegistrarCliente();
//        testRegistrarDocumento();

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull("El Cliente " + nombres + ", no existe", clnt);

        Ventas vtas = oAdmCRM.Fn_buscar_Venta_x_Cliente(nombres);
        assertNull("No se puede eliminar el cliente " + nombres + ", porque, tiene ventas registradas.", vtas);

        oAdmCRM.eliminarCliente(nombres);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNull(clnt);
    }
    
    

//-------------------------- COMPRAS -----------------------------
    //-------------------------------------------------
    // REGISTRAR COMPRAS
    //-------------------------------------------------
    @Test
    public void testRegistrarDocumentoCompra() {
        String[] numero = {"666", "777", "888"};
        String[] fecha_emision = {"16/06/2012", "17/06/2012", "18/06/2012"};
        String[] fecha_vencimiento = {"16/06/2012", "17/06/2012", "18/06/2012"};
        String[] empresa = {"Juan", "Carlos", "Ruth"};
        String[] fecha_pago = {"16/06/2012", "17/06/2012", "18/06/2012"};
        String[] estado = {"0", "0", "0"};
        String[] concepto = {"Java", "Linux", ".NET"};
        double[] subtotal = {100.0, 250.0, 400};
        double[] igv = {19.0, 20.00, 35.00};
        double[] total = {119.0, 280.0, 450.0};
        String[] moneda = {"MN", "MN", "MN"};
        String[] observacion = {"", "", ""};


        try {
            //Act
            for (int i = 0; i < numero.length; i++) {
                oAdmCRM.registrarCompra(numero[i], fecha_emision[i], fecha_vencimiento[i], empresa[i], fecha_pago[i], estado[i], concepto[i], subtotal[i], igv[i], total[i], moneda[i], observacion[i]);
            }

            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO review the generated test code and remove the default call to fail.
        for (int i = 0; i < numero.length; i++) {
            Compras oCompras = oAdmCRM.Fn_buscar_compras_nro_documento(numero[i]);
            assertNotNull(oCompras);
        }
    }

    //-------------------------------------------------
    // EDITAR COMPRAS (ACTUALIZAR)
    //-------------------------------------------------
    @Test
    public void testEditarDocumentoCompra() throws Exception {
        testRegistrarDocumentoCompra();

        String numero = "666";
        String fecha_emision = "17/07/2012";
        String fecha_vencimiento = "17/07/2012";
        String empresa = "Peru";
        String fecha_pago = "17/07/2012";
        String estado = "1";
        String concepto = "C#";
        double subtotal = 200.0;
        double igv = 38.0;
        double total = 238.0;
        String moneda = "ME";

        oAdmCRM.editarCompra(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda);

        Compras oCompras = oAdmCRM.Fn_buscar_compras_nro_documento(numero);

        assertEquals(fecha_emision, oCompras.getFecha_emision());
        assertEquals(fecha_vencimiento, oCompras.getFecha_vencimiento());
        assertEquals(empresa, oCompras.getEmpresa());
        assertEquals(fecha_pago, oCompras.getFecha_pago());
        assertEquals(estado, oCompras.getEstado());
        assertEquals(concepto, oCompras.getConcepto());
        assertEquals(subtotal, oCompras.getSubtotal(), 0);
        assertEquals(igv, oCompras.getIgv(), 0);
        assertEquals(total, oCompras.getTotal(), 0);
        assertEquals(moneda, oCompras.getMoneda());
    }

    //-------------------------------------------------
    // ELIMINAR COMPRAS
    //-------------------------------------------------
    @Test
    public void testEliminarDocumentoCompra() throws Exception {
        testRegistrarDocumentoCompra();
        String numero = "666";

        oAdmCRM.eliminarCompra(numero);
        Compras oCompras = oAdmCRM.Fn_buscar_compras_nro_documento(numero);
        assertNull(oCompras);
    }
}
