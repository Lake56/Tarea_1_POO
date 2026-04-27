class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snicker;
    private Deposito<Producto> super8;
    private Deposito<Moneda> vuelto;

    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKER = 4;
    public static final int SUPER8 = 5;
    private int precio;

    public Expendedor(int numProductos, int precio) {
        this.precio = precio;
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta= new Deposito<Producto>();
        snicker=new Deposito<Producto>();
        super8=new Deposito<Producto>();
        vuelto = new Deposito<Moneda>();

        for (int i = 0; i < numProductos; i++) {
            coca.add(new CocaCola(100 + i));
            sprite.add(new Sprite(200 + i));
            fanta.add(new Fanta(300+i));
            super8.add(new Super8(400+i));
            snicker.add(new Snickers(500+i));
        }
    }
    public Producto comprarProducto(Moneda m, int producto) {
        if (m == null || m.getValor() < precio) {
            if (m != null) vuelto.add(m);
            return null;
        }
        if (producto !=COCA && producto !=SPRITE && producto !=FANTA && producto !=SNICKER && producto !=SUPER8) {
            vuelto.add(m);
            return null;
        }
        if ((producto==COCA && coca.isEmpty()) || (producto==SPRITE && sprite.isEmpty()) || (producto==FANTA && fanta.isEmpty()) || (producto==SNICKER && snicker.isEmpty()) || producto==SUPER8 && super8.isEmpty()) {
            vuelto.add(m);
            return null;
        }
        int cambio = m.getValor() - precio;
        while (cambio >= 100) {
            vuelto.add(new Moneda100());
            cambio -= 100;
        }
        if (producto == COCA) {
            return coca.get();
        } else if (producto==SPRITE){
            return sprite.get();
        }
        else if(producto==FANTA){
            return fanta.get();
        }
        else if(producto==SNICKER){
            return snicker.get();
        }
        else{
            return super8.get();
        }
    }
    public Moneda getVuelto() {
        return vuelto.get();
    }
}