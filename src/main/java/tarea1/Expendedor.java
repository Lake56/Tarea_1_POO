package tarea1;

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