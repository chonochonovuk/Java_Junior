package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private final E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key){
        this.key = key;
        this.children = new ArrayList<>();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
       this.children.add(child);
       child.setParent(this);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder sb = new StringBuilder();
        dfs(sb ,0 ,this);
        return sb.toString().trim();
    }

    private void dfs(StringBuilder sb, int level,Tree<E> tree) {
        sb.append(this.addPaddings(level));
        sb.append(tree.getKey());
        sb.append("\r\n");
        if (tree.getChildren().isEmpty()){
            return;
        }
        for (Tree<E> child:tree.getChildren()){
            dfs(sb,level + 2,child);

        }

    }

    private String addPaddings(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    @Override
    public List<E> getLeafKeys() {
        List<E> leaves = new ArrayList<>();
        if (!this.children.isEmpty()){
            for (Tree<E> child:children) {
                leaves.add(child.getKey());
            }
        }
        return leaves;
    }

    @Override
    public List<E> getMiddleKeys() {
        return null;
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        return null;
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }
}



