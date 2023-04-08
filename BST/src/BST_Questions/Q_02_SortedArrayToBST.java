package BST_Questions;

import config.BT;
import config.BTNode;

public class Q_02_SortedArrayToBST {
    public static BTNode<Integer> convert(int[] arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (end + start)/2;
        BTNode<Integer> root = new BTNode<>(arr[mid]);
        root.left = convert(arr,start,mid-1);
        root.right = convert(arr,mid+1,end);
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        BTNode<Integer> root = convert(arr,0,arr.length-1);
        BT.printLevelWise(root);
    }
}
