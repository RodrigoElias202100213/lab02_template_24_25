package pt.pa.adts.queue;

/**
 * Implementation of a Queue using a doubly linked list with header and trailer sentinels.
 *
 * @param <T> Type of elements stored in the queue.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private final ListNode header;
    private final ListNode trailer;
    private int size;

    public QueueLinkedList() {
        this.header = new ListNode(null, null, null);
        this.trailer = new ListNode(null, header, null);
        this.header.next = this.trailer;
        size = 0;
    }

    @Override
    public void enqueue(T value) throws NullPointerException {
        if (value == null) throw new NullPointerException("Cannot enqueue a null value.");

        ListNode newNode = new ListNode(value, this.trailer.prev, this.trailer);
        this.trailer.prev.next = newNode;
        this.trailer.prev = newNode;
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("Queue is empty.");

        ListNode firstNode = this.header.next;
        T value = firstNode.element;

        this.header.next = firstNode.next;
        firstNode.next.prev = this.header;

        size--;
        return value;
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("Queue is empty.");

        return this.header.next.element;
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
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
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
