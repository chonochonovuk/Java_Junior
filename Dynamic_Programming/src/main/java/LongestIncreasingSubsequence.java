import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    private int[] lis;
    private int[] path;
    private int[] seq;

    public LongestIncreasingSubsequence(int[] sequence){
        this.lis = new int[sequence.length];
        this.path = new int[sequence.length];
        this.seq = sequence;
    }

    public void findLIS(){

        int maxLength = 1;
        int maxIndex = -1;

        for (int i = 0; i < seq.length; i++) {
            int current = seq[i];
            int bestLength = 1;
            int bestIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (current > seq[j] && lis[j] + 1 >= bestLength){
                    bestLength = lis[j] + 1;
                    bestIndex = j;
                }
            }

            lis[i] = bestLength;
            path[i] = bestIndex;
            if (bestLength > maxLength){
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        List<Integer> elements = new ArrayList<>();
        elements.add(seq[maxIndex]);

        int prevIndex = path[maxIndex];

        while (prevIndex != -1){
            elements.add(seq[prevIndex]);
            prevIndex = path[prevIndex];
        }
        Collections.reverse(elements);
        System.out.println(Arrays.toString(elements.toArray()) .replaceAll("[\\[\\],]", ""));
    }

}
