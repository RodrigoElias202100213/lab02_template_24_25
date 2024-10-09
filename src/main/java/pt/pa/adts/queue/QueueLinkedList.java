package pt.pa.adts.queue;

/**
 * Implementation of a Queue using a doubly linked list with header and trailer sentinels.
 *
 * @param <T> Type of elements stored in the queue.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    @Override
    public void enqueue(T value) throws NullPointerException {
        if (value == null) throw new NullPointerException("Cannot enqueue a null value.");

        ListNode newNode = new ListNode(value, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("Queue is empty.");

        ListNode firstNode = header.next;
        T value = firstNode.element;

        header.next = firstNode.next;
        firstNode.next.prev = header;

        size--;
        return value;
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("Queue is empty.");

        return header.next.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
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
