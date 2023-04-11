//Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
//        1.) Subtract 1 from it. (n = n - ­1) ,
//        2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
//        3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).

import java.util.Arrays;

public class Q_02_ReduceToOne {
    public static int brute = 0;
    public static int opt = 0;
    // Recursion and Backtracking
    public static int countMinStepsToOne(int n,int count) {
        //Your code goes here
        brute++;
        if(n<=1){
            return count;
        }
        if(n%3==0){
            // Subtract 1 Divide by 3
            int threeMin = countMinStepsToOne(n/3,count+1);
            int oneMin = countMinStepsToOne(n-1,count+1);
            return Math.min(threeMin,oneMin);
        } else if(n%2==0){
            // Subtract 1 or Divide by 2
            int twoMin = countMinStepsToOne(n/2,count+1);
            int oneMin = countMinStepsToOne(n-1,count+1);
            return Math.min(twoMin,oneMin);
        } else {
            // Subtract 1
            return countMinStepsToOne(n-1,count+1);
        }
    }

    // DP
    public static int countMinStepsToOneDp(int n, int dp[]){
        opt++;
        if(n==1){
            return dp[1];
        }
        int oneMin = 0;
        if(dp[n-1] != 0){
            oneMin = dp[n-1];
        } else {
            oneMin = countMinStepsToOneDp(n-1,dp);
            dp[n-1] = oneMin;
        }
        int threeMin = Integer.MAX_VALUE;
        if(n%3==0){
            if(dp[n/3]!=0){
                threeMin = dp[n/3];
            } else {
                threeMin = countMinStepsToOneDp(n/3,dp);
                dp[n/3] = threeMin;
            }
        }
        int twoMin = Integer.MAX_VALUE;
        if(n%2==0){
            if(dp[n/2]!=0){
                twoMin = dp[n/2];
            } else {
                twoMin = countMinStepsToOneDp(n/2,dp);
                dp[n/2] = twoMin;
            }
        }
        return Math.min(oneMin,Math.min(twoMin,threeMin)) + 1;
    }

    public static int iterativeDp(int n){
        int dp[] = new int[n+1];
        for(int i=2;i<dp.length;i++){
            int option1 = dp[i-1];
            int option2 = Integer.MAX_VALUE;
            int option3 = Integer.MAX_VALUE;
            if(i%2==0){
                option2 = dp[i/2];
            }
            if(i%3==0){
                option3 = dp[i/3];
            }
            dp[i] = Math.min(option1,Math.min(option2,option3)) + 1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;

        int dp[] = new int[n+1];
        dp[2] = 1;
        dp[3] = 1;
        int totalMinDp = countMinStepsToOneDp(n,dp);
        System.out.println("DP "+totalMinDp);
        System.out.println(Arrays.toString(dp));

        // Iterative dp
        System.out.println(iterativeDp(n));
    }
}
