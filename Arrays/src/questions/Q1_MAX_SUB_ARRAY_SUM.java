package questions;

public class Q1_MAX_SUB_ARRAY_SUM {
    public static int maxSum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int start = i;
                int end = j;
                int tempSum = 0;
                for(int k = start;k<=end;k++){
                    tempSum += arr[k];
                }
                if(tempSum>maxSum){
                    maxSum = tempSum;
                }
//                System.out.println();
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,5,1,-4,-3,7};
        int sum = maxSum(arr);
        System.out.println("Max sub array sum is: "+sum);
    }
}
