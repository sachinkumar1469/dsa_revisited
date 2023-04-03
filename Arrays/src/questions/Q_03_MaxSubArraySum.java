package questions;

// Kadane's Algorithm
// Better approach of previous question
// Time complexity is O(n)
public class Q_03_MaxSubArraySum {
    public static int kadaneAlg(int[] arr){
        int currSum = 0;
        int maxSum = 0;
        for(var i=0;i<arr.length;i++){
            if(arr[i]>=0 || (currSum+arr[i])>=0){
                currSum+=arr[i];
            }else {
                currSum = 0;
            }
            if(maxSum < currSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,6,-1,3};
        int sum = kadaneAlg(arr);
        System.out.println(sum);
    }
}
