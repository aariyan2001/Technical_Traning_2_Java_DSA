import java.util.Scanner;

class Node<T>{  //Node of general type T
    T data;
    Node<T> next;  //refrence variable

    Node(T data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListOperations<T> {
    // Scanner in = new Scanner(System.in);
    Node<T> head;
    Node<T> tail;

    void add(T data){
        Node<T> newnode = new Node<>(data);
        if(head==null){
            head = newnode;
            tail = newnode;
        }
        else{ 
            tail.next = newnode;
            tail = newnode;
        }
        //System.out.println("Enter the data: ");
    }

    void addPositionWise(int position,T data){
        Node<T> newnode = new Node<>(data);
        if(position == 0){
            newnode.next = head;
            head = newnode;
            return;
        }
        int i=1;
        Node<T> tmp = head;
        while(i<position){
            tmp = tmp.next;
            i++;
        }
        newnode.next = tmp.next;
        tmp.next = newnode;
    }
    
    void midElement(){
        Node<T> slow = head;
        Node<T> fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.data); //mid element
    }
   
    void findKthFromLast(int kth){
        Node<T> p = head;
        Node<T> q = head;
        //move q till kth
        for(int i=1;i<=kth;i++){
            q= q.next;
        }
        //now q move till end
        while(q!=null){
            p=p.next;
            q = q.next;
        }
        System.out.println("Kth element: "+p.data);
    }

    void detectCycleAndRemoveCycle(){
        Node<T> slow = head;
        Node<T> fast = head;
        //Using Floyds cycle
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){  //detect the cycle
                System.out.println("Yes there is a cycle!");
                break;
            }
        }
        if(slow!=fast){
            System.out.println("No cycle...");
            return;
        }
        slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast = fast.next.next;
        }
        fast.next = null;  //breaked the cycle
    }

    void deletePositionWise(int position){
        if(head == null){
            System.out.println("Nothing to delete--Empty ");
            return;
        }
        //delete head
        Node<T> tmp;
        if(position==0){
            tmp=head.next;
            head = tmp;
            return;
        }

        tmp = head;
        int i=1;
        while(i<position){
            tmp = tmp.next;
            i++;
        }
        tmp.next = tmp.next.next;
    }

    void print(Node<T> start){
        Node<T> tmp = start;
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    
    public static void main(String[] args) {
        //Create a node
        //Node<Integer> node = new Node<>(100);
        //connect the node
        //Node<Integer> node2 = new Node<>(200);
        //node.next = node2; 
        LinkedListOperations<Integer> l = new LinkedListOperations<>();
        int choice = 0;
        Scanner in = new Scanner(System.in);
    
        while(true){
            System.out.println("1. Add");
            System.out.println("2. Print");
            System.out.println("3. Add position wise");
            System.out.println("4. Delete position wise");
            System.out.println("Enter the choice: ");

            choice = in.nextInt();
            switch(choice){
                case 1: l.add(300);
                        l.add(400);
                        l.add(500);
                        break;
                case 2: l.print(l.head);
                        break;
                case 3: l.addPositionWise(0, 1000);
                        break;
                case 4: l.deletePositionWise(1);
                        break;
                default: System.out.println("Wrong choice!");
                         in.close();
                         return;
            }
        }
    }    
}
