import config.BT;
import config.BTNode;

public class Main {
    public static void main(String[] args) {

        BT<Integer> tree = new BT<>();
        int[] inOrder = new int[]{4,2,5,1,6,3,7};

        // Inorder and preOrder
//        int[] preOrder = new int[]{1,2,4,5,3};
//        tree.root = BT.inOrderPreOrder(inOrder,preOrder);

        // Inorder and postOrder
        int[] postOrder = new int[]{4,5,2,6,7,3,1};
        tree.root = BT.inOrderPostOrder(inOrder,postOrder);

        BT.printLevelWise(tree.root);
    }
}