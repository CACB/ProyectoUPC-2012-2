
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

    AdminCRM oAdmCRM;   //-- DECLARA EL ADMCRM

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

    //-------------------------[CLIENTE]-----------------------------------
    //-------------------------------------------------------
    //REGISTRAR PROSPECTO TEST
    //-------------------------------------------------------
    @Test
    public void testRegistrarProspecto() {
        String[] nombres = {"Juan", "Carlos", "Ruth", "Lisbet"};
        String[] apellidopat = {"Perez,", "Caballero", "Becerra", "Gonzales"};
        String[] apellidomat = {"Diaz", "Perez", "Caballero", "Toledo"};
        String[] email = {"juang@gmail.com", "carlosc@gmail.com", "ruthb@gmail.com", "lisbetg@gmail.com"};
        String[] dni = {"45080508", "54668844", "32456899", "22857766"};
        String[] telefono = {"4682458", "4332458", "4222458", "4552458"};
        String[] FechaContacto = {"20-11-2012", "20-11-2012", "20-11-2012", "20-11-2012"};
        int[] estado = {0, 0, 0, 0};


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

    //-------------------------------------------------------
    //NO PUEDO REGISTRAR PROSPECTO QUE SEA CLIENTE
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
        int estado = 0;

//        testRegistrarCliente();
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

    //-------------------------------------------------------
    //EDITAR PROSPECTO (ACTUALIZAR)
    //-------------------------------------------------------
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
        int estado = 0;

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

    //-------------------------------------------------------
    //ELIMINAR PROSPECTO TEST
    //-------------------------------------------------------
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

    //---------------------------------------------
    //REGISTRAR CLIENTE TEST 
    //---------------------------------------------
    @Test
    public void testRegistrarCliente() { // ARRAYLIST
        String[] nombres = {"Juan", "Carlos", "Ruth", "Lisbet"};
        String[] apellidopat = {"Perez,", "Caballero", "Becerra", "Gonzales"};
        String[] apellidomat = {"Diaz", "Perez", "Caballero", "Toledo"};
        String[] email = {"juang@gmail.com", "carlosc@gmail.com", "ruthb@gmail.com", "lisbetg@gmail.com"};
        String[] dni = {"45080508", "54668844", "32456899", "22857766"};
        String[] telefono = {"4682458", "4332458", "4222458", "4552458"};
        String[] FechaContacto = {"20-11-2012", "20-11-2012", "20-11-2012", "20-11-2012"};
        int[] estado = {0, 0, 0, 0};

        try { // PROBAR Y CAPTURAR CLIENTE
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

    //---------------------------------------------
    //EDITAR CLIENTE TEST
    //---------------------------------------------
    @Test
    public void testEditarCliente() throws Exception {
        testRegistrarCliente();

        // El dato a buscar para EDITAR
        String nombres = "Juan";

        // Datos a editar del cliente JUAN, si no es JUAN, ERROR
        String apellidopat = "Gamarra"; // apellido paterno original Perez 
        String apellidomat = "Falcao"; // apellido materno origianl Diaz
        String email = "gamarraf@outlook.com"; // correo original juang@gmail.com
        String dni = "43080208";
        String telefono = "4212458";
        String FechaContacto = "19-11-2012";
        int estado = 1;

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);

        // Para generar error cambiar el apellido paterno por "Fernando"
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

    //---------------------------------------------
    //ELIMINAR CLIENTE TEST
    //---------------------------------------------
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

    //---------------------------------------------
    //NO ELIMINA CLIENTE CON VENTAS REGISTRADAS
    //---------------------------------------------
    @Test
    public void testNoPuedoEliminarClienteConVentas() throws Exception {
        testRegistrarCliente();
        // PROBAR EN CASO DE CLIENTE CON TRANSACCIONES
        // testRegistrarDocumento(); 

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull("El Cliente " + nombres + ", no existe", clnt);

        Ventas vtas = oAdmCRM.Fn_buscar_Venta_x_Cliente(nombres);
        assertNull("No se puede eliminar el cliente " + nombres + ", porque, tiene ventas registradas.", vtas);

        oAdmCRM.eliminarCliente(nombres);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNull(clnt);
    }

    //-------------------------------------------------------
    //NO PUEDO CONVERTIR A PROSPECTO UN CLIENTE CON TRANSACCIONES
    //--------------------------------------------------------
    @Test
    public void testValidar_NoPuedoConvertir_a_Prospecto_ClienteConVentas() {
        testRegistrarCliente();
        //  testRegistrarDocumento();

        //CLIENTE
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        int c_estado = 0; // prospecto


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

    @Test
    public void testEliminarDocumento() throws Exception {
        testRegistrarDocumento();
        String numero = "666";

        oAdmCRM.eliminarVenta(numero);
        Ventas oVentas = oAdmCRM.Fn_buscar_nro_documento(numero);
        assertNull(oVentas);
    }

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

    @Test
    public void testEliminarDocumentoCompra() throws Exception {
        testRegistrarDocumentoCompra();
        String numero = "666";

        oAdmCRM.eliminarCompra(numero);
        Compras oCompras = oAdmCRM.Fn_buscar_compras_nro_documento(numero);
        assertNull(oCompras);
    }

    @Test
    public void testEliminarUsuario() throws Exception {
        testRegistrarUsuario();
        String usuario = "ccarrasco";

        oAdmCRM.eliminarUsuario(usuario);
        Usuario oUsuario = oAdmCRM.Fn_buscar_usuario(usuario);
        assertNull(oUsuario);
    }

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

    @Test
    public void testRegistrarUsuario() throws Exception {
        String dni = "25738895";
        String nombre = "Carlos";
        String apellidopaterno = "Carrasco";
        String apellidomaterno = "Perez";
        String usuario = "ccarrasco";
        String contraseña = "666";
        String correoelectronico = "ccarrasco@gmail.com";
        String fechaingreso = "02/12/2012";
        String cargo = "Jefe de TI";
        String rol = "Administrador";
        String usuariocreacion = "rperez";
        String fechacreacion = "02/12/2012";
        String usuarioactualizador = "";
        String fechaedicion = "";

        oAdmCRM.registrarUsuario(dni, nombre, apellidopaterno, apellidomaterno, usuario, contraseña, correoelectronico, fechaingreso, cargo, rol, usuariocreacion, fechacreacion, usuarioactualizador, fechaedicion);

        Usuario oUsuario = oAdmCRM.Fn_buscar_usuario(usuario);
        assertNotNull(oUsuario);
    }

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

    @Test
    public void testValidarUsuarioContraseña() throws Exception {
        testRegistrarUsuario();

        String usuario = "ccarrasco";
        String contraseña = "666";
        Boolean respuesta_esperada = true;

        Boolean rpta = oAdmCRM.validarAcceso(usuario, contraseña);

        assertEquals(rpta, respuesta_esperada);
    }
}
