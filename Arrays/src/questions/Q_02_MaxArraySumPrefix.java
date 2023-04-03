package questions;

import java.util.Arrays;

// Better approach of previous question
// Time complexity O(n^2)
public class Q_02_MaxArraySumPrefix {
    public static int prefixMaxSum(int[] arr){
        int[] prefix = new int[arr.length];
        var sum = 0;
        for(var i=0;i<arr.length;i++){
            sum+=arr[i];
            prefix[i] = sum;
        }
        var maxSum = Integer.MIN_VALUE;
        for(var i=0;i<arr.length;i++){
            for(var j=i;j<arr.length;j++){
                var tempSum = 0;
                if(i==0){
                    tempSum = prefix[j];
                }else{
                    tempSum = prefix[j] - prefix[i];
                }
                if(tempSum>maxSum){
                    maxSum = tempSum;
                }
            }
        }
        System.out.println(Arrays.toString(prefix));
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,6,-2,3};
        int sum = prefixMaxSum(arr);
        System.out.println(sum);
    }
}
