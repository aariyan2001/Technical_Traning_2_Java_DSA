public class StockSpan {
    //if input = {60,50,40,30,70,85,90,50}
    //Output = {1,1,1,1,5,6,7,1}
    static int[] stockSpan(int[] input){
        int val = input[0];
        int[] output = new int[input.length];
        for(int i=0;i<input.length;i++){
            if(val<input[i]){
                output[i] = i+1;
            }
            else{
                output[i] = 1;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int array[] = {60,50,40,30,70,85,90,50};
        int profitdays[] = stockSpan(array);
        for(int i : profitdays){
            System.out.print(" "+ i);
        }
    }
    
}
