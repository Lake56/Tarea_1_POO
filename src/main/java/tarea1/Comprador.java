package tarea1;

public class Comprador {

    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int queProducto, Expendedor exp){
         throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
            vuelto = 0;
            sonido = null;

            Producto p = exp.comprarProducto(m, queProducto);
            sonido = p.consumir();

            Moneda moneda;
            while ((moneda = exp.getVuelto()) != null) {
                vuelto += moneda.getValor();
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }
}