package questions;

import config.BT;
import config.BTNode;

public class Q_05_ReplaceDataWithDepth {
    public static void replaceData(BTNode btNode,int depth){
        if(btNode == null){
            return;
        }
        btNode.data = depth;
        replaceData(btNode.left,depth+1);
        replaceData(btNode.right,depth+1);
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        replaceData(tree.root,0);
        BT.print(tree.root);
    }
}
