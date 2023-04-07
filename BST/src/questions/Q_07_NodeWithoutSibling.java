package questions;

import config.BT;
import config.BTNode;

public class Q_07_NodeWithoutSibling {

    public static void nodeWithoutSibling(BTNode btNode,boolean isRoot){
        if(btNode == null){
            return;
        }
        if(isRoot){
            System.out.print(btNode.data+" ");
        }
        if(btNode.left != null && btNode.right == null){
            System.out.print(btNode.left.data+" ");
        }
        if(btNode.right != null && btNode.left == null){
            System.out.print(btNode.right.data+" ");
        }
        nodeWithoutSibling(btNode.left,false);
        nodeWithoutSibling(btNode.right,false);

    }

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        nodeWithoutSibling(tree.root,true);
    }
}
