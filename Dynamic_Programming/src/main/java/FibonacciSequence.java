public class FibonacciSequence {
    private long[] dp;
    private int sequenceIndex;

    public FibonacciSequence(int sequenceIndex){
        this.dp = new long[sequenceIndex + 1];
        this.sequenceIndex = sequenceIndex;
    }

    public long topDownApproach(){
       return calculateFibonacciTopDown(sequenceIndex);
    }

    private long calculateFibonacciTopDown(int sequenceIndex){
        if (sequenceIndex <= 2){
            return 1;
        }

        if (dp[sequenceIndex] != 0){
            return dp[sequenceIndex];
        }

        return dp[sequenceIndex] = calculateFibonacciTopDown(sequenceIndex - 1) +
                                     calculateFibonacciTopDown(sequenceIndex - 2);
    }

    public long BottomUpApproach(){
        if (sequenceIndex == 2 || sequenceIndex == 1){
            return 1;
        }
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
       return dp[dp.length - 1];
    }
}
