import java.util.ArrayList;

public class PermutationString {

    //Using ArrayList and Stack fall method
    public static ArrayList<String> permutation(String str) {
        if(str.length()==0){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> store = permutation(str.substring(1));
        ArrayList<String> result = new ArrayList<>();
        
        for(String st: store){

            if(st.length()==0){
                result.add(str);
            }
            else{
                for(int i=0;i<=st.length();i++){
                    StringBuilder sb = new StringBuilder(st);
                    sb.insert(i, str.charAt(0));
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }
}
