public class Palindrome {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode head;
    ListNode tail;

    void add(int data){
        ListNode newnode = new ListNode(data);
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

    void print(ListNode start){
        ListNode tmp = start;
        while(tmp!=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
             return true;
        }
        int count=0;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            ListNode newnode = new ListNode(slow.val);
            if(prev==null){
                prev=newnode;
            }
            else{
                newnode.next = prev;
                prev = newnode;
            }
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next!=null){
            if(count%2!=0){
               slow=slow.next;
            }
        }
        
        System.out.println("-->"+count);
        print(slow);

        while(slow!=null){
            if(slow.val==prev.val){
                slow = slow.next;
                prev=prev.next;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        obj.add(1);
        obj.add(2);
        obj.add(2);
        obj.add(2);
        obj.add(1);
        System.out.println(obj.isPalindrome(obj.head));
    }

}
