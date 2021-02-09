import java.util.List;

public class Graph {
    private Node[] nodes;
    private int noOfNodes;
    private Edge[] edges;
    private int noOfEdges;


    public Graph(Edge[] edges) {
        this.edges = edges;

        // add all the edges to the nodes, each edge added to two nodes (to and from)
        this.noOfEdges = edges.length;

        this.noOfNodes = calculateNumberOfNodes(edges);
        this.nodes = initNewArrayOfNodes(this.noOfNodes);
    }

    private Node[] initNewArrayOfNodes(int noOfNodes) {
        Node[] temp = new Node[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            temp[i] = new Node();
        }

        for (int edgeToAdd = 0; edgeToAdd < this.edges.length; edgeToAdd++) {
            temp[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
            temp[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
        }

        return temp;
    }

    private int calculateNumberOfNodes(Edge[] edges) {
        int noOfNodes = 0;
        for (Edge edge:edges) {
            if (edge.getToNodeIndex() > noOfNodes){
                noOfNodes = edge.getToNodeIndex();
            }
            if (edge.getFromNodeIndex() > noOfNodes){
                noOfNodes = edge.getFromNodeIndex();
            }
        }
        noOfNodes++;
        return noOfNodes;
    }

// Implementation of Dijkstra Algorithm
    public void calculateShortestDistance(){
        //node 0 as a source
        this.nodes[0].setDistanceFromSource(0);
        int nextNode = 0;

       while (!this.nodes[nextNode].isVisited()){
            List<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

            for (int joinedEdges = 0;joinedEdges < currentNodeEdges.size();joinedEdges++){
                int neighbourIndex = currentNodeEdges.get(joinedEdges).getNeighbourNode(nextNode);

                if (!nodes[neighbourIndex].isVisited()){
                    int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdges).getLength();

                    if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
                        nodes[neighbourIndex].setDistanceFromSource(tentative);
                    }

                }
            }

            nodes[nextNode].setVisited(true);

            nextNode = getNodeShortestDistanced();
        }
    }

    private int getNodeShortestDistanced() {
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;
        for (int i = 0; i < this.nodes.length; i++) {
            int currentDist = this.nodes[i].getDistanceFromSource();
            if (!this.nodes[i].isVisited() && currentDist < storedDist) {
                storedDist = currentDist;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }

    public void printResult() {
        String output = "Number of nodes = " + this.noOfNodes;
        output += "\nNumber of edges = " + this.noOfEdges;
        for (int i = 0; i < this.nodes.length; i++) {
            output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
        }
        System.out.println(output);
    }
}
