import java.util.HashMap;

public class LeetCode_146_LRUCache {
    int capacity = 0;
    int count = 0;
    HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    ListNode head = null;
    ListNode tail = null;
    
    class ListNode{
        int val, key;
        ListNode next = null;
        ListNode(int _key, int _val){
            this.key = _key;
            this.val = _val;
        }
    }

    public void remove_lru(){
        map.remove(head.key);
        head = head.next;
        count--;
    }

    public void move_to_tail(ListNode old){
        if(old == tail) return;
        int key = old.key;
        ListNode node = new ListNode(key, old.val);
        map.put(key,node);
        tail.next = node;
        tail = node;

        old.key = old.next.key;
        old.val = old.next.val;
        map.put(old.key,old);
        old.next = old.next.next;
    }

    public LeetCode_146_LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode old = map.get(key);
            int res = old.val;
            move_to_tail(old);
            
            return res;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            move_to_tail(node);
        }else{
            ListNode node = new ListNode(key, value);
            map.put(key,node);
            count++;
            if(head == null){
                head = node; tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            
            if(count > capacity) remove_lru();
        }
    }
}
