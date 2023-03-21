package questions;

import config.MyLinkedList;
import config.Node;

/*
    You have been given a singly linked list of integers where the elements are sorted
    in ascending order. Write a function that removes the consecutive duplicate values
    such that the given list only contains unique elements and returns the head to the updated list.

    Sample Input 1 :
    1
    1 2 3 3 3 3 4 4 4 5 5 7 -1

    Sample Output 1 :
    1 2 3 4 5 7
*/
public class Q_03_EliminateDuplicates {
    // 1,1,1,5,2,2,2,3,3,4,4,5
    public static void eliminate(MyLinkedList<Integer> list){
        Node<Integer> head = list.getHead();
        while(head!=null){
            if(head.next == null){
                break;
            }
            Node<Integer> temp = head;
            while(temp.data == temp.next.data){
                temp = temp.next;

            }
            head.next = temp.next;
            head = head.next;
        }
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(new Integer[]{1,1,2,2,2,3,3,3,4,4,4,5,5,5,6});
        System.out.println(list.getSize());
        list.printList();
        eliminate(list);
        list.printList();
    }
}
