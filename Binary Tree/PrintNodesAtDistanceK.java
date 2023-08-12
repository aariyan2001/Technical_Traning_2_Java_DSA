import java.util.Scanner;
import java.util.Stack;

class ListNode{
    int data;
    ListNode left;
    ListNode right;

    ListNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BTO{
    String nodeName = "root";
    int nodeValue = 0;
    Scanner scanner = new Scanner(System.in);

    ListNode insert(){
        System.out.println("Enter the "+nodeValue+" : "+nodeName+" Data or enter -1 to exit: ");
        int data = scanner.nextInt();
        if(data==-1){
            return null;
        }
        //if data is coming correct
        //prepare a node
        ListNode  node  = new ListNode(data);
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

    void print(ListNode root){
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

    void printKthNodes(int k, ListNode root){
        Stack<ListNode> stack = new Stack<>();
        stack.push(root);
        
        int count = 1;

        while(!stack.isEmpty()){
            ListNode currentNode = stack.pop();
            count++;
            if(count==k){                
                if(currentNode.left!=null){
                    System.out.println(currentNode.left.data);
                }    
                if(currentNode.right!=null){
                    System.out.println(currentNode.right.data);
                }
                count--;
            }
            else{
                if(currentNode.right!=null){
                  stack.push(currentNode.right);
                }
                if(currentNode.left!=null){
                    stack.push(currentNode.left);
                }
            }            
        }    
    }

}

public class PrintNodesAtDistanceK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BTO obj = new BTO();
        ListNode root = null;
        while(true){
            System.out.println("Binary Tree Operation");
            System.out.println("1. Insert");
            System.out.println("2. Print");
            System.out.println("3. Print Kth nodes");
            System.out.println("Enter the Choice : ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1: root = obj.insert();
                        break;
                case 2: obj.print(root);
                        break;
                case 3: System.out.println("Enter value of k: ");
                        int k = scanner.nextInt();
                        obj.printKthNodes(k, root);
                        break;
                case 4: scanner.close();
                        return;
            }
        
        }
        //scanner.close();
    }
    
}
