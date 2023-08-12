import java.util.Scanner;

public class AddTwoListsElements {

    public static Node reverseList(Node x){
        //your code goes here
        Node reverse = null;
        Node head = null;
        while(x!=null){
            if(reverse==null){
                reverse=x;
                head = reverse;
                x=x.next;
            }else{
                Node tmp = new Node(x.val);
                tmp.next = reverse;
                head = tmp;
            }
        }
        return head;
    }

    public static Node addTwoLists(Node first, Node second){
        first = reverseList(first);
        second = reverseList(second);
        Node head = null;
        Node result = null;
        int carry = 0;
        while(first!=null && second!=null){
            Node sum = new Node((first.val+second.val+carry)%10);
            carry = 0;
            if((first.val+second.val)>=10){
                carry = 1;
            }
            if(head==null){
                head=sum;
                result = head;
            }else{
                head.next = sum;
            }
            first = first.next;
            second = second.next;
        }
        if(first!=null){
            while(first!=null){
                Node sum = new Node((first.val+carry)%10);
            
                if((first.val+carry)>=10){
                    carry = 1;
                }
                else{
                    carry =0;
                }
                head.next = sum;
            }
            
        }
        else if(second!=null){
            while(second!=null){
                Node sum = new Node((second.val+carry)%10);
            
                if((second.val+carry)>=10){
                    carry = 1;
                }
                else{
                    carry =0;
                }
                head.next = sum;
            }            
        }
        result = reverseList(result);
        return result;        
    } 


static class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

static void printList(Node n){
        while(n!=null){
            System.out.print(n.val+" ");
            n = n.next;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
            System.out.println("enter size list1: ");
            int n = sc.nextInt();
            System.out.println("Enter first element: ");
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                System.out.println("Enter element");
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            printList(first);
            
            System.out.println("enter size list1: ");
            int m = sc.nextInt();
            System.out.println("Enter first element: ");
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                System.out.println("Enter element");
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            printList(second);
            
            Node res = addTwoLists(first, second);
            printList(res);
            sc.close();
    }      
}

