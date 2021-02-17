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
       // dfs(sb ,0 ,this);
        bfs(sb,this);
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

    private void bfs(StringBuilder sb, Tree<E> tree){
        int level = 0;
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            Tree<E> current = queue.poll();
            if (current.getParent() != null && current.getParent().getKey().equals(this.getKey())){
                level = 2;
            } else if (current.getChildren().size() == 0){
                level = 4;
            }

            sb.append(this.addPaddings(level));
            sb.append(current.getKey());
            sb.append("\r\n");
            for (Tree<E> child : current.getChildren()) {
                queue.offer(child);
            }
        }
    }

    private List<E> leafKeys(){
        List<E> leaves = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()){
            Tree<E> current = queue.poll();
            if (current.getChildren().isEmpty()){
                leaves.add(current.getKey());
            }
            for (Tree<E> child : current.getChildren()) {
                queue.offer(child);
            }
        }
        return leaves;
    }

    private List<E> middleKeys() {
        List<E> middleKeys = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()){
            Tree<E> current = queue.poll();
            if (!current.getChildren().isEmpty() && current.getParent() != null){
                middleKeys.add(current.getKey());
            }
            for (Tree<E> child : current.getChildren()) {
                queue.offer(child);
            }
        }
        return middleKeys;
    }

    private void dfsAllNodes(List<Tree<E>> allNodes, Tree<E> tree) {

        allNodes.add(tree);

        for (Tree<E> child : tree.getChildren()) {
            dfsAllNodes(allNodes,child);
        }


    }

    private void dfsDeepestNode(List<Tree<E>> allNodes, int[] maxPath, int max,Tree<E> tree) {

        if (max > maxPath[0]) {
            maxPath[0] = max;
            allNodes.add(tree);
        }

        for (Tree<E> child : tree.getChildren()) {
            dfsDeepestNode(allNodes,maxPath,max + 1,child);
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
        return this.leafKeys();
    }

    @Override
    public List<E> getMiddleKeys() {
        return this.middleKeys();
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> leftDeepestLeaf = new ArrayList<>();
        this.dfsAllNodes(leftDeepestLeaf,this);
        int maxSteps = 0;
        Tree<E> deepest = null;
        for (Tree<E> tree : leftDeepestLeaf) {
            if (tree.isLeaf()){
                int treePath = this.calculatePathToTop(tree);
                if (treePath > maxSteps){
                    maxSteps = treePath;
                    deepest = tree;
                }
            }
        }

        return deepest;
    }

    public Tree<E> deepestLeftmostNodeWithDFS(){
        List<Tree<E>> leftDeepestLeaf = new ArrayList<>();
        int[] maxSteps = new int[1];
        this.dfsDeepestNode(leftDeepestLeaf,maxSteps,0,this);

        return leftDeepestLeaf.get(leftDeepestLeaf.size() - 1);
    }

    private int calculatePathToTop(Tree<E> tree) {
        Tree<E> current = tree;

        int stepsToTop = 0;

        while (current.getParent() != null){
            stepsToTop++;
            current = current.getParent();
        }

        return stepsToTop;
    }

    private boolean isLeaf() {
        return this.getParent() != null && this.getChildren().isEmpty();
    }


    @Override
    public List<E> getLongestPath() {
        Tree<E> deepestTree = this.getDeepestLeftmostNode();
        List<E> path = new ArrayList<>();
        Tree<E> previous = deepestTree;
        while (previous != null){
            path.add(previous.getKey());
            previous = previous.getParent();
        }
        Collections.reverse(path);
        return path;
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



