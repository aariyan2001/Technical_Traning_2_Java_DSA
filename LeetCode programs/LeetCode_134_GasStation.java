public class LeetCode_134_GasStation {
    /*
    public static boolean travel(int[] gas, int[] cost, int start){
        int costrem=0;
        int val = start;
        for(int i=0;i<=gas.length;i++){
            costrem = costrem + (gas[start%gas.length]-cost[start%cost.length]);
            if(costrem>0){
                start++;
            }
            else if(start%gas.length == val-1){
                return true;
            }
            else if(costrem<=0 && start%gas.length!=val-1){
                return false;
                //break;
            }
            else if(costrem<=0 && start%gas.length==val-1){
                return true;
            }
        }
        return true;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        boolean result=false;
        int k=0;
        for(int i=0;i<gas.length;i++){
            if(gas[i]>cost[i]){

                result = travel(gas, cost, i);
                k=i;
                if(result == true){
                    return k;
                }
                
            }
        }
        
        return -1;
    
    }
    */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int startingPoint =0;
        int surplus =0;
        int deficit = 0;

        for(int i=0;i<gas.length;i++){
            surplus += gas[i]-cost[i];
            if(surplus<0){
                deficit += surplus;
                surplus = 0;  //reset
                startingPoint = i+1; //Move to the next station
            }
        }
        //Check is it complete the circuit
        if((deficit+surplus)>=0){
            return startingPoint;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
