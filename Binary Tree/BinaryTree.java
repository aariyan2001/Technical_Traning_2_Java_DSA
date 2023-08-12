import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

class BinaryTreeNode<T>{
    //Left Child Reference
    BinaryTreeNode<T> left;
    //Data
    T data;
    //Right Child Refrence
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTreeOperations{
    String nodeName = "root";
    int nodeValue = 0;
    Scanner scanner = new Scanner(System.in);

    BinaryTreeNode<Integer> insert(){
        System.out.println("Enter the "+nodeValue+" : "+nodeName+" Data or enter -1 to exit: ");
        int data = scanner.nextInt();
        if(data==-1){
            return null;
        }
        //if data is coming correct
        //prepare a node
        BinaryTreeNode<Integer>  node  = new BinaryTreeNode<>(data);
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

    void print(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String result = "";
        result = result + root.data+" -> ";
        //current node left exists
        if(root.left!=null){
            result = result + " Left " +root.left.data;
        }
        if(root.right!=null){
            result = result + " Right " +root.right.data;
        }
        System.out.println(result);
        print(root.left);
        //System.out.println();
        print(root.right);
    }

    //DFT Traversal
    //preorder (P-L-R) - Recursion
    void preOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    //preOrder - Iterative - approach 1
    void iterativePreOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        //prepare a stack
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            BinaryTreeNode<Integer> currentNode = stack.pop();
            System.out.print(currentNode.data+"  ");
            //push rigth and then left
            if(currentNode.right!=null){
                stack.push(currentNode.right);
            }
            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
        }
        System.out.println();
    }

    //preOrder - Iterative approach 2
    void iterativePreOrder2(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        //prepare a stack
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> currentNode = root;
        while(currentNode!=null || !stack.isEmpty()){
            while(currentNode!=null){
                System.out.print(currentNode.data+" ");
                if(currentNode.right!=null){
                    stack.push(currentNode.right);
                }
                currentNode = currentNode.left;
            }
            if(!stack.isEmpty()){
                currentNode = stack.pop();
            }
        }
        System.out.println();
    }

    //InOrder (L-P-R) - Recursion
    void inOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    //InOrder - Iterative - approach 1
    void iterativeInOrder(BinaryTreeNode<Integer> root){
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> currentNode = root;
        while(currentNode!=null || !stack.isEmpty()){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.println(currentNode.data);
            currentNode = currentNode.right;
        }
    }

    //postOrder (L-R-P) - Recursion
    void postOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    //PostOrder - Iterative - approach 1
    void iterativePostOrder(BinaryTreeNode<Integer> root){
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> current = root;
        BinaryTreeNode<Integer> lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BinaryTreeNode<Integer> peekNode = stack.peek();
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
    
    
    //Breadth First Travesal BFT 
    void levelOrder(BinaryTreeNode<Integer> root){
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty()){
            //Remove the first element from the queue
            BinaryTreeNode<Integer> currentNode = queue.poll();
            System.out.println(currentNode.data+" ");
            if(currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }
        }
    }

     //Breadth First Travesal BFT (Level Order)
    void levelOrder2(BinaryTreeNode<Integer> root){
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //Remove the first element from the queue
            int countQueue = queue.size();
            for(int i=0;i<countQueue;i++){
                BinaryTreeNode<Integer> node = queue.poll();
                System.out.print(node.data+" ");
                if(node.left!=null){
                   queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }

    //Height of a tree
    int height(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;  //Empty tree height is zero
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int value = Math.max(leftHeight,rightHeight);
        return value+1;
    }

    int sizeOfBinaryTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int length = 1;
        length += sizeOfBinaryTree(root.left);
        length += sizeOfBinaryTree(root.right);
        return length;
    }

    //Printing the left view of Binary Tree
    int maxLevel = 0;
    void printLeftView(BinaryTreeNode<Integer> root, int curLevel){
        if(root==null){
            return;
        }

        if(maxLevel<curLevel){
            System.out.println(root.data);
            maxLevel = curLevel;
        }
        printLeftView(root.left, curLevel+1);
        printLeftView(root.right, curLevel+1);
    }
    //Iterative approach (used level order traversal)
    void printLeftViewIterative(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //Remove the first element from the queue
            int countQueue = queue.size();
            for(int i=0;i<countQueue;i++){
                BinaryTreeNode<Integer> node = queue.poll();
                if(i==0){
                    System.out.print(node.data+" ");
                }                
                if(node.left!=null){
                   queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }

    //Printing the Right view of Binary Tree    
    void printRightView(BinaryTreeNode<Integer> root, int curLevel){
        if(root==null){
            return;
        }

        if(maxLevel<curLevel){
            System.out.println(root.data);
            maxLevel = curLevel;
        }
        printLeftView(root.right, curLevel+1);
        printLeftView(root.left, curLevel+1);
    }

    //Iterative approach (used level order traversal)
    void printRightViewIterative(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //Remove the first element from the queue
            int countQueue = queue.size();
            for(int i=0;i<countQueue;i++){
                BinaryTreeNode<Integer> node = queue.poll();
                if(i == countQueue-1){
                    System.out.print(node.data+" ");
                }                
                if(node.left!=null){
                   queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
    
    void printVerticalOrder(BinaryTreeNode<Integer> root){
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrderTraversal(root, 0, map);
        for(Map.Entry<Integer,ArrayList<Integer>> m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }

    //vertical Order Traversal
    void verticalOrderTraversal(BinaryTreeNode<Integer> root,int distance, TreeMap<Integer, ArrayList<Integer>> map){
        if(root==null){
            return;
        }
        
        if(map.get(distance)==null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(distance, list);
        }
        else{
            ArrayList<Integer> list = map.get(distance);
            list.add(root.data);
            map.put(distance, list);
        }

        verticalOrderTraversal(root,distance-1,map);
        verticalOrderTraversal(root,distance+1,map);
    }
}


public class BinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeOperations obj = new BinaryTreeOperations();
        BinaryTreeNode<Integer> root = null;
        while(true){
            System.out.println("Binary Tree Operation");
            System.out.println("1. Insert");
            System.out.println("2. Print");
            System.out.println("Enter the Choice : ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1: root = obj.insert();
                        break;
                case 2: //obj.iterativePostOrder(root);
                        obj.printRightView(root, 1);
                        break;
                case 3: scanner.close(); 
                        return;
            }
        
        }
        //scanner.close();
    }
}
