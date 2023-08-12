public class LeetCode_707_DesignLinkedList {
    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size=-1;

    public LeetCode_707_DesignLinkedList() {
            
    }
    
    public int get(int index) {
        if(index>size || index<0 || head==null){
            return -1;
        }
        if(index==0){
            return head.val;
        }
        int i=0;
        Node tmp = head;
        while(i<index){
            tmp=tmp.next;
            i++;
        }
        return tmp.val;
    }
    
    public void addAtHead(int val) {
        if(head==null){
            Node newnode = new Node(val);
            head = newnode;
            size++;
            return;
        }

        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head==null){
            Node newnode = new Node(val);
            head = newnode;
            size++;
            return;
        }
        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        Node newnode = new Node(val);
        tmp.next = newnode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size+1 || index<0){
            return;
        }
        if(index==0){
            Node newnode = new Node(val);
            newnode.next = head;
            head = newnode;
            size++;
            return; 
        }

        int i=1;
        Node tmp = head;
        while(i<index){
            tmp = tmp.next;
            i++;
        }
        Node newnode = new Node(val);
        Node cache = tmp.next;
        newnode.next = cache;
        tmp.next = newnode;
        size++;
    }


//   printing LinkedList
    void print(Node start){
        Node temp = start;
        while(temp != null){
            System.out.print(" "+temp.val);
            temp = temp.next;
        }
    }  
public void deleteAtIndex(int index) {
        if(index>size || head==null || index<0){
            return;
        }
        
        if(index ==0){
            Node tmp = head.next;
            head = tmp;
            size--;
            return;
        }
        int i=0;
        Node tmp = head;
        Node tmp2= head;
        while(i<index){
            tmp2=tmp;
            tmp = tmp.next;
            i++;
        }
        tmp2.next = tmp.next;
        size--;
    }



    public static void main (String[] args){

        LeetCode_707_DesignLinkedList obj = new LeetCode_707_DesignLinkedList();
/*
        obj.addAtHead(2);
        obj.print(obj.head);
        System.out.println();

        obj.deleteAtIndex(1);
        obj.print(obj.head);
        System.out.println();
        
        obj.addAtHead(2);
        obj.print(obj.head);
        System.out.println();

        obj.addAtHead(7);
        obj.print(obj.head);
        System.out.println();

        obj.addAtHead(3);
        obj.print(obj.head);
        System.out.println();

        obj.addAtHead(2);
        obj.print(obj.head);
        System.out.println();

        obj.addAtHead(5);
        obj.print(obj.head);
        System.out.println();

        obj.addAtTail(5);
        obj.print(obj.head);
        System.out.println();

        System.out.println(obj.get(5));

        obj.deleteAtIndex(6);
        obj.print(obj.head);
        System.out.println();

        obj.deleteAtIndex(4);
        obj.print(obj.head);
        System.out.println();
        
*/
        obj.addAtHead(1);
        obj.print(obj.head);
        System.out.println();

        
        obj.addAtTail(3);
        obj.print(obj.head);
        System.out.println();

        obj.addAtIndex(1,2);
        obj.print(obj.head);
        System.out.println();

        obj.deleteAtIndex(1);
        obj.print(obj.head);
        System.out.println();

        System.out.println(obj.get(1));
    }
}
