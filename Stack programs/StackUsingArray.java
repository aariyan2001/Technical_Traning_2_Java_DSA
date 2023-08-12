public class StackUsingArray {
    
    public static class stack {
        private int[] array;
        private int capacity;
        private int top;

        public stack(int capacity){
            this.capacity = capacity;
            array = new int[capacity];
            top=-1;
        }

        public void push(int ele){
            if(top==capacity-1){
                //throw new Exception("Stack Overflow");
                System.out.println("--> Stack Overflow <--");
                return;
            }
            ++top;
            array[top] = ele; 
            System.out.println("Element pushed ");
        }

        public int pop(){
            if(top<=-1){
                System.out.println("--> Stack Underflow <--");
                return -1;
            }
            int val = array[top--];
            return val;
        }

        public int peek(){
            if(top<=-1){
                System.out.println("--> Stack Underflow <--");
                return -1;
            }
            return array[top];
        }

        public int size(){
            return top+1;
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
                System.out.print(" "+array[t]);
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
