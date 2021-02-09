package implementations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public Tree<Integer> createTreeFromStrings(String[] input) {

        for (String s : input) {
            int[] arr = Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int parentKey = arr[0];
            this.createNodeByKey(parentKey);
            int child = arr[1];
            this.createNodeByKey(child);
            this.addEdge(parentKey,child);
        }


        return this.nodesByKeys.get(Objects.requireNonNull(this.getRoot()).getKey());
    }

    private Tree<Integer> getRoot() {
        Tree<Integer> root = null;
        for (Tree<Integer> value : nodesByKeys.values()) {
            if (value.getParent() == null){
                root = value;
            }
        }
        return root;
    }

    public Tree<Integer> createNodeByKey(int key) {
        this.nodesByKeys.putIfAbsent(key,new Tree<>(key));
        return this.nodesByKeys.get(key);
    }

    public void addEdge(int parent, int child) {
       this.nodesByKeys.get(parent).addChild(this.nodesByKeys.get(child));
       this.nodesByKeys.get(child).setParent(this.nodesByKeys.get(parent));
    }
}



