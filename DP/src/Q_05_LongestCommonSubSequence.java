import java.util.Arrays;

public class Q_05_LongestCommonSubSequence {
    private static int lcs(String str1, String str2) {
        if(str1.length() == 0 || str2.length()==0){
            return 0;
        }
        int maxLenght = 0;
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    maxLenght = Math.max(maxLenght,1+lcs(str1.substring(i+1),str2.substring(j+1)));
                }
            }
        }
        return maxLenght;
    }

    // Recursive Approach
    static int recCall = 0;
    private static int lcs2(String str1,String str2, int i, int j){
        recCall++;
        if(i>=str1.length() || j>=str2.length()){
            return 0;
        }
        // First characters are equal
        if(str1.charAt(i) == str2.charAt(j)){
            return 1 + lcs2(str1,str2,i+1,j+1);
        }
        // First characters are not equal
        int firstStrExc = lcs2(str1,str2,i+1,j);
        int secondStrExc = lcs2(str1,str2,i,j+1);
        return Math.max(firstStrExc,secondStrExc);
    }

    // DP Approach with memoization
    static int memoDpCall = 0;
    private static int lscDpMemo(String str1,String str2, int i, int j,int[][] dp){
        memoDpCall++;
        if(i>=str1.length() || j>=str2.length()){
            return 0;
        }
        // If first two char are equal
        if(str1.charAt(i) == str2.charAt(j)){
            int firstEqual;
            if(dp[i+1][j+1]!=-1){
                firstEqual = dp[i+1][j+1];
            }else {
                firstEqual = lscDpMemo(str1,str2,i+1,j+1,dp);
                dp[i+1][j+1] = firstEqual;
            }
            dp[i][j] = firstEqual+1;
        } else {
            int str1Ignore;
            if(dp[i+1][j] != -1){
                str1Ignore = dp[i+1][j];
            }else {
                str1Ignore = lscDpMemo(str1,str2,i+1,j,dp);
                dp[i+1][j] = str1Ignore;
            }
            int str2Ignore;
            if(dp[i][j+1]!=-1){
                str2Ignore = dp[i][j+1];
            }else {
                str2Ignore = lscDpMemo(str1,str2,i,j+1,dp);
                dp[i][j+1] = str2Ignore;
            }
            if(i==0 && j==0){
                for(int[] a:dp){
                    System.out.println(Arrays.toString(a));
                }
            }
            dp[i][j] = Math.max(str1Ignore,str2Ignore);
        }
        return dp[i][j];
    }

    private static int lcsDpIterative(String str1,String str2){
        if(str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int i=str1.length()-1;
        while (i>=0){
            int j=str2.length()-1;
            while (j>=0){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = dp[i+1][j+1];
                }
                j--;
            }
            i--;
        }
        for(int[] a:dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bec";


        System.out.println(lcs2(str1,str2,0,0));
        System.out.println("No of calls in recursive: "+recCall);
        System.out.println();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(lscDpMemo(str1,str2,0,0,dp));
        System.out.println("Memo DP calls: "+memoDpCall);

        System.out.println();
        System.out.println("Iterative dp answer: "+lcsDpIterative(str1,str2));
    }

}
