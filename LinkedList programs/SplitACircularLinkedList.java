public class SplitACircularLinkedList {
    static class Node {
        int data;
        Node next;
        
        public Node(int head){
            this.data = head;
            this.next = null;
        }
    }

    public static void splitCircularList(Node head) {
        Node tmp = head;
        int count = 1;
        while(tmp.next!=head){
            count++;
            tmp=tmp.next;
        }
        tmp.next = null;
        Node last = tmp;
        //System.out.println(count);
        int val = count/2;
        tmp = head;
        while(val>1){
            tmp = tmp.next;
            val--;
        }
        Node secondNode = tmp.next;
        tmp.next = head;    // formed first cycled list
        last.next = secondNode; // formes second cycled list
        System.out.println("Two cycle list formed : "+head.data + " and "+ secondNode.data);
	}

    public static void main(String[] args) {
        Node head = new Node(10);
        Node node = head;
        head.next = new Node(20);
        head = head.next;
        head.next = new Node(30);
        head = head.next;
        head.next = new Node(40);
        head = head.next;
        head.next = new Node(50);
        head = head.next;
        head.next = new Node(60);
        head = head.next;
        head.next = node;
        //System.out.println(">>>>>>>>>>>>");
        splitCircularList(node);
    }
}
