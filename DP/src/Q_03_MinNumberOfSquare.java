import java.util.Arrays;

public class Q_03_MinNumberOfSquare {

    // Recursion and backtracking
    static int recCount = 0;
    private static int minSquare(int n) {
        recCount++;
        if(n <= 0){
            return 0;
        }
        int[] min = new int[n+1];
        for(int i=0;i<=n;i++){
            min[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=n;i++){
            if(i*i <= n){
                min[i] = minSquare(n-(i*i)) + 1;
            }else {
                break;
            }
        }
        int minAns = Integer.MAX_VALUE;
        for(int m:min){
            minAns = Integer.min(m,minAns);
        }
        if(n==17){
            System.out.println(Arrays.toString(min));
        }
        return minAns;
    }

    // DP with memoization
    static int dpCount = 0;
    private static int minSquareDp(int n,int[] dp){
        dpCount++;
        if(n<=0){
            return 0;
        }
        if(n==1){
            dp[n] = 1;
            return 1;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(i*i <= n){
                if(dp[n-(i*i)]==0){
                    minAns = Math.min(minAns,minSquareDp(n-(i*i),dp));
                }else {
                    minAns = Math.min(minAns,dp[n-(i*i)]);
                }
                dp[n] = minAns + 1;
            }else {
                break;
            }
        }

        return dp[n];
    }

    private static int iterativeDp(int n){
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            int minAns = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                minAns = Math.min(minAns,dp[i-(j*j)]);
            }
            minAns++;
            dp[i] = minAns;
        }

        System.out.println("Iterative "+Arrays.toString(dp));
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 17;
        int dp[] = new int[n+1];

        System.out.println(minSquareDp(n,dp)+" Function call count is: "+dpCount);

        System.out.println(minSquare(n)+" Recursive method function call count is: "+recCount);

        System.out.println("Iterative dp is: "+iterativeDp(n));

    }
}
