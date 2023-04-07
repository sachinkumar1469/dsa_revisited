package questions;

import config.BT;
import config.BTNode;

public class Q_01_LargestNode {
    public static int largestNode(BTNode node){
        if(node == null){
            return -1;
        }
        int leftMax = largestNode(node.left);
        int rightMax = largestNode(node.right);

        return Math.max((int)node.data,Math.max(leftMax,rightMax));
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        System.out.println("Largest node of tree is: "+largestNode(tree.root));
    }
}
