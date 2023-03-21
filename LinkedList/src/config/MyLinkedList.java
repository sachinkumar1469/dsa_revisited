package config;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public Node<T> add(T data){
        Node<T> newNode = new Node<T>(data);
        if(this.head == null){
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        this.size++;
        return this.head;
    }

    public Node<T> add(T[] arr){
        Node<T> temp;
        if(this.head == null){
            temp = null;
        } else {
            Node<T> temp2 = this.head;
            while (temp2.next!=null){
                temp2 = temp2.next;
            }
            temp = temp2;
        }

        for(T data:arr){
            Node<T> newNode = new Node<T>(data);
            if(temp == null){
                this.head = newNode;
                temp = newNode;
            }
            temp.next = newNode;
            temp = temp.next;
            this.size++;
        }
        return this.head;
    }

    public T get(int i) throws Exception{
        if(i<0 && this.head == null){
            throw new Exception("Index out of bound");
        }

        Node<T> temp = this.head;
        while(i!=0 && temp!=null){
            temp = temp.next;
            i--;
        }

        if(temp!=null){
            return temp.data;
        }
        throw new Exception("Index out of bound");
    }

    public void delete(T data){
        if(this.head == null){
            return;
        }
        Node<T> temp = this.head;

        if(temp.data.equals(data)){
            if(temp.next == null){
                this.head = null;
            } else {
                this.head = temp.next;
            }
            this.size--;
            return;
        }
        while(temp.next!=null){
            if(temp.next.data.equals(data)){
                temp.next = temp.next.next;
                this.size--;
                break;
            }
            temp = temp.next;
        }

    }

    public void insert(T data, int index) throws Exception{
        Node<T> newNode = new Node<>(data);
        if(index == 0){
            if(this.head != null){
                newNode.next = this.head;
            }
            this.head = newNode;
            this.size++;
            return;
        }
        Node<T> temp = this.head;
        while (index>1 && temp!=null){
            temp = temp.next;
            index--;
        }
        if(temp!=null){
            newNode.next = temp.next;
            temp.next = newNode;
            this.size++;
        } else{
            throw new Exception("Index out of bound");
        }

    }

    public void printList(){
        Node<T> temp = this.head;
        var count = 0;
        while (temp != null){
            System.out.println("Index "+count+" is: "+temp.data);
            temp = temp.next;
            count++;
        }
    }

    public int getSize(){
        return this.size;
    }

}
