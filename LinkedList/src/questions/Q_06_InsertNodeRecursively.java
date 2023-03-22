package questions;

import config.MyLinkedList;
import config.Node;

public class Q_06_InsertNodeRecursively {
    public Node<Integer> insert(Node<Integer> head,int pos){
        return head;
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(new Integer[]{1,2,3,5,6,7,8});
        Node<Integer> head = list.getHead();
        
    }
}
