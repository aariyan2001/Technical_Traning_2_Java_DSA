public class LeetCode_141_DetectCycleInList {
    class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //Using Floyds cycle
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){  //detect the cycle
                return true;
            }
        }
        return false;
    }
}
