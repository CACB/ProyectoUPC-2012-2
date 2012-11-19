
public class Prospecto extends Cliente {

    private int estado;

    public Prospecto(int estado) {
        this.estado = estado;
    }

    public int getEstado () {
        return estado;
    }

    public void setEstado (int val) {
        this.estado = val;
    }

}

