public class ReveseTheString {
    public static void main(String[] args) {
        //Approach one
        String s = "The Sky is blue";
        String w ="",result="";
        for(int i=0;i<s.length();i++){
            w = w+""+s.charAt(i);
            if(s.charAt(i)==' ' || i==s.length()-1){
                if(i<s.length()-1){
                    result = w+result;
                    w="";
                }
                else{
                    result = w+" "+result;
                    w="";
                }                
            }            
        }
        System.out.println(result);

        //approach 2
        String[] str = s.split(" ");
        s="";
        for(String st:str){
            s = st+" "+s;
        }
        System.out.println(s);
    }
}
