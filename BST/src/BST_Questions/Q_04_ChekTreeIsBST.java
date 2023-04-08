package BST_Questions;

import config.BT;
import config.BTNode;

public class Q_04_ChekTreeIsBST {
    public static boolean isBst(BTNode root){
        if(root == null){
            return true;
        }
        int rootData = (int) root.data;
        if(root.left != null && root.right!=null){
            int leftData = (int) root.left.data;
            int rightData = (int) root.right.data;
            if(rootData>=leftData && rootData<rightData){
                return isBst(root.left) && isBst(root.right);
            } else {
                return false;
            }
        } else if(root.left != null){
            int leftData = (int) root.left.data;
            if(leftData>rootData){
                return false;
            } else {
                return isBst(root.left);
            }
        } else if(root.right != null){
            int rightData = (int) root.right.data;
            if(rightData<rootData){
                return false;
            }else {
                return isBst(root.right);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
//        tree.root = BT.inOrderPreOrder(new int[]{2,3,4,5,6,10,12,15,17},new int[]{10,5,3,2,4,6,15,12,17});
        tree.root = BT.inOrderPreOrder(new int[]{1,2,3},new int[]{2,1,3});
        System.out.println("isBst: "+isBst(tree.root));

    }
}
