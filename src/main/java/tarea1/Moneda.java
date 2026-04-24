package tarea1;

//interfaz del comparable
public abstract class Moneda implements Comparable{
    //constructor
    public Moneda() {}
    //getters
    public Moneda getSerie() {
        return this;
    }
    public abstract int getValor();

    public int compareTo(Moneda otra) {
        return this.getValor()-otra.getValor();
    }
    //tostring
    public String toString() {
        return "Moneda: serie=" + hashCode() + ", valor=" + getValor() + "]";
    }
}
//tipos de monedas

class Moneda1000 extends Moneda {
    public Moneda1000() { super(); }
    public int getValor() { return 1000; }
}

class Moneda500 extends Moneda {
    public Moneda500() { super(); }
    public int getValor() { return 500; }
}

class Moneda100 extends Moneda {
    public Moneda100() { super(); }
    public int getValor() { return 100; }
}