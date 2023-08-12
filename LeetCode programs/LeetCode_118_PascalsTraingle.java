import java.util.List;
import java.util.ArrayList;

public class LeetCode_118_PascalsTraingle {
    public static  List<List<Integer>> printpattern(int rows){

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<rows;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<=i;j++){

                if(j==0 || i==j){                    
                    l.add(1);
                }else{
                    List<Integer> l2 = new ArrayList<>();
                    l2 = list.get(i-1);
                    int val = l2.get(j)+l2.get(j-1);
                    l.add(val);
                }
            }
            list.add(l);
        }
        return list;
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int num=5;
        list = printpattern(num);
        System.out.println(list);
    }
}
