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