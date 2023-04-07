package questions;

import config.BT;
import config.BTNode;

public class Q_11_DiameterOfTree {

    static class DiameterHelper{
        int height;
        int maxDiameter;
    }

    // Difference between two farthest points
    public static DiameterHelper diameter(BTNode root){
        DiameterHelper diameterHelper = new DiameterHelper();
        if(root == null){
            diameterHelper.height=0;
            diameterHelper.maxDiameter=0;
            return diameterHelper;
        }
        DiameterHelper leftHelper = diameter(root.left);
        DiameterHelper rightHelper = diameter(root.right);

        int currentHeight = 1 + Math.max(leftHelper.height,rightHelper.height);
        int currentDiameter = leftHelper.height + rightHelper.height;

        currentDiameter = Math.max(currentDiameter,Math.max(leftHelper.maxDiameter,rightHelper.maxDiameter));

        diameterHelper.height = currentHeight;
        diameterHelper.maxDiameter = currentDiameter;

        return diameterHelper;
    }

    public static void main(String[] args) {
        BT<Integer> tree = new BT<>();
        tree.root = BT.takeBTinput(tree.root);
        System.out.println("Diameter of tree is: "+diameter(tree.root).maxDiameter);
    }
}
