package config;

import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BT <T>{
    public BTNode<T> root;

    public BT(){}

    public static void print(BTNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.data+":");
        if(rootNode.left!=null){
            System.out.print(" L"+rootNode.left.data);
        }
        if(rootNode.right != null){
            System.out.print(", R"+rootNode.right.data);
        }
        System.out.println();
        print(rootNode.left);
        print(rootNode.right);
    }

    public static void printLevelWise(BTNode rootNode){
        Queue<BTNode> queue = new LinkedList<>();
        if(rootNode == null){
            return;
        }
        queue.add(rootNode);
        while (!queue.isEmpty()){
            BTNode nextEl = queue.poll();
            System.out.print(nextEl.data+" ");
            if(nextEl.left != null){
                queue.add(nextEl.left);
                System.out.print("L"+nextEl.left.data);
            }
            if(nextEl.right != null){
                queue.add(nextEl.right);
                System.out.print(" R"+nextEl.right.data);
            }
            System.out.println();
        }
    }

    public static BTNode<Integer> takeBTinput(BTNode<Integer> rootNode){
        Scanner sc = new Scanner(System.in);
        if(rootNode == null){
            System.out.print("Enter value of root node: ");
            int data = sc.nextInt();
            if(data == -1){
                return rootNode;
            }
            rootNode = new BTNode<Integer>(data);
        }
        System.out.println();

        System.out.print("Left of "+rootNode.data+" is: ");
        int leftData = sc.nextInt();
        if(leftData != -1){
            rootNode.left = new BTNode<Integer>(leftData);
        }
        System.out.println();

        System.out.print("Right of "+rootNode.data+" is: ");
        int rightData = sc.nextInt();
        if(rightData != -1){
            rootNode.right = new BTNode<Integer>(rightData);
        }
        System.out.println();

        if(rootNode.left != null){
            takeBTinput(rootNode.left);
        }
        if (rootNode.right != null){
            takeBTinput(rootNode.right);
        }
        return rootNode;
    }

    public static BTNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        BTNode<Integer> root = null;
        if(rootData==-1){
            return root;
        }
        root = new BTNode<>(rootData);
        System.out.println();
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BTNode<Integer> firstEl = queue.poll();
            System.out.print("Enter the left of "+firstEl.data+" :");
            int leftData = sc.nextInt();
            if(leftData != -1){
                firstEl.left = new BTNode<>(leftData);
                queue.add(firstEl.left);
            }
            System.out.println();

            System.out.print("Enter the right of "+firstEl.data+" :");
            int rightData = sc.nextInt();
            if(rightData != -1){
                firstEl.right = new BTNode<>(rightData);
                queue.add(firstEl.right);
            }
            System.out.println();
        }
        return root;
    }


    // Assuming no data is repeated
    // Pre-> root, left, right
    // In-> left, root, right
    public static BTNode<Integer> inOrderPreOrderHelper(int[] in,int inStart,int inEnd,int[] pre,int preStart,int preEnd){
        if(preStart>preEnd){
            return null;
        }
        int rootData = pre[preStart];

        int rootInorderIndex = -1;
        for(var i=inStart;i<=inEnd;i++){
            if(in[i]==rootData){
                rootInorderIndex = i;
            }
        }
        BTNode<Integer> rootNode = new BTNode<>(rootData);
        
        int leftInStart = inStart;
        int leftInEnd = rootInorderIndex-1;
        int leftPreStart = preStart+1;
        int leftPreEnd = leftPreStart + (leftInEnd - leftInStart + 1) -1;

        int rightInStart = rootInorderIndex + 1;
        int rightInEnd = inEnd;
        int rightPreStart = leftPreEnd+1;
        int rightPreEnd = preEnd;

        rootNode.left = inOrderPreOrderHelper(in,leftInStart,leftInEnd,pre,leftPreStart,leftPreEnd);
        rootNode.right = inOrderPreOrderHelper(in,rightInStart,rightInEnd,pre,rightPreStart,rightPreEnd);

        return rootNode;
    }

    public static BTNode<Integer> inOrderPreOrder(int[] inOrder,int[] preOrder){
        return inOrderPreOrderHelper(inOrder,0,inOrder.length-1,preOrder,0,preOrder.length-1);
    }

    public static BTNode<Integer> inOrderPostOrderHelper(int[] in, int inStart, int inEnd,int[] post, int postStart, int postEnd){
        if(postStart>postEnd){
            return null;
        }
        int rootData = post[postEnd];
        int rootIndexInorder = -1;
        for(var i=inStart;i<=inEnd;i++){
            if(in[i]==rootData){
                rootIndexInorder = i;
                break;
            }
        }

        int leftInStart = inStart;
        int leftInEnd = rootIndexInorder - 1;
        int leftPostStart = postStart;
        int leftPostEnd = leftPostStart + (leftInEnd - leftInStart + 1) - 1;

        int rightInStart = rootIndexInorder + 1;
        int rightInEnd = inEnd;
        int rightPostStart = leftPostEnd + 1;
        int rightPostEnd = postEnd -1;

        BTNode<Integer> root = new BTNode<>(rootData);
        root.left = inOrderPostOrderHelper(in,leftInStart,leftInEnd,post,leftPostStart,leftPostEnd);
        root.right = inOrderPostOrderHelper(in,rightInStart,rightInEnd,post,rightPostStart,rightPostEnd);
        return root;
    }
    public static BTNode<Integer> inOrderPostOrder(int[] inOrder,int[] postOrder){
        return inOrderPostOrderHelper(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1);
    }
    public static int countNodes(BTNode rootNode){
        if(rootNode == null){
            return 0;
        }
        return 1 + countNodes(rootNode.left) + countNodes(rootNode.right);
    }

    public static int sumOfTree(BTNode rootNode){
        if(rootNode == null){
            return 0;
        }
        return (int)rootNode.data + (int)sumOfTree(rootNode.left) + (int)sumOfTree(rootNode.right);
    }
}
