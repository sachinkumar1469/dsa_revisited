package questions;

import config.BT;
import config.BTNode;

public class Q_08_RemoveLeafNode {
    public static void removeLeafNode(BTNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                root.left = null;
            } else {
                removeLeafNode(root.left);
            }
        }
        if(root.right != null){
            if(root.right.left == null && root.right.right == null){
                root.right = null;
            } else {
                removeLeafNode(root.right);
            }
        }
    }

    public static BTNode removeLeaf(BTNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);

//        removeLeafNode(tree.root);
        removeLeaf(tree.root);
        BT.print(tree.root);
    }
}
