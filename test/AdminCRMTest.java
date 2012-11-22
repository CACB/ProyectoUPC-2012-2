
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
    // CLIENTE
    @Test
    public void testRegistrarCliente() {
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        int estado = 1; //Predeterminado


        try {
            oAdmCRM.registrarCliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado);
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
    }
    
      @Test
    public void testEditarCliente() throws Exception {
        testRegistrarCliente();

        String nombres = "Juan";
        String apellidopat = "Gamarra";
        String apellidomat = "Falcao";
        String email = "gamarraf@outlook.com";
        String dni = "43080208";
        String telefono = "4212458";
        String FechaContacto = "19-11-2012";
        int estado = 1;

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);

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

    @Test
    public void testEliminarCliente() throws Exception {
        testRegistrarCliente();

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
        oAdmCRM.eliminarCliente(nombres);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres); // si no existe devuelve NULL
        assertNull(clnt); // No deberia existir
    }

    @Test
    public void testNoPuedoEliminarClienteConVentas() throws Exception {
        testRegistrarCliente();
//        testRegistrarDocumento(); // Probar en caso de cliente con transacciones

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull("El Cliente " + nombres + ", no existe",clnt);
        
        Ventas vtas=oAdmCRM.Fn_buscar_Venta_x_Cliente(nombres);
        assertNull("No se puede eliminar el cliente " + nombres + ", porque, tiene ventas registradas.",vtas);
        
        oAdmCRM.eliminarCliente(nombres);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNull(clnt);
    } 
    
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
        int c_estado = 0;

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

     //PROSPECTO
    @Test
    public void testRegistrarProspecto() {
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        int estado = 0; // Valor predeterminado


        try {
            oAdmCRM.registrarCliente(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto, estado);
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
    }

    @Test
    public void testNoPuedoRegistrarProspectoQueSeaCliente() {
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        int estado = 0; // valor 

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

    @Test
    public void testEliminarProspecto() throws Exception {
        testRegistrarProspecto();

        String nombres = "Juan";

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);
        oAdmCRM.eliminarCliente(nombres);
        clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNull(clnt);
    }

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

        Cliente clnt = oAdmCRM.Fn_buscar_Cliente(nombres);
        assertNotNull(clnt);

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

   //VENTAS
    @Test
    public void testRegistrarDocumento() {
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

        try {
            //Act
            oAdmCRM.registrarVenta(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda);
            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdminCRMTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO review the generated test code and remove the default call to fail.
        Ventas oVentas = oAdmCRM.Fn_buscar_nro_documento(numero);
        assertNotNull(oVentas);
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

        Cliente cli = oAdmCRM.Fn_buscar_Cliente(empresa);
        assertNotNull("No se puede realizar una venta con el cliente " + empresa + ", porque, este cliente no existe.", cli);

        try {
            //Act
            oAdmCRM.registrarVenta(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda);
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
}
