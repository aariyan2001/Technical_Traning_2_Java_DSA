import java.util.Stack;

public class StockSpanPreviousSmaller {

    static int[] previousSmaller(int[] input){
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[input.length];
        stack.push(input[0]);
        output[0]=-1;

        for(int i=1;i<input.length;i++){
            if(stack.empty()){
                stack.push(input[i]);
            }else{
                if(stack.peek()>input[i]){
                    while(!stack.empty()){
                        if(stack.peek()<input[i]){
                            output[i]=stack.peek();
                            stack.push(input[i]);
                            break;
                        }
                        else{
                            stack.pop();
                        }
                    }
                    if(stack.empty()){
                        output[i]=-1;
                        stack.push(input[i]);
                    }
                }else{
                    output[i] = stack.peek();
                    stack.push(input[i]);
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] array = {60,70,80,35,90,45,60};
        int[] result = previousSmaller(array);
        for(int i:result){
            System.out.print(" "+ i);
        }
    }   
}
