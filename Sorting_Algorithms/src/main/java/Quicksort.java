public class Quicksort {
    private int[] arrayToSort;

    public Quicksort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }


    public void sort(){
        quicksort(0,arrayToSort.length -1);
    }

    private void quicksort(int begin, int end) {
        if (begin >= end){
            return;
        }

        int pivot = arrayToSort[(begin + end) / 2];

        int index = partition(begin,end,pivot);

        quicksort(begin, index - 1);
        quicksort(index,end);
    }

    private int partition(int begin, int end, int pivot) {

        int left = begin;
        int right = end;

        while (left <= right){
            while (arrayToSort[left] < pivot){
                left++;
            }
            while (arrayToSort[right] > pivot){
                right--;
            }

            if (left <= right){
                int temp = arrayToSort[left];
                arrayToSort[left] = arrayToSort[right];
                arrayToSort[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
