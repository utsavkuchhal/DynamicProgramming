class Solution{
    static int minJumps(int[] arr){
        //this is my code
        // dp array
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0;  i < n; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            //checking from 0 to index i that if there is a shorter path for 
            //current position to reach from any of the previous indexes
            //also previous index should not be MAX_VALUE as this will  show that
            //we were not able to reach this particular index
            for(int j = 0; j < i; j++){
                if(dp[j] != Integer.MAX_VALUE && arr[j] + j >= i){
                    if(dp[j] + 1 < dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        
        if(dp[n  - 1] != Integer.MAX_VALUE){
            return dp[n - 1];
        }
        
        return -1;
    }
}
