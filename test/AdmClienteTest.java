
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdmClienteTest {

    public AdmClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of validarDatosIncompletos method, of class AdmCliente.
     */
////    @Test
////    public void testValidarDatosIncompletos() throws Exception {
////        System.out.println("validarDatosIncompletos");
////        String nombres = "";
////        String apellidopat = "";
////        String apellidomat = "";
////        String email = "";
////        String dni = "";
////        String telefono = "";
////        String FechaContacto = "";
////        AdmCliente instance = new AdmCliente();
////        instance.validarDatosIncompletos(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
////    }
////    @Test
////    public void testValidarDuplicidad() throws Exception {
////        System.out.println("validarDuplicidad");
////        String nombres = "";
////        AdmCliente instance = new AdmCliente();
////        instance.validarDuplicidad(nombres);
////    }
//    /**
//     * Test of Fn_buscar_nro_Hoja method, of class AdmCliente.
//     */
////    @Test
////    public void testFn_buscar_nro_Hoja() {
////        System.out.println("Fn_buscar_nro_Hoja");
////        String nombres = "";
////        AdmCliente instance = new AdmCliente();
////        Cliente expResult = null;
////        Cliente result = instance.Fn_buscar_nro_Hoja(nombres);
////        assertEquals(expResult, result);
////    }
    
    
    @Test
    public void testRegistrarHoja() throws Exception {
        System.out.println("registrarHoja");
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        AdmCliente instance = new AdmCliente();
        instance.registrarHoja(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);

        Cliente clnt = instance.Fn_buscar_nro_Hoja(nombres);
        assertNotNull(clnt);
    }
//
////    @Test
////    public void testValidarDatosIncompletos() throws Exception {
////        System.out.println("validarDatosIncompletos");
////        String nombres = "";
////        String apellidopat = "";
////        String apellidomat = "";
////        String email = "";
////        String dni = "";
////        String telefono = "";
////        String FechaContacto = "";
////        AdmCliente instance = new AdmCliente();
////        instance.validarDatosIncompletos(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
////
////    }
//    @Test
//    public void testValidarDuplicidad() throws Exception {
//        System.out.println("validarDuplicidad");
//        String nombres = "";
//        AdmCliente instance = new AdmCliente();
//        instance.validarDuplicidad(nombres);
//
//    }
//
//    /**
//     * Test of Fn_buscar_nro_Hoja method, of class AdmCliente.
//     */
//    @Test
//    public void testFn_buscar_nro_Hoja() {
//        System.out.println("Fn_buscar_nro_Hoja");
//        String nombres = "";
//        AdmCliente instance = new AdmCliente();
//        Cliente expResult = null;
//        Cliente result = instance.Fn_buscar_nro_Hoja(nombres);
//        assertEquals(expResult, result);
//
//    }

    @Test
    public void testEliminarCliente() throws Exception {
        System.out.println("eliminarCliente");

        System.out.println("registrarHoja");
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        AdmCliente instance = new AdmCliente();
        instance.registrarHoja(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);

        Cliente clnt = instance.Fn_buscar_nro_Hoja(nombres);
        assertNotNull(clnt);
        instance.eliminarCliente(nombres);
        clnt = instance.Fn_buscar_nro_Hoja(nombres);
        assertNull(clnt);
    }

//    @Test
//    public void testIngreso() {
//        System.out.println("ingreso");
//        AdmCliente instance = new AdmCliente();
//        instance.ingreso();
//
//    }
//
//    /**
//     * Test of validarDatosIncompletos method, of class AdmCliente.
//     */
//    @Test
//    public void testValidarDatosIncompletos() throws Exception {
//        System.out.println("validarDatosIncompletos");
//        String nombres = "";
//        String apellidopat = "";
//        String apellidomat = "";
//        String email = "";
//        String dni = "";
//        String telefono = "";
//        String FechaContacto = "";
//        AdmCliente instance = new AdmCliente();
//        instance.validarDatosIncompletos(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fn_getHoja method, of class AdmCliente.
//     */
//    @Test
//    public void testFn_getHoja() {
//        System.out.println("fn_getHoja");
//        AdmCliente instance = new AdmCliente();
//        ArrayList expResult = null;
//        ArrayList result = instance.fn_getHoja();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of editarHoja method, of class AdmCliente.
     */
    @Test
    public void testEditarHoja() throws Exception {
        System.out.println("registrarHoja");
        String nombres = "Juan";
        String apellidopat = "Gonzales";
        String apellidomat = "Diaz";
        String email = "juang@gmail.com";
        String dni = "45080508";
        String telefono = "4682458";
        String FechaContacto = "20-11-2012";
        AdmCliente instance = new AdmCliente();
        instance.registrarHoja(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);

        Cliente clnt = instance.Fn_buscar_nro_Hoja(nombres);
        assertNotNull(clnt);

        apellidopat = "Gamarra";
        apellidomat = "Falcao";
        email = "gamarraf@outlook.com";
        dni = "43080208";
        telefono = "4212458";
        FechaContacto = "19-11-2012";

        instance.editarHoja(nombres, apellidopat, apellidomat, email, dni, telefono, FechaContacto);
        clnt = instance.Fn_buscar_nro_Hoja(nombres);

        assertEquals(nombres, clnt.getNombres());
        assertEquals(apellidopat, clnt.getApellidopat());
        assertEquals(apellidomat, clnt.getApellidomat());
        assertEquals(email, clnt.getEmail());
        assertEquals(dni, clnt.getDni());
        assertEquals(telefono, clnt.getTelefono());
        assertEquals(FechaContacto, clnt.getFechaContacto());
    }
   
    
    
    
//    @Test
//    public void testFn_getHoja() {
//        System.out.println("fn_getHoja");
//        AdmCliente instance = new AdmCliente();
//        ArrayList expResult = null;
//        ArrayList result = instance.fn_getHoja();
//        assertEquals(expResult, result);
//
//    }
    /**
     * Test of ingreso method, of class AdmCliente.
     */
//    @Test
//    public void testIngreso() {
//        System.out.println("ingreso");
//        AdmCliente instance = new AdmCliente();
//        instance.ingreso();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of fn_getHoja method, of class AdmCliente.
     */
//    @Test
//    public void testFn_getHoja() {
//        System.out.println("fn_getHoja");
//        AdmCliente instance = new AdmCliente();
//        ArrayList expResult = null;
//        ArrayList result = instance.fn_getHoja();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
