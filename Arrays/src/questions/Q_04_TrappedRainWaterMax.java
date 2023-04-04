package questions;

// Rain water problem
// Find the max water hold by the bars
public class Q_04_TrappedRainWaterMax {
    public static int trappedWater(int arr[]){
        if(arr.length <=2){
            return 0;
        }
        int n = arr.length;
        int maxSum = 0;
        for(var i=2;i<n;i++){
            var j = i-1;
            var currentBarHeight = arr[i];
            while(j>=0){
                if(j==0){
                    break;
                }
                if(arr[j]<currentBarHeight){
                    j--;
                }else{
                    break;
                }
            }
            var previousBarHeight = arr[j];
            var waterLevel = Math.min(currentBarHeight,previousBarHeight);
            var sum = 0;
            for(var k = j+1;k<=i-1;k++){
                sum += waterLevel - arr[k];
            }
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,6};
        int sum = trappedWater(arr);
        System.out.println(sum);
    }
}
