package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {

    private E key;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> leftChild, BinaryTree<E> rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
      this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(addRepeatSpace(indent)).append(this.getKey());

        if (this.getLeft() != null){
            sb.append("\r\n").append(this.getLeft().asIndentedPreOrder(indent + 2));
        }

        if (this.getRight() != null){
            sb.append("\r\n").append(this.getRight().asIndentedPreOrder(indent + 2));
        }

        return sb.toString();
    }

    private String addRepeatSpace(int indent) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            space.append(" ");
        }
        return space.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> preOrdered = new ArrayList<>();
        preOrdered.add(this);

        if (this.getLeft() != null){
            preOrdered.addAll(this.getLeft().preOrder());
        }

        if (this.getRight() != null){
            preOrdered.addAll(this.getRight().preOrder());
        }

        return preOrdered;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> inOrdered = new ArrayList<>();


        if (this.getLeft() != null){
            inOrdered.addAll(this.getLeft().inOrder());
        }

        inOrdered.add(this);

        if (this.getRight() != null){
            inOrdered.addAll(this.getRight().inOrder());
        }

        return inOrdered;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> postOrdered = new ArrayList<>();


        if (this.getLeft() != null){
            postOrdered.addAll(this.getLeft().postOrder());
        }


        if (this.getRight() != null){
            postOrdered.addAll(this.getRight().postOrder());
        }

        postOrdered.add(this);

        return postOrdered;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {


       if (this.getLeft() != null){
           this.getLeft().forEachInOrder(consumer);
       }
       consumer.accept(this.getKey());
       if (this.getRight() != null){
           this.getRight().forEachInOrder(consumer);
       }
    }
}
