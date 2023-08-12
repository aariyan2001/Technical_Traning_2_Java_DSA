public class LeetCode_234_PalindromeInLinkedList {
    public static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
        
       
    public static ListNode reverse(ListNode list){
        ListNode head = null;
        ListNode tmp = list;
        
        while(tmp!=null){
            if(head==null){
                head = new ListNode(tmp.val);
                tmp = tmp.next;
            }else{
                ListNode newnode = new ListNode(tmp.val);
                newnode.next = head;
                head = newnode;
                tmp = tmp.next; 
            }
        }
        return head;
    }
     public boolean isPalindrome(ListNode head) {
        ListNode rev = reverse(head);
        ListNode tmp = head;
        while(tmp!=null){
            if(tmp.val == rev.val){
                tmp = tmp.next;
                rev = rev.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
