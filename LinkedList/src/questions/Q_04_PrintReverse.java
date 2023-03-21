package questions;

import config.MyLinkedList;
import config.Node;

public class Q_04_PrintReverse {
    public static void print(Node<Integer> head){

        if(head == null){
            return;
        }

        print(head.next);
        System.out.print(head.data+" ");
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(new Integer[]{10, 6, 77, 90, 61, 67, 100});
        System.out.println(list.getSize());
        list.printList();
        print(list.getHead());
    }
}
