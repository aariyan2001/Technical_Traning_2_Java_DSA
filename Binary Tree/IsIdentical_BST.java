

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsIdentical_BST {
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
 
    // inorder traversal
    static void inOrder(Node root, ArrayList<Integer> sol)
    {
        if (root == null)
            return;
        inOrder(root.left, sol);
        sol.add(root.data);
        inOrder(root.right, sol);
    }
 
    // preorder traversal
    static void preOrder(Node root, ArrayList<Integer> sol)
    {
        if (root == null)
            return;
        sol.add(root.data);
        preOrder(root.left, sol);
        preOrder(root.right, sol);
    }
 
    // postorder traversal
    static void postOrder(Node root, ArrayList<Integer> sol)
    {
        if (root == null)
            return;
        postOrder(root.left, sol);
        postOrder(root.right, sol);
        sol.add(root.data);
    }
 
    //To check Identical or not
    static boolean isIdentical(Node root1, Node root2)
    {
        
        ArrayList<Integer> res1 = new ArrayList<Integer>();
        ArrayList<Integer> res2 = new ArrayList<Integer>();
 
        inOrder(root1, res1);
        inOrder(root2, res2);
        if (!res1.equals(res2))
            return false;

        res1.clear();
        res2.clear();
 
        preOrder(root1, res1);
        preOrder(root2, res2);
        if (!res1.equals(res2))
            return false;
 
        res1.clear();
        res2.clear();
 
        postOrder(root1, res1);
        postOrder(root2, res2);
        if (!res1.equals(res2))
            return false;
 
        return true;
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
        Node root1 = new Node(5);
        Node root2 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(8);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
 
        root2.left = new Node(3);
        root2.right = new Node(8);
        root2.left.left = new Node(2);
        root2.left.right = new Node(4);
 
        if (isIdentical(root1, root2)) {
            System.out.println("Both BSTs are identical.");
        }
        else {
            System.out.println("BSTs are not identical.");
        }
        printBST(root1);
    }
}

