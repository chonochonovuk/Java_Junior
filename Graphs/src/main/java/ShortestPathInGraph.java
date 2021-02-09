import com.sun.source.tree.IfTree;

import java.util.*;

public class ShortestPathInGraph {
    private List<List<Integer>> nodes;
    private boolean[] visited;
    private int[] path;
    private List<Integer> vertices;

    public ShortestPathInGraph(List<List<Integer>> nodes){
        this.nodes = nodes;
        visited = new boolean[nodes.size()];
        path = new int[nodes.size()];
        vertices = new ArrayList<>();
    }

    public List<Integer> getVertices() {
        return vertices;
    }

    public void find_shortest_path(int fromNode, int toNode){
        Arrays.fill(path,-1);

        bfs(fromNode,toNode);

        vertices.add(toNode);
        int prevNode = path[toNode];


        while (prevNode != -1){
            vertices.add(prevNode);
            prevNode = path[prevNode];
        }
    }

    public void bfs(int source,int destination){

            visited[source] = true;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(source);
            while (!queue.isEmpty()){
                int node = queue.poll();
                if (node == destination){
                    break;
                }
                for (int child:this.nodes.get(node)) {
                    if (!visited[child]){
                        path[child] = node;
                        visited[child] = true;
                        queue.offer(child);
                    }
                }
            }

    }
}
