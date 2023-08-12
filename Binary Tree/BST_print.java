import java.util.LinkedList;
import java.util.Queue;

public class BST_print {
    static class Node {
        int data;
        Node left, right;
     
        Node(int d)
        {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }
    static void printBST(Node root) {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Node root1 = new Node(8);
        root1.left = new Node(3);
        root1.right = new Node(8);
        root1.left.left = new Node(7);
        root1.left.right = new Node(4);
 
        System.out.println("BST is: ");
        printBST(root1);
    }
}
