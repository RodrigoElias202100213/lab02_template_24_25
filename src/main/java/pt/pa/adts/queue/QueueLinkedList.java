package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T>  {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

    public void enqueue(T value) throws QueueFullException,NullPointerException {

    }
    public T dequeue() throws QueueEmptyException {
        return null;
    }
    public T front() throws QueueEmptyException {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear(){

    }


    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
