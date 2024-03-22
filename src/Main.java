//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso
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
    }
}
