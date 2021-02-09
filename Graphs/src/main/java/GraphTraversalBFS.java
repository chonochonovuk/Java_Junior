import java.util.*;
import java.util.stream.Collectors;

public class GraphTraversalBFS {
    public boolean[] visited;
    public List<Deque<Integer>> connectedNodes = new ArrayList<>();

    public void find_connected_vertices(List<List<Integer>> graph){

        visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]){
                connectedNodes.add(new ArrayDeque<>());
                bfs(i,graph,visited);
            }
        }
        System.out.println();
    }

    private void bfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]){
            Deque<Integer> queue = new ArrayDeque<>();
            visited[node] = true;
            queue.offer(node);
            while (!queue.isEmpty()){
                int parent = queue.poll();
                connectedNodes.get(connectedNodes.size() - 1).offer(parent);
                for (int child:graph.get(parent)) {
                    if (!visited[child]){
                        queue.offer(child);
                    }

                }
            }
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

        GraphTraversalBFS graphTraversalBFS = new GraphTraversalBFS();
        graphTraversalBFS.find_connected_vertices(graph);

    }
}
