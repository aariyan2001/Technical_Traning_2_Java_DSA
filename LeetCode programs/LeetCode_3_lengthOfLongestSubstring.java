import java.util.ArrayList;
import java.util.List;

public class LeetCode_3_lengthOfLongestSubstring {public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }

        List<List<String>> finaList = new ArrayList<>();

        for(int i=0; i<s.length()-1; i++){
            List<String> list = new ArrayList<>();
            String str = ""+s.charAt(i);
            list.add(str);
            //System.out.println(list);
            for(int j=i+1;j<s.length();j++){
                if(!list.contains(""+s.charAt(j))){
                    String st = ""+s.charAt(j);
                    list.add(st);
                }
                else{
                    
                    break;
                }
                
            }
            finaList.add(list);
            //System.out.println(".."+finaList);
        }
        int max=0;
        for(List<String> l : finaList){
            if(l.size()>max){
                max=l.size();
            }
        }
        return max;
        
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
