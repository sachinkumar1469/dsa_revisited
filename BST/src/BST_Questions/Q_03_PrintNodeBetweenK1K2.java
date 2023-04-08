package BST_Questions;

import config.BT;
import config.BTNode;

public class Q_03_PrintNodeBetweenK1K2 {
    public static void print(BTNode root, int k1, int k2){
        if(root == null){
            return;
        }

        int data = (int) root.data;

        if(data >=k1 && data <= k2){
            System.out.print(data+" ");
            print(root.left,k1,k2);
            print(root.right,k1,k2);
        } else if(data < k1){
            print(root.right,k1,k2);
        } else if(data > k2){
            print(root.left,k1,k2);
        }

    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.inOrderPreOrder(new int[]{2,3,4,5,6,10,12,15,17},new int[]{10,5,3,2,4,6,15,12,17});
//        BT.printLevelWise(tree.root);
        print(tree.root,3,15);
    }
}
