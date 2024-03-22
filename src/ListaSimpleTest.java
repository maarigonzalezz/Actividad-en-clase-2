import org.junit.Test;
import static org.junit.Assert.*;

public class ListaSimpleTest {

    @Test
    public void testInsertarAlFinal() {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        assertEquals(3, lista.tamano());
        assertEquals(Integer.valueOf(1), lista.obtener(0));
        assertEquals(Integer.valueOf(2), lista.obtener(1));
        assertEquals(Integer.valueOf(3), lista.obtener(2));
    }

    @Test
    public void testInsertarLista() {
        ListaSimple<Integer> lista1 = new ListaSimple<>();
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(2);
        lista1.insertarAlFinal(3);

        ListaSimple<Integer> lista2 = new ListaSimple<>();
        lista2.insertarAlFinal(4);
        lista2.insertarAlFinal(5);
        lista2.insertarAlFinal(6);

        lista1.insertarLista(lista2);

        assertEquals(6, lista1.tamano());
        assertEquals(Integer.valueOf(1), lista1.obtener(0));
        assertEquals(Integer.valueOf(2), lista1.obtener(1));
        assertEquals(Integer.valueOf(3), lista1.obtener(2));
        assertEquals(Integer.valueOf(4), lista1.obtener(3));
        assertEquals(Integer.valueOf(5), lista1.obtener(4));
        assertEquals(Integer.valueOf(6), lista1.obtener(5));
    }
}
