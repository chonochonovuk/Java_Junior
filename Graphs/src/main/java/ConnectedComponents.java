
import java.util.*;

public class ConnectedComponents {

    public List<Edge> graph = new ArrayList<>();
    public char[][] matrix;
    public boolean[][] visited;
    public boolean[] visitedNode;

    public void connectedComponents(){
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    dfs(i,j,matrix[i][j]);
                }
            }
        }
        System.out.println();
        visitedNode = new boolean[graph.size()];

        Map<Character, Integer> areas = new TreeMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedNode[i]){
                Edge edge = graph.get(i);
                char key = matrix[edge.getSource()[0]][edge.getSource()[1]];
                areas.putIfAbsent(key,0);
                areas.put(key,areas.get(key) + 1);
                bfs(i);
            }
        }

        System.out.println("Areas: " + areas.values().stream().mapToInt(a -> a).sum());

        for (Map.Entry<Character, Integer> entry : areas.entrySet()) {
            System.out.println("Letter '" + entry.getKey() + "' -> " + entry.getValue());
        }

    }

    private void bfs(int source) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visitedNode[source] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            Edge edge = graph.get(node);
            if (edge.getDest() != null) {
                visitedNode[node + 1] = true;
                queue.offer(node + 1);
            }
        }
    }

    private void dfs(int row, int col, char areaSymbol) {
        if(isOutOfBound(row,col) || visited[row][col] || matrix[row][col] != areaSymbol){
            return;
        }

        visited[row][col] = true;
        Edge edge = new Edge(row,col);
        graph.add(edge);

        if(isInBound(row,col + 1) && !visited[row][col + 1] && matrix[row][col + 1] == areaSymbol){
            graph.get(graph.size() - 1).setDest(row, col + 1);
            dfs(row, col + 1, areaSymbol);
        }

        if(isInBound(row,col - 1) && !visited[row][col - 1] && matrix[row][col - 1] == areaSymbol){
            graph.get(graph.size() - 1).setDest(row, col - 1);
            dfs(row, col - 1, areaSymbol);
        }

        if(isInBound(row + 1,col) && !visited[row + 1][col] && matrix[row + 1][col] == areaSymbol){
            graph.get(graph.size() - 1).setDest(row + 1, col);
            dfs(row + 1, col, areaSymbol);
        }

        if(isInBound(row - 1,col) && !visited[row - 1][col] && matrix[row - 1][col] == areaSymbol){
            graph.get(graph.size() - 1).setDest(row - 1, col);
            dfs(row - 1, col, areaSymbol);
        }
    }

    private boolean isInBound(int row, int col) {
        return !isOutOfBound(row,col);
    }

    private boolean isOutOfBound(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
