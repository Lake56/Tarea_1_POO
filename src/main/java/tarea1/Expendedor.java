package tarea1;

import java.util.ArrayList;

public class Expendedor {
    //dep para productos
    private Deposito<Producto> depositoCoca;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;

    private Deposito<Moneda> depositoVuelto;

    public Expendedor(int numProductos) {
        depositoCoca = new Deposito<Producto>();
        depositoSprite = new Deposito<Producto>();
        depositoFanta = new Deposito<Producto>();
        depositoSnickers = new Deposito<Producto>();
        depositoSuper8 = new Deposito<Producto>();
        depositoVuelto = new Deposito<Moneda>();

        //se llenan todos magicamente x igual
        for (int i = 0; i < numProductos; i++) {
            depositoCoca.add(new CocaCola(i));
            depositoSprite.add(new Sprite(i));
            depositoFanta.add(new Fanta(i));
            depositoSnickers.add(new Snickers(i));
            depositoSuper8.add(new Super8(i));
        }
    }

    //"tipoProduct" cambiara dependiendo el nombre del enum
    private Deposito<Producto> getDeposito(tipoProduct tipo) {
        if (tipo == tipoProduct.COCA) {
            return depositoCoca;
        }
        if (tipo == tipoProduct.SPRITE) {
            return depositoSprite;
        }
        if (tipo == tipoProduct.FANTA) {
            return depositoFanta;
        }
        if (tipo == tipoProduct.SNICKERS) {
            return depositoSnickers;
        }
        if (tipo == tipoProduct.SUPER8) {
            return depositoSuper8;
        }
        return null;
    }

    public Producto comprarProducto(Moneda m, int cualProducto)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        if (m == null) {
            throw new PagoIncorrectoException("Sin moneda para comprar.");
        }

        //getProducto ocupa la "id"
        tipoProduct tipo = tipoProduct.getProducto(cualProducto);
        Deposito<Producto> dep = null;
        if (tipo != null) {
            dep = getDeposito(tipo);
        }
        //excepciones en el expendedor
        //es el get q se ocupo para pa3p de deposito
        Producto p = dep.get();
        if (p == null){
            depositoVuelto.add(m.getSerie());
            throw new NoHayProductoException("No hay producto en el deposito " + cualProducto + ".");
        }

        if (m.getValor() < tipo.getPrecio()) {
            depositoVuelto.add(m.getSerie());
            dep.add(p);
            throw new PagoInsuficienteException("Pago insuficiente");
        }

        int diferencia = m.getValor()-tipo.getPrecio();
        //bucle para agregar las monedas del vuelto
        while (diferencia>= 100) {
            depositoVuelto.add(new Moneda100());
            diferencia -=100;
        }

        return p;
    }

    public Moneda getVuelto() {
        return depositoVuelto.get();
    }
}