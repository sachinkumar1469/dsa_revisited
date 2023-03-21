package questions;

import config.MyLinkedList;
import config.Node;

/*
    You have been given a head to a singly linked list of integers.
    Write a function check to whether the list given is a 'Palindrome' or not.

    Sample Input 1 :
    1
    9 2 3 3 2 9 -1
    Sample Output 1 :
    true

    Sample Input 2 :
    2
    0 2 3 2 5 -1
    -1
    Sample Output 2 :
    false
    true
*/
public class Q_05_Palindrome {
    // 0 2 3 2 0
    public static void reverse(Node<Integer> head,MyLinkedList<Integer> reverseList){
        if(head == null){
            return;
        }
        reverse(head.next,reverseList);
        reverseList.add(head.data);
    }

    public static boolean isPalindrome(MyLinkedList<Integer> list){
        Node<Integer> head = list.getHead();
        MyLinkedList<Integer> reverseList = new MyLinkedList<>();
        reverse(head,reverseList);
        Node<Integer> rHead = reverseList.getHead();
        while(head != null){
            if(!head.data.equals(rHead.data)){
                return false;
            }
            head = head.next;
            rHead = rHead.next;
        }

        return true;
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0);
        System.out.println(isPalindrome(list));
    }
}
