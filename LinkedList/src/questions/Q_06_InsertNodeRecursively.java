package questions;

import config.MyLinkedList;
import config.Node;

public class Q_06_InsertNodeRecursively {
    public static Node<Integer> insert(Node<Integer> head,Integer data,int pos){
        if(head == null && pos!=0){
            return null;
        }
        if(pos == 0){
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            return newNode;
        }
        head.next = insert(head.next,data,pos-1);
        return head;
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(new Integer[]{1,2,3,5,6,7,8});
        Node<Integer> head = list.getHead();
        head = insert(head,4,7);
        list.setHead(head);
        list.printList();
        System.out.println("Size of list is: "+list.getSize());
    }
}
