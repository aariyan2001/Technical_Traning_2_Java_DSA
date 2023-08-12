import java.util.Stack;

public class StockSpanPreviousGreater {

    //input = {60,50,40,30,85,90,60}
    //output = {-1,60,50,40,-1,-1,90}   //finding previous greater

    static int[] previousGreater(int[] input){
        Stack<Integer> stack = new Stack<>();
        stack.push(input[0]);
        int[] output = new int[input.length];
        output[0]=-1;

        for(int i=1;i<input.length;i++){
            if(stack.empty()){
                stack.push(input[i]);
            }
            if(stack.peek()>input[i]){
                output[i] = stack.peek();
                stack.push(input[i]);
                System.out.println(stack.peek());
            }
            else{
                while(!stack.empty()){
                    if(stack.peek()>input[i]){
                        output[i] = stack.peek();
                        stack.push(input[i]);
                        break;
                    }else{
                        stack.pop();
                    }
                }
                if(stack.empty()){
                    output[i]=-1;
                    stack.push(input[i]);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = {60,50,40,30,85,90,60};
        int result[] = previousGreater(array);
        for(int i:result){
            System.out.print(" "+ i);
        }
    }
}
