public class Main {
    public static void main(String[] args) {
       int[][] test = {{1,1},{1,2}};

       if (!isInBounds(test,2,2) || !isRightNumber(test,2,2,2)){
           System.out.println(isInBounds(test,2,2));
       }

    }

    public static boolean isInBounds(int[][] arr, int row,int col){
        return row >= 0 && row < arr.length && col >= 0 && col < arr[row].length;
    }

    public static boolean isRightNumber(int[][] arr, int row,int col, int match){
        return arr[row][col] == match;
    }
}
