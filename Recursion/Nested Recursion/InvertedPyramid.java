public class InvertedPyramid {
    public static void printspace(int space) {
        //Termination case
        if(space==0){
            return;
        }
        //Business logic
        System.out.print(" ");
        //Recursive call
        printspace(space-1);
    }

    public static void printstar(int star) {
        //Termination case
        if(star==0){
            return;
        }
        //Business logic
        System.out.print("*");
        //Recursive call
        printstar(star-1);
    }

    public static void printrows(int rows,int star) {
        //Termination case
        if(rows==0){
            return;
        }
        //Recursive call
        printrows(rows-1,star+2);
        //Business logic
        printspace(rows-1);
        printstar(star);
        System.out.println();

    }
    public static void main(String[] args) {
        printrows(5, 1);
    }
}
