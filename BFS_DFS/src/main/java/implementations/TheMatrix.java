package implementations;

import java.util.ArrayDeque;
import java.util.Deque;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        char toReplace = this.matrix[startRow][startCol];

       dfs(startRow,startCol,fillChar,toReplace);

    }

    private void dfs(int row, int col, char fillChar, char toBeReplaced) {
        if (!isInBound(row,col) || !isCharReplaceable(row,col,toBeReplaced)){
            return;
        }

        this.matrix[row][col] = fillChar;
        dfs(row + 1, col, fillChar, toBeReplaced);
        dfs(row - 1, col, fillChar, toBeReplaced);
        dfs(row , col + 1, fillChar, toBeReplaced);
        dfs(row , col - 1, fillChar, toBeReplaced);
    }

    private boolean isInBound(int row,int col){
        return row >= 0 && row < this.matrix.length && col >= 0 && col < this.matrix[row].length;
    }
    private boolean isCharReplaceable(int row,int col, char toReplace){
        return this.matrix[row][col] == toReplace;
    }
    public String toOutputString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\r\n");
        }
        return sb.toString().trim();
    }
}
