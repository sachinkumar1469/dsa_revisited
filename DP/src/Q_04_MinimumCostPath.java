import java.util.Arrays;

public class Q_04_MinimumCostPath {

    public static int call = 0;
    public static int minPath(int[][] cost,int row, int col){
        call++;
        if(row == cost.length -1 && col == cost[0].length -1){
            return cost[row][col];
        }
        if(row>=cost.length || col>=cost.length){
            return Integer.MAX_VALUE;
        }
        // left, diagonal and down
        int leftCost = minPath(cost,row,col+1);
        int diagonalCost = minPath(cost,row+1,col+1);
        int rightCost = minPath(cost,row+1,col);
        return Math.min(leftCost,Math.min(diagonalCost,rightCost)) + cost[row][col];
    }

    public static int memoCall = 0;
    public static int minPathMemo(int[][] cost,int[][] dp,int row,int col){
        memoCall++;
        if(row == cost.length-1 && col == cost[0].length-1){
            return cost[row][col];
        }
        if(row>=cost.length || col>=cost[0].length){
            return Integer.MAX_VALUE;
        }
        int leftValue = Integer.MAX_VALUE;
        if(col+1<dp[0].length){
            leftValue = dp[row][col+1] != -1 ? dp[row][col+1] : minPathMemo(cost,dp,row, col+1);
            dp[row][col+1] = leftValue;
        }
        int diaganoalValue = Integer.MAX_VALUE;
        if(col+1<dp[0].length && row+1< dp.length){
            diaganoalValue = dp[row+1][col+1]!=-1?dp[row+1][col+1] : minPathMemo(cost,dp,row+1,col+1);
            dp[row+1][col+1] = diaganoalValue;
        }
        int bottomValue = Integer.MAX_VALUE;
        if(row+1<dp.length){
            bottomValue = dp[row+1][col]!=-1?dp[row+1][col]: minPathMemo(cost,dp,row+1,col);
            dp[row+1][col] = bottomValue;
        }

        return Math.min(leftValue,Math.min(diaganoalValue,bottomValue)) + cost[row][col];
    }

    public static int minPathIterative(int[][] cost){
        int dp[][] = new int[cost.length][cost[0].length];
        dp[0][0] = cost[0][0];
        for(int row=0;row<cost.length;row++){
            for(int col=0;col<cost[row].length;col++){
                int topValue = Integer.MAX_VALUE;
                int rightValue = Integer.MAX_VALUE;
                int diagonalValue = Integer.MAX_VALUE;

                if(row-1>=0){
                    topValue = dp[row-1][col];
                }
                if(row-1>=0 && col - 1>=0){
                    diagonalValue = dp[row-1][col-1];
                }
                if(col-1>=0){
                    rightValue = dp[row][col-1];
                }
                if(row !=0 || col != 0){
                    dp[row][col] = Math.min(topValue,Math.min(diagonalValue,rightValue)) + cost[row][col];
                }
            }
        }
        for(int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[cost.length-1][cost[0].length-1];
    }
    public static void main(String[] args) {
        int[][] cost = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minPath(cost,0,0));
        System.out.println("Recursive call "+call);

        System.out.println();
        int[][] dp = new int[cost.length][cost[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int minCost = minPathMemo(cost,dp,0,0);
        System.out.println(minCost);
        System.out.println("Memo Call: "+memoCall);
        System.out.println();

        System.out.println("Iterative DP answer: "+minPathIterative(cost));
    }
}
