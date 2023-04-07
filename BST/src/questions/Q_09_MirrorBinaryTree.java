package questions;

import config.BT;
import config.BTNode;

public class Q_09_MirrorBinaryTree {
    public static BTNode mirrorBT(BTNode root){
        if(root == null){
            return null;
        }
        BTNode temp = root.left;
        root.left = mirrorBT(root.right);
        root.right = mirrorBT(temp);
        return root;
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        BT.print(tree.root);
        System.out.println("Mirror it");
        tree.root = mirrorBT(tree.root);
        BT.print(tree.root);
    }
}
