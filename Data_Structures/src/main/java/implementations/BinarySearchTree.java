package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;

    @Override
    public void insert(E element) {
        Node<E> toInsert = new Node<>(element);
        if (this.root == null){
            this.root = toInsert;
        }else {
            Node<E> root = this.root;
            Node<E> leaf = root;
            Node<E> prevLeaf = null;
            while (leaf != null){
                prevLeaf = leaf;
                if (isLess(toInsert.value,leaf.value)){
                    leaf = leaf.leftChild;
                }else if (isGreater(toInsert.value,leaf.value)){
                    leaf = leaf.rightChild;
                }else if (areEquals(toInsert.value,leaf.value)){
                    return;
                }
            }

            if (isLess(toInsert.value,prevLeaf.value)){
                prevLeaf.leftChild = toInsert;
            }
            if (isGreater(toInsert.value,prevLeaf.value)){
                prevLeaf.rightChild = toInsert;
            }

        }

    }

    private boolean isLess(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private boolean isGreater(E first, E second) {
        return first.compareTo(second) > 0;
    }

    private boolean areEquals(E first, E second) {
        return first.compareTo(second) == 0;
    }

    @Override
    public boolean contains(E element) {
        Node<E> lookUp = this.root;
        while (lookUp != null){
          if (isLess(element,lookUp.value)){
              lookUp = lookUp.leftChild;
          }else if (isGreater(element,lookUp.value)){
              lookUp = lookUp.rightChild;
          }else if (areEquals(element,lookUp.value)){
             return true;
          }
        }
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        AbstractBinarySearchTree<E> searchTree = new BinarySearchTree<>();
        Node<E> lookUp = this.root;
        while (lookUp != null){
            if (isLess(element,lookUp.value)){
                lookUp = lookUp.leftChild;
            }else if (isGreater(element,lookUp.value)){
                lookUp = lookUp.rightChild;
            }else if (areEquals(element,lookUp.value)){
                return null;
            }
        }
        return null;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }
}
