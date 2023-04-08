package questions;

import config.BT;

//For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
public class Q_14_PathSumToLeaf {

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        int[] inOrder = new int[]{4,2,5,1,6,13,7};
        int[] postOrder = new int[]{4,5,2,6,7,13,1};
        tree.root = BT.inOrderPostOrder(inOrder,postOrder);
    }
}
