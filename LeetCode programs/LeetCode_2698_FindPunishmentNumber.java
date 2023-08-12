public class LeetCode_2698_FindPunishmentNumber {
    public static int punishmentNumber(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            int squareval = i*i;
            if(isEqual(squareval,i)){
                sum += squareval;
            }            
        }
    return sum;
    }

    static boolean isEqual(int num, int i){
        if(i<0 || num<i){
            return false;
        }
        if(num == i){
            return true;
        }

        return isEqual(num/10,i-num%10) || isEqual(num/100,i-num%100) || isEqual(num/1000,i-num%1000);
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(36));
    }
}
