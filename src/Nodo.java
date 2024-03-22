public class Nodo<T> {
    public T valor;
    public Nodo<T> next = null;
    public Nodo<T> prev = null;

    public Nodo(T valor) {
        this.valor = valor;
    }
}