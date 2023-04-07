package questions;

import config.BT;
import config.BTNode;

public class Q_04_PrintNodeAtDepthK {
    public static void printAtDepthK(BTNode btNode,int depth){
        if(btNode == null){
            return;
        }
        if(depth == 0){
            System.out.print(btNode.data+" ");
        }
        printAtDepthK(btNode.left,depth-1);
        printAtDepthK(btNode.right,depth-1);
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        printAtDepthK(tree.root,2);
    }
}
