package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_06_SubsetSumToK {

    static class SubsetReturn{
        List<Integer> subset = new ArrayList<>();
        boolean isSubset = false;
    }

    public static List<SubsetReturn> subset(int[] arr,int k){
        if(arr.length == 0){
            List<SubsetReturn> reached = new ArrayList<>();
            reached.add(new SubsetReturn());
            return reached;
        }
        int firstIdx = arr[0];
        int newK = k - firstIdx;

        if(newK == 0){
            List<SubsetReturn> finalList = new ArrayList<>();
            SubsetReturn subsetReturn = new SubsetReturn();
            subsetReturn.subset.add(firstIdx);
            subsetReturn.isSubset = true;
            finalList.add(subsetReturn);
            return finalList;
        }

        int newArr[] = new int[arr.length-1];
        for(int i=1;i<arr.length;i++){
            newArr[i-1] = arr[i];
        }
        // Part of the subset
        List<SubsetReturn> ans = new ArrayList<>();
        if(newK > 0){
            List<SubsetReturn> part = subset(newArr,newK);
            for(SubsetReturn partItem:part){
                if(partItem.isSubset){
                    partItem.subset.add(firstIdx);
                    ans.add(partItem);
                }
            }
        }

        // Not the part of subset
        List<SubsetReturn> notPart = subset(newArr,k);
        for(SubsetReturn notPartItem:notPart){
            if(notPartItem.isSubset){
                ans.add(notPartItem);
            }
        }

        return ans;
    }

    // Return a 2d array with size
    public static int[][] subsetArr(int[] arr,int index,int k){
        if(arr.length == index){
            return new int[0][0];
        }

        int first = arr[index];
        int newK = k - first;
        if(newK == 0){
            int[][] newArr = new int[1][1];
            int[] firstRow = newArr[0];
//            firstRow[0] = 1;
            firstRow[0] = first;
            return newArr;
        }

        // Include
        int[][] part = subsetArr(arr,index+1,newK);
        for(int row=0;row<part.length;row++){
            int[] rowArr = part[row];
            int[] newRowArr = new int[rowArr.length+1];
//            newRowArr[0] = rowArr[0]+1;
            newRowArr[0] = first;
            for(int i=0;i<rowArr.length;i++){
                newRowArr[i+1] = rowArr[i];
            }
            part[row] = newRowArr;
        }


        // Don't include
        int[][] notPart = subsetArr(arr,index+1,k);
        int notPartRows = notPart.length;

        int[][] ans = new int[part.length+notPart.length][];
        int KRows = 0;
        for(int i=0;i<part.length;i++){
            ans[KRows]=part[i];
            KRows++;
        }
        for(int j=0;j<notPart.length;j++){
            ans[KRows] = notPart[j];
            KRows++;
        }

        return ans;
    }

    public static int[][] helper(int input[], int k,int si) {
        if(si==input.length)
        {
            if(k==0)
                return new int[1][0];
            else
                return new int[0][0];
        }
        int op1[][]=helper(input,k-input[si],si+1);////////////
        int op2[][]=helper(input,k,si+1);
        int output[][]=new int[op1.length+op2.length][];////////////////
        int l=0;
        for(int i=0;i<op2.length;i++){
            output[i]=new int[op2[i].length];
            for(int j=0;j<op2[i].length;j++)
                output[l][j]=op2[i][j];////////
            l++;
        }
        for(int i=0;i<op1.length;i++){
            output[i+l]=new int[op1[i].length+1];
            output[i+l][0]=input[si];
            for(int j=1;j<=op1[i].length;j++){
                output[i+l][j]=op1[i][j-1];
            }}
        return output;
    }
    public static void main(String[] args) {
//        int[] num = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int[] num = {1,3,4,2};
//        int[][] ans = helper(num,5,0);
        int[][] ans = subsetArr(num,0,5);
        for(var i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
