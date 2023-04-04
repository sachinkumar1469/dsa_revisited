package questions;

public class Q_06_TrappedRainWaterSum {
    public static int trappedWater(int arr[]){
        // Lenght < 2 no water wiil be sotred
        if(arr.length<=2){
            return 0;
        }
        int[] leftMaxArr = new int[arr.length];
        leftMaxArr[0] = arr[0];
        for(var i=1;i<arr.length;i++){
            leftMaxArr[i] = Math.max(leftMaxArr[i-1],arr[i]);
        }

        int[] rightMaxArr = new int[arr.length];
        rightMaxArr[arr.length-1]=arr[arr.length-1];
        for(var i=arr.length-2;i>=0;i--){
            rightMaxArr[i] = Math.max(rightMaxArr[i+1],arr[i]);
        }
        var sum = 0;
        for(var i=1;i<arr.length-1;i++){
            if(arr[i] < leftMaxArr[i] && arr[i]<rightMaxArr[i]){
                var waterLevel = Math.min(leftMaxArr[i],rightMaxArr[i]);
                sum += waterLevel - arr[i];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5};
        int sum = trappedWater(arr);
        System.out.println(sum);
    }
}
