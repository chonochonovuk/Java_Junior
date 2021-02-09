import java.util.Iterator;

public class CustomStack <E> implements Iterable<E> {
    private Node<E> top;
    private int size;
    public CustomStack(){
        this.top = null;
        this.size = 0;
    }

    private static class Node<E>{
      private final E element;
      private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public void push(E element){
        Node<E> node = new Node<>(element);
        node.next = this.top;
        this.top = node;
        this.size++;
    }

   public E pop(){
        E element = null;
        if (size != 0){
            Node<E> temp = this.top.next;
            element = this.top.element;
            this.top = temp;
            size--;
        }else {
            throw new IllegalStateException("Stack is Empty!");
        }
        return element;
   }

   public E peek(){
        E element = null;
        if (size != 0){
            element = this.top.element;
        } else {
           throw new IllegalStateException("Stack is Empty!");
       }
        return element;
   }

   @Override
   public Iterator<E> iterator(){
        return new Iterator<E>() {
            Node<E> temp = top;
            @Override
            public boolean hasNext() {
                return temp.next != null;
            }

            @Override
            public E next() {
                E element = temp.element;
                temp = temp.next;
                return element;
            }

        };
   }

    public int getSize() {
        return size;
    }
}
