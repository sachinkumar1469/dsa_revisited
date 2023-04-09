package questions;

import java.util.Arrays;

public class Q_07_ArraySubset {

    public static int[][] arraySubset(int[] arr,int index){
        if(arr.length == index){
            System.out.println("base case");
            return new int[1][0];
        }
        int first = arr[index];

        int[][] right = arraySubset(arr,index+1);
        int[][] ans = new int[right.length*2][];
        for(int row=0;row<right.length;row++){
            ans[row] = right[row];
        }
        for(int row=0;row<right.length;row++){
            int[] newRow = new int[right[row].length+1];
            newRow[0]=first;
            for(int col=0;col<right[row].length;col++){
                newRow[col+1] = right[row][col];
            }
            ans[row+right.length] = newRow;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {15,12,20};
        int[][] list = arraySubset(arr,0);
        for(int[] ar:list){
            System.out.println(Arrays.toString(ar));
        }
    }
}
