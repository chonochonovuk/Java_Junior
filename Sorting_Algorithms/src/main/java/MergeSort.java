public class MergeSort {
    private final int[] array;
    public MergeSort(int[] array){
        this.array = array;
    }

    public int[] sort(){
        merge_sort(0,array.length - 1);
        return this.array;
    }

    private void merge_sort(int leftStart, int rightEnd) {
        if (leftStart >= rightEnd){
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        merge_sort(leftStart,middle);
        merge_sort(middle + 1,rightEnd);
        merge_Halves(leftStart,middle,rightEnd);

    }

    private void merge_Halves(int leftStart, int middle, int rightEnd) {

        int leftEnd = middle;
        int right = middle + 1;
        int left = leftStart;

        if (middle < 0 || middle >= this.array.length || this.array[leftEnd] < this.array[right]){
            return;
        }

        int[] temp = new int[this.array.length];


        for (int i = leftStart; i <= rightEnd ; i++) {
           temp[i] = this.array[i];
        }



        for (int i = leftStart; i <= rightEnd; i++) {

            if (left > middle){
                this.array[i] = temp[right++];
            }else if (right > rightEnd){
                this.array[i] = temp[left++];
            }else if (temp[left] < temp[right]){
                this.array[i] = temp[left++];
             } else {
                this.array[i] = temp[right++];
             }

        }


    }
}
