package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap(){
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);

    }

    private void heapifyUp(int index) {
        if (index <= 0){
            return;
        }
        E child = this.elements.get(index);
        E parent = this.elements.get((index - 1)/2);
        if (child.compareTo(parent) > 0){
            this.elements.set(index,parent);
            this.elements.set((index - 1)/2,child);
        }
        heapifyUp((index - 1)/2);
    }

    @Override
    public E peek() {
        if (this.size() == 0){
            throw new IllegalStateException("Empty heap!");
        }
        return this.elements.get(0);
    }
}
