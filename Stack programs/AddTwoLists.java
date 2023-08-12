import java.util.*;

class AddTwoLists {
 
    static Node head1, head2;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    // Adds contents of two linked lists and prints it
    Node addLists(Node first, Node second) {
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;
 
        addPrecedingZeros(start1, start2);
        Node result = new Node(0);
        if (sumTwoNodes(start1.next, start2.next, result) == 1) {
            Node node = new Node(1);
            node.next = result.next;
            result.next = node;
        }
        //Node res=reverse_it(result.next);
        //Node output = reverse_it(res);
        return result.next;
        
    }
    static Node reverse_it(Node head)
    {
        Node prev=null;
        Node curr=head,next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
 
    /* Adds lists and returns the carry */
    private int sumTwoNodes(Node first, Node second, Node result) {
        if (first == null) {
            return 0;
        }
        int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
        Node node = new Node(number % 10);
        node.next = result.next;
        result.next = node;
        return number / 10;
    }
 
    /* Appends preceding zeros in case a list is having lesser nodes than the other one*/
    private void addPrecedingZeros(Node start1, Node start2) {
        Node next1 = start1.next;
        Node next2 = start2.next;
        while (next1 != null && next2 != null) {
            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null && next2 != null) {
            while (next2 != null) {
                Node node = new Node(0);
                node.next = start1.next;
                start1.next = node;
                next2 = next2.next;
            }
        } else if (next2 == null && next1 != null) {
            while (next1 != null) {
                Node node = new Node(0);
                node.next = start2.next;
                start2.next = node;
                next1 = next1.next;
            }
        }
    }
 
    /* Utility function to print a linked list */
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
 
    // Driver Code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddTwoLists list = new AddTwoLists();

        // To enter elements for list 1
        System.out.print("\nHow many elements is list1? : ");
        int ele1 = sc.nextInt();
        Node list1 = head1;

        for(int i=0;i<ele1;i++){
            System.out.print("\nEnter value: ");
            int val = sc.nextInt();

            if(list1 == null){
                Node newnode = new Node(val);
                head1 = newnode;
                list1=newnode;
            }else{
                list1.next = new Node(val);
                list1 = list1.next;
            }
        }

        // To enter elements for list 2
        System.out.print("\nHow many elements is list2? : ");
        int ele2 = sc.nextInt();

        Node list2 = head2;

        for(int i=0;i<ele2;i++){
            System.out.print("\nEnter value: ");
            int val = sc.nextInt();

            if(list2 == null){
                Node newnode = new Node(val);
                head2 = newnode;
                list2=newnode;
            }else{
                list2.next = new Node(val);
                list2 = list2.next;
            }
        }
        
        System.out.print("Sum of Two List is: ");
        // add the two lists and see the result
        Node result = list.addLists(head1, head2);
        list.printList(result);
        sc.close();
    }
}
