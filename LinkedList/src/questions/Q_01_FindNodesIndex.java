package questions;

import config.MyLinkedList;
import config.Node;

public class Q_01_FindNodesIndex {

    // Write a function to find the index of given node data
    // Don't change the head;
    public static int findIndex(Node<Integer> head, Integer data){
        Node<Integer> temp = head;
        var count = 0;
        while(temp!=null){
            if(((Node<Integer>) temp).data.equals(data)){
                return count;
            }
            count++;
            temp = ((Node<Integer>) temp).next;
        }
        return -1;
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(list.getSize());
        list.printList();
        System.out.println(findIndex(list.getHead(),11));
    }
}
