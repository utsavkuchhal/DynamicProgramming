public class Solution {

    
    public int solve(int[] A) {
    			int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		/*
		 * We know that min difference can be 0 and the other difference can 1,2.. now
		 * from this we can deduce that one number would be smaller and one larger so
		 * find the largest number <= (n / 2) but also that number should be possible so
		 * instead of checking for each and every number from 1 to n/2 we can directly
		 * use the subset sum table that will check form 1 to n/2 which numbers are
		 * possible and this can kept in mind forever
		 */

		int tempSum = sum / 2;
		int n = A.length;
		boolean[][] dp = new boolean[n + 1][tempSum + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int s = 0; s < dp[0].length; s++) {
				if (s == 0) {
					dp[i][s] = true;
				} else if (i == 0) {
					dp[i][s] = false;
				} else if (A[i - 1] > s) {
					dp[i - 1][s] = false;
				} else {
					dp[i][s] = dp[i - 1][s] || dp[i - 1][s - A[i - 1]];
				}
			}
		}

		int s1 = 0;
		for (int i = tempSum; i >= 1; i--) {
			if (dp[n - 1][i] == true) {
				s1 = i;
				break;
			}
		}

		return sum - 2 * s1;
	}

}
