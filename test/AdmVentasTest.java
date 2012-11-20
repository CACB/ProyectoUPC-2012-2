/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dv2000
 */
public class AdmVentasTest {
    
    public AdmVentasTest() {
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

//    /**
//     * Test of fn_getDoc method, of class AdmVentas.
//     */
//    @Test
//    public void testFn_getDoc() {
//        System.out.println("fn_getDoc");
//        AdmVentas instance = new AdmVentas();
//        ArrayList expResult = null;
//        ArrayList result = instance.fn_getDoc();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validarDatosIncompletos method, of class AdmVentas.
//     */
//    @Test
//    public void testValidarDatosIncompletos() throws Exception {
//        System.out.println("validarDatosIncompletos");
//        String numero = "";
//        String fecha_emision = "";
//        String fecha_vencimiento = "";
//        String empresa = "";
//        String fecha_pago = "";
//        String estado = "";
//        String concepto = "";
//        double subtotal = 0.0;
//        double igv = 0.0;
//        double total = 0.0;
//        String moneda = "";
//        AdmVentas instance = new AdmVentas();
//        instance.validarDatosIncompletos(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Fn_buscar method, of class AdmVentas.
//     */
//    @Test
//    public void testFn_buscar() {
//        System.out.println("Fn_buscar");
//        String numero = "";
//        AdmVentas instance = new AdmVentas();
//        Ventas expResult = null;
//        Ventas result = instance.Fn_buscar(numero);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validarDuplicidad method, of class AdmVentas.
//     */
//    @Test
//    public void testValidarDuplicidad() throws Exception {
//        System.out.println("validarDuplicidad");
//        String numero = "";
//        AdmVentas instance = new AdmVentas();
//        instance.validarDuplicidad(numero);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of registrarDocumento method, of class AdmVentas.
     */
    @Test
    public void testRegistrarDocumento() {
        System.out.println("registrarDocumento");
        String numero = "666";
        String fecha_emision = "16/06/2012";
        String fecha_vencimiento = "16/06/2012";
        String empresa = "Peru";
        String fecha_pago = "16/06/2012";
        String estado = "0";
        String concepto = "Java";
        double subtotal = 100.0;
        double igv = 19.0;
        double total = 119.0;
        String moneda = "MN";
        AdmVentas oAdmVentas = new AdmVentas();
        
        try {
            //Act
            oAdmVentas.registrarDocumento(numero,fecha_emision,fecha_vencimiento,empresa,fecha_pago,estado,concepto,subtotal,igv,total,moneda);
            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdmVentasTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO review the generated test code and remove the default call to fail.
         Ventas oVentas = oAdmVentas.Fn_buscar(numero);
        assertNotNull(oVentas);

    }
    
//    @Test
//    public void DebeRegistrarHotelValidandoDatosIngresadosCompletos() {
//
//        //Arrange
//        String S_ctacorreo = "admin@marriot.com.pe";
//        String S_contrasenax = "123456";
//        String S_contrasenay = "123456";
//        String S_nombre = "Hotel_Marriot";
//        String S_direccion = "http://Hotel_Marriot.clerk.im";
//        boolean B_aceptartermino = true;
//        int I_canthabitacion = 0;
//
//        Ctr_hoteladmin obj_Ctr_hoteladmin = new Ctr_hoteladmin();
//        try {
//            //Act
//            obj_Ctr_hoteladmin.Fn_registrarhotel(S_ctacorreo, S_contrasenax, S_contrasenay, S_nombre, S_direccion, B_aceptartermino, I_canthabitacion);
//            //Assert
//            // Espero que ocurra un error
//        } catch (BusinessException ex) {
//            Logger.getLogger(HotelAdminTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        //Assert
//        Ent_hotel objhotel = obj_Ctr_hoteladmin.Fn_buscarnombre(S_nombre);
//        assertNotNull(objhotel);
//
//    }
//
//    /**
//     * Test of eliminarDocumento method, of class AdmVentas.
//     */
    @Test
    public void testEliminarDocumento() throws Exception {
        System.out.println("registrarDocumento");
        String numero = "666";
        String fecha_emision = "16/06/2012";
        String fecha_vencimiento = "16/06/2012";
        String empresa = "Peru";
        String fecha_pago = "16/06/2012";
        String estado = "0";
        String concepto = "Java";
        double subtotal = 100.0;
        double igv = 19.0;
        double total = 119.0;
        String moneda = "MN";
        AdmVentas oAdmVentas = new AdmVentas();
        
        try {
            //Act
            oAdmVentas.registrarDocumento(numero,fecha_emision,fecha_vencimiento,empresa,fecha_pago,estado,concepto,subtotal,igv,total,moneda);
            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdmVentasTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO review the generated test code and remove the default call to fail.
        Ventas oVentas = oAdmVentas.Fn_buscar(numero);
        assertNotNull(oVentas);
        
        oAdmVentas.eliminarDocumento(numero);
        oVentas = oAdmVentas.Fn_buscar(numero);
        assertNull(oVentas);
    }

    /**
     * Test of editarDocumento method, of class AdmVentas.
     */
    @Test
    public void testEditarDocumento() throws Exception {
        System.out.println("editarDocumento");
        String numero = "666";
        String fecha_emision = "16/06/2012";
        String fecha_vencimiento = "16/06/2012";
        String empresa = "Peru";
        String fecha_pago = "16/06/2012";
        String estado = "0";
        String concepto = "Java";
        double subtotal = 100.0;
        double igv = 19.0;
        double total = 119.0;
        String moneda = "MN";
        AdmVentas oAdmVentas = new AdmVentas();
        
        try {
            //Act
            oAdmVentas.registrarDocumento(numero,fecha_emision,fecha_vencimiento,empresa,fecha_pago,estado,concepto,subtotal,igv,total,moneda);
            //Assert
            // Espero que ocurra un error
        } catch (BusinessException ex) {
            Logger.getLogger(AdmVentasTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO review the generated test code and remove the default call to fail.
         Ventas oVentas = oAdmVentas.Fn_buscar(numero);
        assertNotNull(oVentas);
        
        
        

    }
}
