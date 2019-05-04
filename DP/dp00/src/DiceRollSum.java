public class DiceRollSum {

    // Runtime: TODO
    // Space: TODO
    public static int diceRollSum(int N) {
        // TODO
        // [1,2]
        //base cacen 0 1
        int[] DP = new int[N+1];
        for(int i = 0; i < DP.length; i++){DP[i] = -1;}
        //int ans = diceHelp(N, DP);
        ///diceHelp(N, ans, DP);
        return diceHelp(N, DP);
    }

    public static  int diceHelp(int sum, int[] dp){

        if(sum < 0){return 0;}
        if(sum == 0){return 1;}
        if (dp[sum] != -1){return dp[sum];}
        dp[sum] = 0;
        for(int i =1; i <=6; i++){
            dp[sum] +=  diceHelp(sum-i, dp);
        }
//        dp[sum] =  diceHelp(sum-1, dp);
//        dp[sum] +=  diceHelp(sum-2, dp);
//        dp[sum] +=  diceHelp(sum-3, dp);
//        dp[sum] +=  diceHelp(sum-4, dp);
//        dp[sum] +=  diceHelp(sum-5, dp);
//        dp[sum] +=  diceHelp(sum-6, dp);
        return dp[sum];
    }

}
