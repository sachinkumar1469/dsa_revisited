package BST_Questions;

import config.BT;
import config.BTNode;

public class Q_01_SearchInBinaryTree {

    public static boolean isPresent(BTNode root,int x){
        if(root == null){
            return false;
        }
        if((int) root.data == x){
            return true;
        } else if((int)root.data>x){
            return isPresent(root.left,x);
        } else {
            return isPresent(root.right,x);
        }
    }

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.inOrderPreOrder(new int[]{2,3,4,5,6,10,12,15,17},new int[]{10,5,3,2,4,6,15,12,17});
        BT.printLevelWise(tree.root);
        System.out.println(isPresent(tree.root,1222));
    }
}
