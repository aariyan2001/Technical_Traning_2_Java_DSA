import java.util.ArrayList;

public class MazePathProblem {
    //Using Tree Recursion
    public static void pathFinder(int down, int right, ArrayList<String> paths,int flag,String str) {
        //Termination case
        if(down>2 || right>2){
            return;
        }

        //Business logic
        //For Down moves
        if(down!=0 && flag==0){
            str = str+"D";
        }
        //for right moves
        else if(right!=0 && flag==1){
            str = str+"R";
        }
        //For diagonal moves
        else if(right!=0 && down!=0 && flag==2){
            str = str+"I";
        }

        if(down==2 && right == 2){
            paths.add(str);
        }

        //Multiple Recursive call
        pathFinder(down+1, right ,paths,0,str);
        pathFinder(down, right+1, paths,1,str);
        //For diagonal move
        pathFinder(down+1, right+1, paths,2,str);
        
    }


    //Using Stack fall 
    public static ArrayList<String> path(int down,int right,int row,int column) {
        if(down==row-1 && right==column-1){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        
        //Down move
        if(down<row-1){
            ArrayList<String> temp = path((down+1),right,row,column);
            for(String s:temp){
               result.add(s+"D"); 
            }
        }

        //Right move
        if(right<column-1){
            ArrayList<String> temp = path(down,(right+1),row,column);
            for(String s:temp){
               result.add(s+"R"); 
            }
        }

        
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        pathFinder(0, 0, list, 0, "");
        System.out.println("\nAll the possible paths to reach the goal are given below....\n");
        System.out.println(list);
        System.out.println();
        System.out.println(path(0, 0, 5, 5));
    }
}
