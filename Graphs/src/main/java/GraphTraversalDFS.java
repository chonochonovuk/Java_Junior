import java.util.*;
import java.util.stream.Collectors;

public class GraphTraversalDFS {
    public boolean[] visited;
    public List<Deque<Integer>> path = new ArrayList<>();

    public void find_connected_vertices(List<List<Integer>> graph){

        visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]){
                path.add(new ArrayDeque<>());
                dfs(i,graph,visited);
            }
        }

    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]){
            visited[node] = true;
            for (int child:graph.get(node)) {
                dfs(child,graph,visited);
            }
            path.get(path.size() - 1).offer(node);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            String sequence = sc.nextLine();
            if (!sequence.isEmpty()){
                List<Integer> list = Arrays.stream(sequence.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
                graph.add(list);
            }else {
                graph.add(new ArrayList<>());
            }
        }

        GraphTraversalDFS traverseDFS = new GraphTraversalDFS();

        traverseDFS.find_connected_vertices(graph);

    }
}
