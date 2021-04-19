public class Permutation {
    private boolean[] visited;
    private char[] toPermute;
    private char[] permute;
    public Permutation(char[] array){
        toPermute = array;
        visited = new boolean[array.length];
        permute = new char[array.length];
    }
    public void permutationWithRepetition() {
        dfs(0);
    }
    public void dfs(int index){
        if (index >= toPermute.length){
            print(permute);
            return;
        }

        for (int i = 0; i < toPermute.length; i++) {
            if (!visited[i]){
                visited[i] = true;
                permute[index] = toPermute[i];
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }

    private static void print(char[] permutations) {
        for (int i = 0; i < permutations.length; i++) {
            System.out.print(permutations[i]);
        }
        System.out.println();
    }
}
