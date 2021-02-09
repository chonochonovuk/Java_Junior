public class SinglyLinkedList<E> {

    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<E>{
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public void addFirst(E element){
        Node<E> nodeToAdd = new Node<>(element);
        nodeToAdd.next = head;
        head = nodeToAdd;
        size++;
    }

    public void addLast(E element){
        Node<E> node = new Node<>(element);
        if (this.size == 0){
            head = node;
            this.size++;
            return;
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
        this.size++;
    }

    public E removeFirst(){
        ensureNonEmpty();
        Node<E> temp = head;
        head = temp.next;
        size--;
        return temp.element;
    }

    public E removeLast(){
        ensureNonEmpty();
        E value = null;
        if (size == 1){
            value = this.head.element;
            this.head = null;
            size--;
            return value;
        }
        Node<E> previous = this.head;
        Node<E> toRemove = this.head.next;

        while (toRemove.next != null){
            previous = toRemove;
            toRemove = toRemove.next;
        }
        value = previous.next.element;
        previous.next = null;
        return  value;
    }

    public E getFirst(){
        ensureNonEmpty();
        if (this.size == 1){
            return this.head.element;
        }
        Node<E> current = this.head;
        while (current.next != null){
            current = current.next;
        }
        return current.element;
    }

    public E getLast(){
        ensureNonEmpty();
        return this.head.element;
    }

    private void ensureNonEmpty() {
        if (isEmpty()){
            throw new IllegalStateException("List is empty!!!");
        }
    }

    private boolean isEmpty(){
        return this.size == 0;
    }
}
