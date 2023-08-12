public class MirrorBinaryTree {
    
    public static class Node
    {
        int data;
        Node left = null, right = null;
    
        Node(int data) {
            this.data = data;
        }
    }
    
    
    public static void printPreorder(Node node)
    {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }   
    
    public static void swap(Node node)
    {
        if (node == null) {
            return;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }   
    
    public static void mirror(Node node)
    {        
        if (node == null) {
            return;
        }

        mirror(node.left);
        mirror(node.right);
        swap(node);
    }   
    public static void main(String[] args)
    {
        
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        mirror(node);
        printPreorder(node);
    }   
}
