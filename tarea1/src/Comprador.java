class Comprador {
    private String sabor;
    private int vuelto;

    public Comprador(Moneda m, int tipo, Expendedor exp) {
        Producto p = exp.comprarProducto(m, tipo);
        if (p != null) {
        sabor = p.sabor();
        }
        else {
            sabor = null;
        }
        vuelto = 0;
        Moneda mon;
        while ((mon = exp.getVuelto()) != null) {
        vuelto += mon.getValor();
        }
    }
    public int cuantoVuelto() {
        return vuelto;
    }
    public String queBebiste() {
        return sabor;
    }
}
