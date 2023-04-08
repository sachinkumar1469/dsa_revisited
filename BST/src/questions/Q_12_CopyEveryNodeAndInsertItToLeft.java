package questions;

import config.BT;
import config.BTNode;

public class Q_12_CopyEveryNodeAndInsertItToLeft {
    public static void copyEveryNode(BTNode root){
        if(root == null){
            return;
        }
        int rootData = (int) root.data;
        BTNode<Integer> newNode = new BTNode<>(rootData);
        newNode.left = root.left;
        root.left = newNode;
        copyEveryNode(newNode.left);
        copyEveryNode(root.right);
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        int[] inOrder = new int[]{4,2,5,1,6,3,7};
        int[] postOrder = new int[]{4,5,2,6,7,3,1};
        tree.root = BT.inOrderPostOrder(inOrder,postOrder);
        BT.printLevelWise(tree.root);
        System.out.println("After");
        copyEveryNode(tree.root);
        BT.printLevelWise(tree.root);
    }
}
