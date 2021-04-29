public class Main {

    public static void main(String[] args) {

//        FibonacciSequence fibonacciSequence = new FibonacciSequence(50);
//        System.out.println(fibonacciSequence.BottomUpApproach());

        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(new int[]{4, 2, -1, 3, 5, 5});
        lis.findLIS();
    }

}
