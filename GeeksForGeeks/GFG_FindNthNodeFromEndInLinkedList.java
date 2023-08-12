public class GFG_FindNthNodeFromEndInLinkedList {
    
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}


class Solution
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node tmp = head;
    	int count = 0;
    	while(tmp!=null){
    	    count++;
    	    tmp = tmp.next;
    	}
    	if(n>count || n<0){
    	    return -1;
    	}
    	count = count-n;
    	tmp = head;
    	while(count>0){
    	    count--;
    	    tmp = tmp.next;
    	}
    	return tmp.data;
    }
}

}
