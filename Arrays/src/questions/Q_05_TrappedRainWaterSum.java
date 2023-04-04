package questions;

import java.util.Arrays;

// Not optimized
public class Q_05_TrappedRainWaterSum {
    public static int trappedWater(int arr[]){
        // Lenght < 2 no water wiil be sotred
        if(arr.length<=2){
            return 0;
        }
        // For ascending and descending also no water will be stored

        var sum = 0;

        // Iterate from i=2 to n-1
        for(var i=1;i<arr.length;i++){
            // Now find left max and right max
            // And consider water level max of them
            // Only if both side max should be greater than current height
            var currentBarHeight = arr[i];

            // Traverse to left and find max
            var j = i-1;
            var currLeftMax = j;
            while(j>=0){
                if(arr[j]>arr[currLeftMax]){
                    currLeftMax = j;
                }
                j--;
            }
            j = i+1;
            var currRightMax = j;
            while(j<arr.length){
                if(arr[j]>arr[currRightMax]){
                    currRightMax = j;
                }
                j++;
            }


            // Need to handle the right max edge case for last element
            if(i!=arr.length-1){
//                System.out.println("Left max is: "+arr[currLeftMax]+" Right max is: "+arr[currRightMax]+" For i:"+i);
                if(currentBarHeight < arr[currLeftMax] && currentBarHeight< arr[currRightMax]){
                    var waterLevel = Math.min(arr[currLeftMax],arr[currRightMax]);
                    sum += waterLevel - currentBarHeight;
                }
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,6,7};
        int sum = trappedWater(arr);
        System.out.println(sum);
    }
}
