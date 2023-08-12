public class LeetCode_430_FlattenLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node findTail(Node child){
        while(child.next != null){
            child=child.next;
        }
        return child;
    }
    public Node flatten(Node head) {
        Node curr=head;
        while(curr!=null){
            if(curr.child != null){
                Node tail = findTail(curr.child);
                if(curr.next != null){
                    curr.next.prev=tail;
                }
                
                tail.next = curr.next;
                curr.next =curr.child;
                curr.child.prev = curr;
                curr.child =null;
            }
            curr = curr.next;
        }
        return head;
    }
}
