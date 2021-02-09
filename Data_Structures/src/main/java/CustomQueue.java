import java.util.AbstractQueue;
import java.util.Iterator;

public class CustomQueue<E> extends AbstractQueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;
    public CustomQueue(){
        this.first = null;
        this.size = 0;
    }
    private static class Node<E>{
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean offer(E e) {
        Node<E> temp = new Node<>(e);
        if (size != 0) {
           this.last.next = temp;
           this.last = temp;
        }else {
            this.first = this.last = temp;
        }
        this.size++;
        return true;
    }

    @Override
    public E poll() {
        E element = null;
        if (size != 0){
            element = this.first.element;
            Node<E> temp = this.first.next;
            this.first = temp;
        }
        return element;
    }

    @Override
    public E peek() {
        E element = null;
        if (size != 0){
            element = this.first.element;
        }
        return element;
    }
}
