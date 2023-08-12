public class LeetCode_2_AddTwoNumbers {
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public ListNode addTwoNumbers(ListNode first, ListNode second){
        ListNode head1 = first;
        ListNode head2 = second;
        ListNode result = null;
        ListNode output = null;
        int carry = 0;
        while(head1!=null || head2!=null){
            if(head1!=null && head2!=null){
                ListNode newnode = new ListNode((head1.val+head2.val+carry)%10);
                
                if((head1.val+head2.val+carry)>=10){
                    carry = 1;
                }else{
                    carry = 0;
                }

                if(result!=null){
                    result.next = newnode;
                    result = result.next;
                    head1 = head1.next;
                    head2 = head2.next;
                }
                else{
                    result = newnode;
                    output = result;
                    head1 = head1.next;
                    head2 = head2.next;
                }           
            }
            else if(head1!=null){
                ListNode newnode = new ListNode((head1.val+carry)%10);
                
                if((head1.val+carry)>=10){
                    carry = 1;
                }else{
                    carry =0;
                }
                result.next = newnode;
                result = result.next;
                head1 = head1.next;
            }
            else if(head2!=null){
                ListNode newnode = new ListNode((head2.val+carry)%10);
                //carry = 0;
                if((head2.val+carry)>=10){
                    carry = 1;
                }else{
                    carry =0;
                }
                result.next = newnode;
                result = result.next;
                head2 = head2.next;
            }
        }
        if(carry==1){
            ListNode newnode = new ListNode(carry);
            result.next = newnode;
        }
        return  output;
    }
}
