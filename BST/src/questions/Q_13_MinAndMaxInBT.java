package questions;

import config.BT;
import config.BTNode;

public class Q_13_MinAndMaxInBT {
    static class minMaxReturn{
        int min;
        int max;
        minMaxReturn(){}
        minMaxReturn(int min,int max){this.min = min;this.max = max;}
    }

    public static minMaxReturn minMax(BTNode root){
        if(root == null){
            return new minMaxReturn(Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        minMaxReturn left = minMax(root.left);
        minMaxReturn right = minMax(root.right);
        int rootData = (int) root.data;

        int newMin = Math.min(rootData,Math.max(left.min, right.min));
        int newMax = Math.max(rootData,Math.max(left.max, right.max));
        return new minMaxReturn(newMin,newMax);
    }

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        int[] inOrder = new int[]{4,2,5,1,6,13,7};
        int[] postOrder = new int[]{4,5,2,6,7,13,1};
        tree.root = BT.inOrderPostOrder(inOrder,postOrder);
//        BT.printLevelWise(tree.root);
        minMaxReturn ans = minMax(tree.root);
        System.out.println("Min is: "+ans.min+" Max is: "+ans.max);
    }
}
