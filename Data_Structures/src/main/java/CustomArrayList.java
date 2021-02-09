
import java.util.*;

public class CustomArrayList<E> implements List<E> {

    private final static int INITIAL_SIZE = 4;
    private Object[] elements;
    private int capacity;
    private int size;

    public CustomArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = INITIAL_SIZE;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object object : elements) {
            if (o.equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return elements[index] != null;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }


    @Override
    public Object[] toArray() {
        return this.elements;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (this.size == this.capacity){
            grow();
        }

        this.elements[size++] = e;
        return true;
    }

    private void grow() {
        this.capacity *= 2;
        Object[] temp = new Object[capacity];

        System.arraycopy(this.elements, 0, temp, 0, this.elements.length);

        this.elements = temp;

    }

    @Override
    public boolean remove(Object o) {
        if (this.contains(o)){
            int index = this.indexOf(o);
            this.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
          this.elements = new Object[INITIAL_SIZE];
          this.size = 0;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public E get(int index) {
        if (isValidIndex(index)){
            return (E) this.elements[index];
        }else {
            throw new IndexOutOfBoundsException("Not a valid index!!!");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.size;
    }

    @Override
    public E set(int index, E element) {
        if (isValidIndex(index)){
            this.elements[index] = element;
        }else {
            throw new IndexOutOfBoundsException("Not a valid index!!!");
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (isValidIndex(index)){
            this.add(element);
           shiftRight(index);
        }
    }

    private void shiftRight(int index) {
        Object temp = elements[size - 1];
        for (int i = this.size - 1; i > index; i--) {
           this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = temp;
    }

    @Override
    public E remove(int index) {
        if (isValidIndex(index)){
            E element = this.get(index);
            this.size--;
            shiftLeft(index);
            ensureCapacity();
        }
        return null;
    }

    private void ensureCapacity() {
        if (this.size < this.capacity / 3){
            this.capacity /= 2;
            this.elements = Arrays.copyOf(this.elements,this.capacity);
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[size] = null;

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (o.equals(this.get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
