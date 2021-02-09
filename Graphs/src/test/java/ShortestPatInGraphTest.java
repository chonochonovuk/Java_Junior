import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShortestPatInGraphTest {
    private List<List<Integer>> graph;

    @Before
    public void initVertices(){
        graph = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(3);
        graph.get(4).add(5);
        graph.get(5).add(8);
        graph.get(5).add(6);
        graph.get(5).add(7);
        graph.get(6).add(7);
        graph.get(7).add(8);

    }

    @Test
    public void test_find_shortest_path_in_Graph(){
        ShortestPathInGraph spg = new ShortestPathInGraph(graph);
        spg.find_shortest_path(1,7);
        List<Integer> vertices = spg.getVertices();

        Assert.assertEquals(4,vertices.size());
        Assert.assertTrue(vertices.contains(7));
        Assert.assertTrue(vertices.contains(5));
        Assert.assertTrue(vertices.contains(4));
        Assert.assertTrue(vertices.contains(1));
    }
}
