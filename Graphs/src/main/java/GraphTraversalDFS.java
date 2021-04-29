import java.util.*;
import java.util.stream.Collectors;

public class GraphTraversalDFS {
    public boolean[] visited;
    public List<Deque<Integer>> path;
    public List<List<Integer>> graph;

    public GraphTraversalDFS(List<List<Integer>> graph){
        this.graph = graph;
        this.path = new ArrayList<>(graph.size());
        this.visited = new boolean[graph.size()];

    }

    public void find_connected_vertices(){
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]){
                path.add(new ArrayDeque<>());
                dfs(i);
            }
        }
    }

    private void dfs(int node) {
        if (!visited[node]){
            visited[node] = true;
            for (int child:graph.get(node)) {
                dfs(child);
            }
            path.get(path.size() - 1).offer(node);
        }
    }

}
