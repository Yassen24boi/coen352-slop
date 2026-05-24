package prob2;

public class LinkedListDictionary<Key, E>
        implements ADTDictionary<Key, E> {

    /**
     * Internal record structure.
     */
    private record KVPair<Key, E>(
            Key key,
            E value
    ) {}

    /**
     * Node class for linked list.
     */
    private class Node {

        KVPair<Key, E> data;
        Node next;

        Node(KVPair<Key, E> data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Head of linked list.
     */
    private Node head;

    /**
     * Current size.
     */
    private int size;

    /**
     * Constructor.
     */
    public LinkedListDictionary() {

        head = null;
        size = 0;
    }

    /**
     * Remove all entries.
     */
    @Override
    public void clear() {

        head = null;
        size = 0;
    }

    /**
     * Insert key-value pair.
     */
    @Override
    public void insert(Key k, E e) {

        KVPair<Key, E> pair =
                new KVPair<>(k, e);

        Node newNode = new Node(pair);

        newNode.next = head;

        head = newNode;

        size++;
    }

    /**
     * Remove by key.
     */
    @Override
    public E remove(Key k) {

        if (head == null)
            return null;

        // remove head
        if (head.data.key().equals(k)) {

            E value = head.data.value();

            head = head.next;

            size--;

            return value;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.key().equals(k)) {

                E value =
                        current.next.data.value();

                current.next =
                        current.next.next;

                size--;

                return value;
            }

            current = current.next;
        }

        return null;
    }

    /**
     * Remove any entry.
     */
    @Override
    public E removeAny() {

        if (head == null)
            return null;

        E value = head.data.value();

        head = head.next;

        size--;

        return value;
    }

    /**
     * Find value by key.
     */
    @Override
    public E find(Key k) {

        Node current = head;

        while (current != null) {

            if (current.data.key().equals(k)) {

                return current.data.value();
            }

            current = current.next;
        }

        return null;
    }

    /**
     * Current size.
     */
    @Override
    public int size() {

        return size;
    }

    /**
     * String representation.
     */
    @Override
    public String toString() {

        String result = "";

        Node current = head;

        while (current != null) {

            result += current.data.key()
                    + ":"
                    + current.data.value()
                    + " , ";

            current = current.next;
        }

        return result;
    }
}
