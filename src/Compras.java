
public class Compras extends Ventas {

    public Compras() {
    }

    public Compras(String numero, String fecha_emision, String fecha_vencimiento, String empresa, String fecha_pago, String estado, String concepto, double subtotal, double igv, double total, String moneda, String observaciones) {
        super(numero, fecha_emision, fecha_vencimiento, empresa, fecha_pago, estado, concepto, subtotal, igv, total, moneda, observaciones);
    }
}
