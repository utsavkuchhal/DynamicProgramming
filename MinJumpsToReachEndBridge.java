import java.util.Arrays;
import java.util.Collections;


// Minimum no. of jumps required to reach the other side of the bridge. The bridge is represented in the form of an array consisting of 1s and 0s.
// 1 represents a valid step while 0 represents a broken step. We are given another array which consists of no of steps we can cover in one jump.
// We need to find the minimum jumps required to reach another end. 
// Example: 
// Bridge=[1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,0,1] 
// Jumps=[2,3,5,6] 
// Output: 4


public class MinJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Bridge = { 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1 };
		int[] Jumps = { 6, 5, 3, 2 };
		System.out.println(solution(Bridge, Bridge.length, Jumps));
	}

	public static int solution(int[] bridge, int n, int[] jumps) {

		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < jumps.length; i++) {
			if (jumps[i] - 1 < n && bridge[jumps[i] - 1] == 1) {
				dp[jumps[i] - 1] = 1;
			}
			if (jumps[i] - 1 == n) {
				dp[n] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (bridge[i] == 1)
				for (int j = 0; j < jumps.length; j++) {
					if (i - jumps[j] >= 0 && dp[i - jumps[j]] != Integer.MAX_VALUE && dp[i] > dp[i - jumps[j]] + 1) {
						dp[i] = dp[i - jumps[j]] + 1;
					}
				}
		}

		for (int j = 0; j < jumps.length; j++) {
			if (n - jumps[j] >= 0 && dp[n - jumps[j]] != Integer.MAX_VALUE && dp[n] > dp[n - jumps[j]] + 1) {
				dp[n] = dp[n - jumps[j]] + 1;
			}

		}

		if (dp[n] == Integer.MAX_VALUE)
			return -1;
		return dp[n];
	}
}
