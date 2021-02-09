import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    private int[] array;
    public MergeSort(int[] array){
        this.array = array;
    }

    public int[] sort(){
        merge_sort(array,0,array.length - 1);
        return this.array;
    }

    private void merge_sort(int[] array, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd){
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        merge_sort(array,leftStart,middle);
        merge_sort(array,middle + 1,rightEnd);
        merge_Halves(array,leftStart,middle,rightEnd);

    }

    private void merge_Halves(int[] array, int leftStart, int middle, int rightEnd) {

        int leftEnd = middle;
        int right = middle + 1;
        int left = leftStart;

        if (middle < 0 || middle >= array.length || array[leftEnd] < array[right]){
            return;
        }

        int[] temp = new int[array.length];


        for (int i = leftStart; i <= rightEnd ; i++) {
           temp[i] = array[i];
        }



        for (int i = leftStart; i <= rightEnd; i++) {

            if (left > middle){
                array[i] = temp[right++];
            }else if (right > rightEnd){
                array[i] = temp[left++];
            }else if (temp[left] < temp[right]){
                 array[i] = temp[left++];
             } else {
                 array[i] = temp[right++];
             }

        }


    }
}
