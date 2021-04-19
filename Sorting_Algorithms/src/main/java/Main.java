
public class Main {
    public static void main(String[] args) {

         int[] arr = new int[]{17, 5, 20, 4, 8, 34, 2};

         MergeSort mergeSort = new MergeSort(arr);

         int[] sorted = mergeSort.sort();

        for (int j : sorted) {
            System.out.print(j + " ");
        }

    }
}
