package questions;

import config.MyLinkedList;
import config.Node;

/*
    You have been given a singly linked list of integers along with an integer 'N'.
    Write a function to append the last 'N' nodes towards the front of the singly
    linked list and returns the new head to the list.

    Sample Input 1 :
    2
    1 2 3 4 5 -1
    3
    10 20 30 40 50 60 -1
    5

    Sample Output 1 :
    3 4 5 1 2
    20 30 40 50 60 10
*/
public class Q_02_AppendLastNToFirst {
    public static void appendN(MyLinkedList<Integer> list,int n){
        Node<Integer> temp = list.getHead();
        int size = list.getSize();
        int newStartIdx = size - n;
        int prevLastIdx = newStartIdx-1;

        Node<Integer> lastNode;
        while(temp.next != null){
            temp = temp.next;
        }
        lastNode = temp;
        temp = list.getHead();

        Node<Integer> prevLastNode;
        while(prevLastIdx>0){
            temp = temp.next;
            prevLastIdx--;
        }
        prevLastNode = temp;
        temp = list.getHead();

        lastNode.next = temp;
        list.setHead(prevLastNode.next);
        prevLastNode.next = null;

    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(new Integer[]{10, 6, 77, 90, 61, 67, 100});
        System.out.println(list.getSize());
        list.printList();
        System.out.println("after");
        appendN(list,4);
        list.printList();
    }
}
