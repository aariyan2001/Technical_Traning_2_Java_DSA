import java.util.ArrayList;

public class StackWithArrayList {
    public static class stack {
        private ArrayList<Integer> array;
        private int capacity;
        private int top;

        public stack(int capacity){
            this.capacity = capacity;
            array = new ArrayList<>();
            top=-1;
        }

        public void push(int ele){
            if(top==capacity-1){
                //throw new Exception("Stack Overflow");
                System.out.println("--> Stack Overflow <--");
                return;
            }
            ++top;
            array.add(top, ele); 
            System.out.println("Element pushed: "+ ele);
        }

        public int pop(){
            if(top<=-1){
                System.out.println("--> Stack Underflow <--");
                return -1;
            }
            int val = array.get(top);
            array.remove(top);
            top--;
            return val;
        }

        public int peek(){
            if(top<=-1){
                System.out.println("--> Stack Underflow <--");
                return -1;
            }
            return array.get(top);
        }

        public int size(){
            return array.size();
        }

        public boolean isEmpty(){
            if(top==-1){
                return true;
            }else{
                return false;
            }
        }

        public void print(){
            int t = top;
            while(t!=-1){
                System.out.print(" "+array.get(t));
                t--;
            }
        }
    }
    public static void main(String[] args) {
        stack obj = new stack(5);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        obj.push(100);
        obj.print();
        System.out.println("-->"+obj.size());
    }
}
