import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        Ventas oVentas = oAdmVentas.Fn_buscar_nro_documento(numero);
        assertNotNull(oVentas);
    }

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
        Ventas oVentas = oAdmVentas.Fn_buscar_nro_documento(numero);
        assertNotNull(oVentas);
        
        oAdmVentas.eliminarDocumento(numero);
        oVentas = oAdmVentas.Fn_buscar_nro_documento(numero);
        assertNull(oVentas);
    }

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
         Ventas oVentas = oAdmVentas.Fn_buscar_nro_documento(numero);
        assertNotNull(oVentas);        
        
        
        fecha_emision = "17/07/2012";
        fecha_vencimiento = "17/07/2012";
        empresa = "Peru";
        fecha_pago = "17/07/2012";
        estado = "1";
        concepto = "C#";
        subtotal = 200.0;
        igv = 38.0;
        total = 238.0;
        moneda = "ME";        
        
        oAdmVentas.editarDocumento(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda);           
        
        oVentas = oAdmVentas.Fn_buscar_nro_documento(numero);        
        
        assertEquals(fecha_emision, oVentas.getFecha_emision());
        assertEquals(fecha_vencimiento, oVentas.getFecha_vencimiento());
        assertEquals(empresa, oVentas.getEmpresa());
        assertEquals(fecha_pago, oVentas.getFecha_pago());
        assertEquals(estado, oVentas.getEstado());        
        assertEquals(concepto, oVentas.getConcepto());
        assertEquals(subtotal, oVentas.getSubtotal(),0);
        assertEquals(igv, oVentas.getIgv(),0);
        assertEquals(total, oVentas.getTotal(),0);
        assertEquals(moneda, oVentas.getMoneda());        
    }
    
//    public ArrayList<String> fn_MostrarDocumentos(String numero) {
//
//        ArrayList<String> objlistanombre = new ArrayList<String>();
//
//        //posibles nombres
//        objlistanombre.add(S_nombre + "_Premium");
//        objlistanombre.add(S_nombre + "_Estelar");
//        objlistanombre.add(S_nombre + "_Residencial");
//        objlistanombre.add(S_nombre + "_Exclusivo");
//        objlistanombre.add(S_nombre + "_Primera Clase");
//
//        for (String nombrealternativo : objlistanombre) {
//
//            if (Fn_buscarnombre(nombrealternativo) != null) {
//
//                objlistanombre.remove(nombrealternativo);
//            }
//        }
//
//        if (objlistanombre.size() < 5) {
//
//
//            for (int i = 0; i < 5 - objlistanombre.size(); i++) {
//
//                int x = ((int) Math.random() * 100);
//                objlistanombre.add(S_nombre + "_" + Integer.toString(x));
//            }
//
//
//        }
//
//        return objlistanombre;
//    }
}
