public class RLE {
    //Running Length Encoding
    //Input - "aaaabbbccDDD"
    //Output - "a4b3c2d3"
    public static void main(String[] args) {
        String s = "aaaabbbbccddd";
        int c = 1 ;
        String result = "";
        int length = s.length();
        char ch = s.charAt(0);

        for(int i=1;i<length;i++){            
            if(ch==s.charAt(i)){
                c++;
            }
            else{
                result = result+ch+c;
                ch=s.charAt(i);
                c=1;
            }
        } 
        result = result+ch+c;
        System.out.println(result);
    }
}
