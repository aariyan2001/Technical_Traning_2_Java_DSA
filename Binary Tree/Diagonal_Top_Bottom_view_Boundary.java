import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
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

    
    void printTopView(BinaryTreeNode<Integer> root){
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrderTraversal(root, 0, map);
        for(Map.Entry<Integer,ArrayList<Integer>> m : map.entrySet()){
            ArrayList<Integer> list = m.getValue();
            System.out.println(list.get(0));
        }
    }

    void printBottomView(BinaryTreeNode<Integer> root){
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrderTraversal(root, 0, map);
        for(Map.Entry<Integer,ArrayList<Integer>> m : map.entrySet()){
            ArrayList<Integer> list = m.getValue();
            System.out.println(list.get(list.size()-1));
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
    
    //Diagonal View of the binary tree
    void diagonalPrintUtil(BinaryTreeNode<Integer> root,int d, TreeMap<Integer,ArrayList<Integer>> diagonalPrint){
         
         // Base case
        if (root == null)
            return;
         
        ArrayList<Integer> k = diagonalPrint.get(d);
        
        if (k == null){
            k = new ArrayList<>();
            k.add(root.data);
        }
        else{
            k.add(root.data);
        }
         
        diagonalPrint.put(d,k);
        diagonalPrintUtil(root.left,d + 1, diagonalPrint);
        diagonalPrintUtil(root.right,d, diagonalPrint);
    }
     
    void diagonalPrint(BinaryTreeNode<Integer> root){
         
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        diagonalPrintUtil(root, 0, map);
         
        System.out.println("Diagonal Traversal of Binary Tree");
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()){
            System.out.println(m.getValue());
        }
    }

    // A simple functions to print boundary nodes of a binary tree
    void printLeaves(BinaryTreeNode<Integer> node)
    {
        if (node == null)
            return;
 
        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }
 
    void printBoundaryLeft(BinaryTreeNode<Integer> node)
    {
        if (node == null)
            return;
 
        if (node.left != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }
 
    
    void printBoundaryRight(BinaryTreeNode<Integer> node)
    {
        if (node == null)
            return;
 
        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }

    void printBoundary(BinaryTreeNode<Integer> node)
    {
        if (node == null)
            return;
 
        System.out.print(node.data + " ");
        printBoundaryLeft(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        printBoundaryRight(node.right);
    }

}
public class Diagonal_Top_Bottom_view_Boundary {

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
                        System.out.println("Top View of Tree");
                        obj.printTopView(root);
                        System.out.println("Bottom View of Tree");
                        obj.printBottomView(root);
                        System.out.println("Diagonal View of Tree");
                        obj.diagonalPrint(root);
                        System.out.println("Boundary Nodes of Tree");
                        obj.printBoundary(root);
                                                
                        break;
                case 3: scanner.close(); 
                        return;
            }
        
        }
        //scanner.close();
    }
}
