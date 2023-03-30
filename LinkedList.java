public class LinkedList<T> implements List<T> {
    private class Node {
        T data;
        Node next;
    
        public Node(T x) {
            data = x;
            next = null;
        }
    }
    
    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public T get(int pos) {
        if (head == null || pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public boolean add(T item) {
        if (head == null) {
            head = new Node(item);
            ++size;
            return true;
        }
        Node curr = head;
        Node node = new Node(item);
        node.next = curr;
        head = node;
        ++size;
        return true;
    }

    public void add(int pos, T item) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            Node node = new Node(item);
            node.next = head;
            head = node;
            ++size;
        }
        else {
            Node curr = head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }
            Node node = new Node(item);
            node.next = curr.next;
            curr.next = node;
            ++size;
        }
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            Node node = head;
            head = head.next;
            --size;
            return node.data;
        }
        else {
            Node curr = head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }
            Node node = curr.next;
            curr.next = node.next;
            --size;
            return node.data;
        }
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new LLIterator<T>();
    }

    private class LLIterator<T> implements Iterator<T> {
        private Node node = head;

        public boolean hasNext() {
            return node.next != null;
        }

        public T next() {
            Node prev = node;
            node = node.next;
            return (T) prev.data;
        }
    }
}
