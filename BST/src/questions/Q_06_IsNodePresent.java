package questions;

import config.BT;
import config.BTNode;

public class Q_06_IsNodePresent {

    public static boolean isNodePresent(BTNode btNode,int x){
        if(btNode == null){
            return false;
        }
        if((int)btNode.data == x){
            return true;
        }

        return isNodePresent(btNode.left,x) || isNodePresent(btNode.right,x);
    }

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        boolean is = isNodePresent(tree.root,2);
        System.out.println(is);
    }
}
