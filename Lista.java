public class Lista<T> {
    private Nodo<T> head = null;
    private Nodo<T> tail = null;
    private int size;

    public boolean isEmpty() {

        return head == null;
    }

    public void insert(T element) {
        Nodo<T> nuevo = new Nodo<T>(element);
        if (isEmpty()) {
            head = nuevo;
            tail = head;
        } else {
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo;
        }
    }

    public void insertLast(T element) {
        if (isEmpty()) {
            this.insert(element);
        } else {
            Nodo<T> nuevo = new Nodo<T>(element);
            tail.next = nuevo;
            nuevo.prev = tail;
            tail = nuevo;
        }
    }

    public void print(InvertirLista direction) {
        if (direction == InvertirLista.BACKWARD) {
            Nodo<T> current = tail;
            while (current != null) {
                System.out.print(current.valor + " ");
                current = current.prev;
            }
        } else {
            Nodo<T> current = head;
            while (current != null) {
                System.out.print(current.valor + " ");
                current = current.next;
            }
        }
    }

    static class ListaAutos
    {

        String diario;

        public ListaAutos(String Diario)
        {
            this.diario = Diario;
        }
        public String getDiario()
        {
            return diario;
        }
    }

    interface Collection
    {
        public Iterator createIterator();
    }


    class ListaCarros implements Collection
    {
        static final int MAX_ITEMS = 10;
        int numberOfItems = 0;
        ListaAutos[] lista;

        public ListaCarros()
        {
            lista = new ListaAutos[MAX_ITEMS];

            addItem("BMW");
            addItem("Toyota");
            addItem("Mercedes");
            addItem("Ferrari");
            addItem("Hyundai");
            addItem("Nissan");
        }

        public void addItem(String str)
        {
            ListaAutos recordatorio = new ListaAutos(str);
            if (numberOfItems >= MAX_ITEMS)
                System.err.println("Full");
            else
            {
                lista[numberOfItems] = recordatorio;
                numberOfItems = numberOfItems + 1;
            }
        }

        public Iterator createIterator()
        {
            return new StringIterator(lista);
        }
    }


    interface Iterator
    {
        boolean hasNext();
        Object next();
    }

    class StringIterator implements Iterator
    {
        ListaAutos[] ListaRecordatorio;


        int pos = 0;


        public StringIterator(ListaAutos[] listaRecordatorio)
        {
            this.ListaRecordatorio = listaRecordatorio;
        }

        public Object next()
        {
            ListaAutos listaFinal =  ListaRecordatorio[pos];
            pos += 1;
            return listaFinal;
        }

        public boolean hasNext()
        {
            if (pos >= ListaRecordatorio.length ||
                    ListaRecordatorio[pos] == null)
                return false;
            else
                return true;
        }
    }


    class PickUp
    {
        ListaCarros PickUp;

        public PickUp(ListaCarros pickUp)
        {
            this.PickUp = PickUp;
        }

        public void printLista()
        {
            Iterator iterator = PickUp.createIterator();
            System.out.println("-------Lista de Carros------------");
            while (iterator.hasNext())
            {
                ListaAutos n = (ListaAutos) iterator.next();
                System.out.println(n.getDiario());
            }
        }
    }
    public void insertarLista(Lista<T> lista) {
        Nodo<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = lista.head;
        size += lista.size;
    }

    public Lista<T> subLista(int Pos, int tamano) {
        Lista<T> subList = new Lista<>();

        Nodo<T> current = head;
        int currentPosition = 0;

        while (currentPosition < Pos && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            return subList;
        }
        while (currentPosition < Pos + tamano && current != null) {
            subList.insertLast(current.valor);
            current = current.next;
            currentPosition++;
        }
        return subList;
    }

    public void invertirLista() {
        Nodo<T> temp = null;
        Nodo<T> current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> current = head;
        while (current != null) {
            sb.append(current.valor).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}