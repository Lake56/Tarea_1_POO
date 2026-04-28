import java.util.ArrayList;
class Deposito<T> {
    private ArrayList<T> lista;
    public Deposito() {
        lista = new ArrayList<T>();
    }
    public void add(T obj) {
        lista.add(obj);
    }
    public T get() {
        if (lista.size() == 0) {
            return null;
        }else {
            return lista.remove(0);
        }
    }
    public boolean isEmpty() {
        return lista.size() == 0;
    }
}

