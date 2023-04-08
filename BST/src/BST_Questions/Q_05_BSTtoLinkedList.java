package BST_Questions;

import config.BT;
import config.BTNode;

class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    LinkedListNode(T data){
        this.data = data;
    }
}
public class Q_05_BSTtoLinkedList {
    public static LinkedListNode<Integer> convertBSTtoLL(BTNode<Integer> root){
        if(root == null){
            return null;
        }
        LinkedListNode<Integer> leftLL = convertBSTtoLL(root.left);
        LinkedListNode<Integer> rootLL = new LinkedListNode<>(root.data);
        LinkedListNode<Integer> head;
        if(leftLL != null){
            head = leftLL;
            LinkedListNode<Integer> temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = rootLL;
        } else {
            head = rootLL;
        }
        rootLL.next = convertBSTtoLL(root.right);
        return head;
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.inOrderPreOrder(new int[]{2,3,4,5,6,10,12,15,17},new int[]{10,5,3,2,4,6,15,12,17});
        System.out.println("isBst: "+Q_04_ChekTreeIsBST.isBst(tree.root));
//        System.out.println("Print");
//        BT.printLevelWise(tree.root);
//        System.out.println("pring");
        LinkedListNode<Integer> head = convertBSTtoLL(tree.root);
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
