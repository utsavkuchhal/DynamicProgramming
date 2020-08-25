/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger; 

class GFG {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t > 0){
		    int n = scn.nextInt();
		    BigInteger[] dp = new BigInteger[n + 1];
		    System.out.println(catalan(n,dp));
		    t--;
		}
	}
	
	   public static BigInteger catalan(int n, BigInteger[] dp) { 
        BigInteger res = new BigInteger("0"); 
          
        // Base case 
        if (n <= 1) { 
            return new BigInteger("1");
        } 
        
        if(dp[n] != null){
            return dp[n];
        }
        for (int i = 0; i < n; i++) { 
            res = res.add(catalan(i, dp).multiply(catalan(n - i - 1, dp))); 
        } 
        return dp[n] =  res; 
    } 
}
