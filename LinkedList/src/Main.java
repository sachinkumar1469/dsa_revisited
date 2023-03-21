import config.MyLinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);

        list.insert(3,2);


        list.add(new Integer[]{5, 6, 7, 8, 9});
        list.add(10);
        list.add(new Integer[]{11,12,13,14});
        list.delete(11);
        System.out.println(list.getSize());
        list.printList();
//        System.out.println("Ith index value is: "+list.get(2));
    }
}