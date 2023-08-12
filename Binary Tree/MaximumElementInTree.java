import java.util.Scanner;
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

class BTO2{
    String nodeName = "root";
    int nodeValue = 0;
    Scanner scanner = new Scanner(System.in);
    int max = 0;

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

    void printMaxElement(ListNode root){
        
        if(root==null){
            return;
        }
        if(root.data>max){
            max= root.data;
        }
        printMaxElement(root.left);
        printMaxElement(root.right);
    }
}

public class MaximumElementInTree {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        BTO2 obj = new BTO2();
        ListNode root = null;
        while(true){
            System.out.println("Binary Tree Operation");
            System.out.println("1. Insert");
            System.out.println("2. Print");
            System.out.println("3. Print Max Element");
            System.out.println("Enter the Choice : ");
            int choice = scanner.nextInt();
             switch(choice){
                case 1: root = obj.insert();
                        break;
                case 2: obj.print(root);
                        break;
                case 3: obj.printMaxElement(root);
                        System.out.println(obj.max);
                        break;
                case 4: scanner.close();
                        return;
            }
        }
    }
}
