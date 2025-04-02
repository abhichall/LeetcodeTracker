class Solution {
    public int coinChange(int[] coins, int amount) {
      
        //edge cases
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        //arr to store minimum coins for each value until amount
        int[] arr = new int[amount + 1];

        //min amount needed to make 0
        arr[0] = 0;

        
        //iterate through minCombos
        for(int i = 1; i <= amount; i++) {

            //initialize to max index 
            arr[i] = amount + 1;

            //try each coin/denomination
            for(int coin: coins) {
                if(coin <= i) {

                    //update the value to minimum
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                }
            }
        }

        //arr[amount]
        if (arr[amount] > amount) {
            return -1;
        } else {
            return arr[amount];
        }

    }
}