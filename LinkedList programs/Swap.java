public class Swap {
    static class ListNode {
        int data;
        ListNode next;
        
        public ListNode(int head){
            this.data = head;
            this.next = null;
        }
    }

    static void print(ListNode root){
        ListNode copy = root;
        System.out.println();
        while(copy!=null){
            System.out.print(copy.data+" -> ");
            copy=copy.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode d = new ListNode(0), a;
        d.next = head;
        print(d);
        a=d;
        print(a);
        while(head!=null && head.next!=null) {
            a.next = head.next;
            print(a);
            head.next = head.next.next;
            print(head);
            a.next.next = head;
            print(a);
            a = a.next.next;
            print(a);
            head =  head.next;
        }
        return d.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node = head;
        head.next = new ListNode(20);
        head = head.next;
        head.next = new ListNode(30);
        head = head.next;
        head.next = new ListNode(40);
        head = head.next;
        head.next = new ListNode(50);
        head = head.next;
        head.next = new ListNode(60);
        head = head.next;
        //System.out.println(">>>>>>>>>>>>");
        ListNode copy = swapPairs(node);
        while(copy!=null){
            System.out.print(copy.data+" -> ");
            copy=copy.next;
        }
    }
}
