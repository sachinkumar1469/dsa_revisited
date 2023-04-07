package BST_Questions;

import config.BT;
import config.BTNode;

public class Q_03_PrintNodeBetweenK1K2 {
    public static void print(BTNode root, int k1, int k2){
        if(root == null){
            return;
        }
        int max = Math.max(k1,k2);
        int min = Math.min(k1,k2);
        int rootData = (int) root.data;
//        System.out.println(max+" "+min);
        if(rootData<max && rootData>min){
            System.out.print(rootData+" ");
            print(root.left,k1,k2);
            print(root.right,k1,k2);
        } else if(rootData<max){
            print(root.right,k1,k2);
        } else if(rootData>=max){
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
