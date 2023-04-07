package questions;

import config.BT;
import config.BTNode;

public class Q_10_IsTreeBalanced {
    public static boolean isBalanced(BTNode root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right==null){
            return true;
        } else if(root.left != null && root.right!=null) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    static class BalancedTreeReturn{
        int height;
        boolean isBalanced;
    }

    public static BalancedTreeReturn isBalanced2(BTNode root){
        BalancedTreeReturn balancedTreeReturn = new BalancedTreeReturn();
        if(root==null){
            balancedTreeReturn.height = 0;
            balancedTreeReturn.isBalanced = true;
            return balancedTreeReturn;
        }
        BalancedTreeReturn leftBalanced = isBalanced2(root.left);
        BalancedTreeReturn rightBalanced = isBalanced2(root.right);

        balancedTreeReturn.height = 1 + Math.max(leftBalanced.height,rightBalanced.height);

        if(Math.abs(leftBalanced.height-rightBalanced.height)<=1 && leftBalanced.isBalanced && rightBalanced.isBalanced){
            balancedTreeReturn.isBalanced = true;
        } else {
            balancedTreeReturn.isBalanced = false;
        }
        return balancedTreeReturn;
    }
    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        System.out.println(isBalanced2(tree.root).isBalanced);
    }
}
