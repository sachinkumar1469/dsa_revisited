package questions;

import BST_Questions.Q_04_ChekTreeIsBST;
import config.BT;
import config.BTNode;

class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){this.data = data;}
}
public class Q_15_RootToNodePath {

    // Assuming all the nodes are unique
    public static LinkedListNode<Integer> trace(BTNode<Integer> root,Integer x){
        if(root == null){
            return null;
        }

        if(root.data == x){
            return new LinkedListNode<Integer>(root.data);
        }

        LinkedListNode<Integer> rootLL = null;
        LinkedListNode left = trace(root.left,x);
        if(left != null){
            rootLL = new LinkedListNode<>(root.data);
            rootLL.next = left;
        }

        LinkedListNode right = trace(root.right,x);
        if(right!=null) {
            rootLL = new LinkedListNode<>(root.data);
            rootLL.next = right;
        }
        return rootLL;
    }

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.inOrderPreOrder(new int[]{2,3,4,5,6,10,12,15,17},new int[]{10,5,3,2,4,6,15,12,17});
        System.out.println("isBst: "+ Q_04_ChekTreeIsBST.isBst(tree.root));
//        BT.printLevelWise(tree.root);
        LinkedListNode<Integer> path = trace(tree.root,17);
        while (path!=null){
            System.out.print(path.data +" ");
            path = path.next;
        }
    }
}
