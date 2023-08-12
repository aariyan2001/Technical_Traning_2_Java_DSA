class CoinChange{

    public static int ways(int[] coins, int amount, int index){
        if(amount==0){
            return 1;
        }
        if(amount<0){
            return 0;
        }
        if(amount>0 && index == coins.length){
            return 0;
        }

        return ways(coins, amount-coins[index], index) + ways(coins, amount, index+1);

    }
    public static void main(String[] args) {
        int [] coins = {1,2};
        int amount = 3;
        System.out.println(ways(coins, amount, 0));
    }
}