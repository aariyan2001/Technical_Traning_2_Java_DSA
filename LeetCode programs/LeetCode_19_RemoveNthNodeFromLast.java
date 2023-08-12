class LeetCode_19_RemoveNthNodeFromLast{
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        if(head.next==null){
            head=null;
            return head;
        }

        for(int i=1;i<=n;i++){
            p2 = p2.next;
        }
        ListNode tmp = head;
        while(p2!=null){
            tmp = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1==head){
            head = p1.next;
            return head;
        }
        tmp.next = p1.next;
        return head;
    }
}