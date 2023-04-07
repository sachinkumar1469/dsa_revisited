import config.BT;
import config.BTNode;

public class Main {
    public static void main(String[] args) {

        BT<Integer> tree = new BT<>();
        int[] inOrder = new int[]{2,5,4,1,3};
        int[] preOrder = new int[]{1,2,4,5,3};
        tree.root = BT.inOrderPreOrder(inOrder,preOrder);
        BT.print(tree.root);
    }
}