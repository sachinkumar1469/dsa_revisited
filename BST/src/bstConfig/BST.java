package bstConfig;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<T> {
    public BSTNode<T> root;
    private int size;

    private boolean isPresentHelper(BSTNode<T> rootNode, T data){
        if(rootNode == null){
            return false;
        }
        if(rootNode.data == data){
            return true;
        }
        return (int)rootNode.data > (int)data ? isPresentHelper(rootNode.left,data) : isPresentHelper(rootNode.right,data);
    }
    public boolean isPresent(T data){
        return isPresentHelper(this.root,data);
    }

    private BSTNode<T> insertHelper(BSTNode<T> node, T data){
        if(node == null){
            BSTNode bstNode = new BSTNode<T>(data);
            node = bstNode;
            return node;
        }
        int rootData = (int) node.data;
        if(rootData >= (int)data){
            node.left = insertHelper(node.left,data);
        }
        if(rootData < (int) data){
            node.right = insertHelper(node.right,data);
        }
        return node;
    }
    public void insert(T data){
        this.root = insertHelper(this.root,data);
        this.size++;
    }

    class DeleteReturn{
        BSTNode<T> root;
        boolean isDeleted;

        DeleteReturn(){root=null;isDeleted=false;}
        DeleteReturn(BSTNode bstNode,boolean isDeleted){this.root = bstNode;this.isDeleted = isDeleted;}
    }
    public DeleteReturn deleteHelper(BSTNode node, T x){
        if(node == null){
            return new DeleteReturn();
        }

        int rootData = (int)node.data;
        if(rootData == (int)x){

            if(node.left != null && node.right !=null){
                DeleteReturn deleteReturn = new DeleteReturn();
                BSTNode temp = node.right;
                if(temp.left == null){
                    temp.left = node.left;
                    deleteReturn.root = temp;
                    deleteReturn.isDeleted = true;
                    return deleteReturn;
                }else {
                    while (temp.left.left != null){
                        temp = temp.left;
                    }
                    BSTNode rightMin = temp.left;
                    temp.left = null;
                    rightMin.left = node.left;
                    rightMin.right = node.right;
                    deleteReturn.root = rightMin;
                    deleteReturn.isDeleted = true;
                    return deleteReturn;
                }
            } else if(node.left != null){
                return new DeleteReturn(node.left,true);
            } else {
                return new DeleteReturn(node.right,true);
            }
        }

        if(rootData > (int)x){
            DeleteReturn left = deleteHelper(node.left,x);
            node.left = left.root;
            return new DeleteReturn(node,left.isDeleted);
        }else{
            DeleteReturn right = deleteHelper(node.right,x);
            node.right = right.root;
            return new DeleteReturn(node,right.isDeleted);
        }
    }
    public boolean delete(T data){
        DeleteReturn deleteReturn = deleteHelper(this.root,data);
        this.root = deleteReturn.root;
        return deleteReturn.isDeleted;
    }

    public int size(){
        return this.size;
    }

    public void print(){
        Queue<BSTNode<T>> list = new LinkedList<>();
        list.add(this.root);

        while (!list.isEmpty()){
            BSTNode head = list.poll();
            if(head != null){
                System.out.print(head.data+" ");
                if(head.left != null){
                    System.out.print("L"+head.left.data);
                    list.add(head.left);
                }
                if(head.right != null){
                    System.out.print(" R"+head.right.data);
                    list.add(head.right);
                }
            }
            System.out.println();
        }
    }
}
