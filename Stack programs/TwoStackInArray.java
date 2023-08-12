public class TwoStackInArray {
    int arr[];
    int capacity;
    int top1;
    int top2;
    TwoStackInArray(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        top1=-1;
        top2=capacity;
    }

    void push1(int ele){
        if(top1<top2-1){
            arr[++top1] = ele;
        }
        else{
            throw new RuntimeException("Stack1 is full");
        }
    }
    
    void push2(int ele){
        if(top1<top2-1){
            arr[--top2] = ele;
        }
        else{
            throw new RuntimeException("Stack2 is full");
        }
    }

    int pop1() {
        if(top1==-1){
            throw new RuntimeException("Stack 1 is empty");
        }else{
            int ele = arr[top1];
            top1--;
            return ele;
        }
    }

    int pop2(){
        if(top2==capacity){
            throw new RuntimeException("Stack 2 is empty");
        }else{
            int ele = arr[top2];
            top2++;
            return ele;
        }
    }

    int peek1(){
        if(top1==-1){
            throw new RuntimeException("Stack 1 is empty");
        }else{
            return arr[top1];
        }
    }

    int peek2(){
        if(top2==capacity){
            throw new RuntimeException("Stack 2 is empty");
        }else{
            return arr[top2];
        }
    }

    int size1(){
        return top1+1;
    }

    int size2(){
        return capacity-top2+1;
    }

    boolean isEmpty1(){
        return top1==-1;
    }

    boolean isEmpty2(){
        return top2==capacity;
    }

    void print1(){
        System.out.println();
        int x= top1;
        while(x>-1){
            System.out.print(" Stack 1: "+ arr[x]);
            x--;
        }
    }

    void print2(){
        System.out.println();
        int x= top2;
        while(x<capacity){
            System.out.print(" Stack 2: "+ arr[x]);
            x++;
        }
    }
    public static void main(String[] args) {
        int capacity=6;
        TwoStackInArray twoStacks = new TwoStackInArray(capacity);
        twoStacks.push1(10);
        twoStacks.push1(20);
        twoStacks.push2(30);
        twoStacks.push2(40);
        twoStacks.push1(50);
        
        twoStacks.print1();
        twoStacks.print2();

    }
}
