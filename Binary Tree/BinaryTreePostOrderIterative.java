import java.util.Scanner;
import java.util.Stack;

class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class BinaryTreeOperations{
        String nodeName = "root";
        int nodeValue = 0;
        Scanner scanner = new Scanner(System.in);
        
        BinaryTreeNode insert(){
            System.out.println("Enter the "+nodeValue+" : "+nodeName+" Data or enter -1 to exit: ");
            int data = scanner.nextInt();
            if(data==-1){
                return null;
            }
            //if data is coming correct
            //prepare a node
            BinaryTreeNode  node  = new BinaryTreeNode(data);
            //Prepare Left Node (DFT)
            nodeName = "Left";
            nodeValue = node.data;
            node.left = insert();
            //BackTrack
            nodeName = "Right";
            nodeValue = node.data;
            node.right = insert();
            //Backtrack

            nodeName = "Root";
            nodeValue = node.data;
            return node;  

        }

        //PostOrder - Iterative - approach 1
        void iterativePostOrder(BinaryTreeNode root){
            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode current = root;
            BinaryTreeNode lastVisited = null;

            while (current != null || !stack.isEmpty()) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    BinaryTreeNode peekNode = stack.peek();
                    // Check if the right subtree has already been visited or not
                    if (peekNode.right != null && peekNode.right != lastVisited) {
                        current = peekNode.right;
                    } else {
                        System.out.println(peekNode.data);
                        lastVisited = stack.pop();
                    }
                }
            }
        }
    }


public class BinaryTreePostOrderIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeOperations obj = new BinaryTreeOperations();
        BinaryTreeNode root = null;
        while(true){
            System.out.println("Binary Tree Operation");
            System.out.println("1. Insert");
            System.out.println("2. Print");
            System.out.println("Enter the Choice : ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1: root = obj.insert();
                        break;
                case 2: obj.iterativePostOrder(root);
                        break;
                case 3: scanner.close();
                        return;
            }
        
        }
        //scanner.close();
    }
}

