import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimple<T> implements Iterable<T> {
    private Nodo cabeza;
    private int tamano;

    public T obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        return temp.dato;
    }

    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    public ListaSimple() {
        cabeza = null;
        tamano = 0;
    }
    // Método para insertar un elemento al final de la lista
    public void insertarAlFinal(T dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        tamano++;
    }
    // Método para insertar los elementos de otra lista al final de la lista original
    public void insertarLista(ListaSimple<T> otraLista) {
        for (T dato : otraLista) {
            insertarAlFinal(dato);
        }
    }
    // Método para obtener el tamaño de la lista
    public int tamano() {
        return tamano;
    }
    // Implementación del método iterator para permitir la iteración sobre la lista
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }
    // Clase interna para implementar el iterador
    private class IteradorLista implements Iterator<T> {
        private Nodo actual;

        public IteradorLista() {
            actual = cabeza;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            T dato = actual.dato;
            actual = actual.siguiente;
            return dato;
        }
    }

    // Imprimir la lista
    public void imprimirLista() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaSimple<Integer> lista1 = new ListaSimple<>();
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(2);
        lista1.insertarAlFinal(3);

        ListaSimple<Integer> lista2 = new ListaSimple<>();
        lista2.insertarAlFinal(4);
        lista2.insertarAlFinal(5);
        lista2.insertarAlFinal(6);

        System.out.println("Lista 1:");
        lista1.imprimirLista();
        System.out.println("Lista 2:");
        lista2.imprimirLista();

        lista1.insertarLista(lista2);

        System.out.println("Lista 1 después de insertar lista 2:");
        lista1.imprimirLista();

        ListaSimple<Integer> lista3 = new ListaSimple<>();
        lista3.insertarAlFinal(55);
        lista3.insertarAlFinal(72);
        lista3.insertarAlFinal(29);

        // Obtener un iterador
        Iterator<Integer> iterador = lista3.iterator();

        // Iterar sobre la lista usando el iterador
        System.out.println("Iterando sobre la lista:");
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }
        System.out.println();
    }
}
