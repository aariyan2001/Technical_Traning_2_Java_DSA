import java.util.ArrayList;
import java.util.Arrays;


public class Anagram {
    //Anagram means the two string contains same character in same number
    public static void main(String[] args) {
        String s1="rat";
        String s2 = "car";

        //Approach 1
        if(s1.length()!=s2.length()){
            System.out.println("Not an Anagram");
            return;
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            list.add(""+s1.charAt(i));
        }

        for(int i=0;i<s2.length();i++){
            if(!list.contains(""+s2.charAt(i))){
                System.out.println("Not an Anagram");
                return;
            }
            list.remove(""+s2.charAt(i));
        }
        System.out.println("Anagram");

        //Approach 2
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        s1 = new String(a1);

        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);
        s2 = new String(a2);

        System.out.println(s1.equals(s2)?"Anagram":"Not Anagram");

    }
}
