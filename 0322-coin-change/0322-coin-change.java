class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //max amount -- 10 cents -- minimum that 10 cent
            // 0 1 2 3 
        
        //initialize an array to hold values - represent I up till amount 
        // [0] = 0 -- [i] = min(dpi[i], min([i - coin] + 1))

        if(amount == 0) return 0;

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;


        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}