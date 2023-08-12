class BinaryNode
{
    int data;
    BinaryNode left, right;
  
    BinaryNode(int item)
    {
        data = item;
        left = right = null;
    }
}
  
public class SumTree_IsBalanced {
    BinaryNode root;
    int toSumTree(BinaryNode BinaryNode)
    {
        if (BinaryNode == null)
            return 0;
        int old_val = BinaryNode.data;
  
        BinaryNode.data = toSumTree(BinaryNode.left) + toSumTree(BinaryNode.right);
        return BinaryNode.data + old_val;
    }
  
    void printInorder(BinaryNode BinaryNode)
    {
        if (BinaryNode == null)
            return;
        printInorder(BinaryNode.left);
        System.out.print(BinaryNode.data + " ");
        printInorder(BinaryNode.right);
    }

    public boolean isBalanced(BinaryNode root) {
        return dfsHeight (root) != -1;
    }
    int dfsHeight (BinaryNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
  
    public static void main(String args[])
    {
        SumTree_IsBalanced tree = new SumTree_IsBalanced();
  
        
        tree.root = new BinaryNode(10);
        tree.root.left = new BinaryNode(-2);
        tree.root.right = new BinaryNode(6);
        tree.root.left.left = new BinaryNode(8);
        tree.root.left.right = new BinaryNode(-4);
        tree.root.right.left = new BinaryNode(7);
        tree.root.right.right = new BinaryNode(5);
  
        System.out.println(tree.isBalanced(tree.root));
        
    }
}
