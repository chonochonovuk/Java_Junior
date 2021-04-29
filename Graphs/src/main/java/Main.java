import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
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

        GraphTraversalDFS traverseDFS = new GraphTraversalDFS(graph);

        traverseDFS.find_connected_vertices();

    }
}
