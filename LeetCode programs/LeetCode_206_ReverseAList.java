public class LeetCode_206_ReverseAList {
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode tmp = head;

        while(tmp!=null){
            ListNode next = tmp.next; 
            tmp.next = result;
            result = tmp;
            tmp = next;          
        }
        return result;
    }
}
