public class Q_01_StairCase {
    public static int co = 0;
    // Recursion and Backtracking
    public static void count(int stairs,int curr){
        co++;
        if(curr >= stairs){
//            System.out.println("Reached");

            return;
        }

        int left = stairs - curr;
        if(left>=3){
            // Three options here
            count(stairs,curr+3);
            count(stairs,curr+2);
            count(stairs,curr+1);
        }else if(left==2){
            // Two options here
            count(stairs,curr+2);
            count(stairs,curr+1);
        } else {
            // Only one option here
            count(stairs,curr+1);
        }
    }

    // DP
    public static void dpCount(int stairs){
        if(stairs==1){
            System.out.println(1);
        } else if (stairs==2) {
            System.out.println(2);
        } else if (stairs==3) {
            System.out.println(3);
        }
        int[] dp = new int[stairs];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i=3;i<stairs;i++){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        System.out.println("Total ways is: "+dp[stairs-1]);
    }
    public static void main(String[] args) {
        count(10,0);
        System.out.println("Total "+co);
        dpCount(10);
    }

}
