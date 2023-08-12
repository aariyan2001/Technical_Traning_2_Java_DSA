import java.util.ArrayList;

public class DiceGame {
    //Using Tree Recursion
    public static void branch(int[] diceval, int num, int sum,String str, ArrayList<String> list) {
        //Termination Case
        if(sum+num>10){
                return;
            }
            
            //Business Logic
            sum=sum+num;
            if(sum==10 && num!=0){      
                str = str+num;
                //System.out.println(str);
                if(!list.contains(str)){
                    list.add(str);
                }
                //System.out.println(str);   //Another way to print result
                
                
            }
            else{
                if(num!=0){
                    str = str+num;    
                }
                            
            }

            //Multiple Recursive Calls (Tree recursion)
            branch(diceval, diceval[0], sum,str,list);
            branch(diceval, diceval[1], sum,str,list);
            branch(diceval, diceval[2], sum,str,list);
            branch(diceval, diceval[3], sum,str,list);
            branch(diceval, diceval[4], sum,str,list);
            branch(diceval, diceval[5], sum,str,list);
        }

        //Using Stack fall method

        public static ArrayList<String> dicegame(int currentvalue,int endvalue) {
            if(currentvalue==endvalue){
                ArrayList<String> list = new ArrayList<>();
                list.add("");
                return list;
            }

            ArrayList<String> finalresult = new ArrayList<>();

            for(int diceval=1;diceval<=6;diceval++){
                if(currentvalue>endvalue){
                    ArrayList<String> listemp = new ArrayList<>();
                    return listemp; 
                }
                int newvalue = currentvalue + diceval;
                ArrayList<String> returnval = dicegame(newvalue, endvalue);
                for(String str:returnval){
                    finalresult.add(diceval+str);
                }                 
            }
            return finalresult;
        }
    
    public static void main(String[] args) {
        int[] diceval = {1,2,3,4,5,6};
        
        ArrayList<String> list = new ArrayList<>();
        branch(diceval,0, 0,"", list);
        System.out.println("\nThe set of all possible combinations of dice values which makes up sum equal to 10 are: --> \n");
        System.out.println(list);

        System.err.println(dicegame(0, 10));
    }
}