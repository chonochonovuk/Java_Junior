public class Edge {
    private int[] source;
    private int[] dest;

    public Edge(int sRow, int sCol){
        this.source = new int[] {sRow, sCol};
    }

    public int[] getSource() {
        return source;
    }

    public int[] getDest() {
        return dest;
    }

    public void setDest(int row,int col) {
        this.dest = new int[] {row, col};
    }
}
