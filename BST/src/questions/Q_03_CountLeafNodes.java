package questions;

import config.BT;
import config.BTNode;

public class Q_03_CountLeafNodes {

    public static int count(BTNode btNode){
        if(btNode == null){
            return 0;
        }
        if(btNode.left == null && btNode.right == null){
            return 1;
        }
        return count(btNode.left)+count(btNode.right);
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        System.out.println("Leaf node count is: "+count(tree.root));
    }
}
