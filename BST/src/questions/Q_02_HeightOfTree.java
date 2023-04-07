package questions;

import config.BT;
import config.BTNode;

public class Q_02_HeightOfTree {

    public static int heightOfTree(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left),heightOfTree(root.right));
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        System.out.println(heightOfTree(tree.root));
    }
}
