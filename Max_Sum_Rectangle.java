import java.util.*;

public class Max_Sum_Rectangle {

	public static void main(String[] args) {
		int R = 2;
		int C = 2;
		int[][] M = { { -1, -2 }, { -3, -4 } };
		System.out.println(maximumSumRectangle(R, C, M));
	}

	static int maximumSumRectangle(int R, int C, int M[][]) {
		// code here
		int ans = Integer.MIN_VALUE;
		int[][] dp = new int[R][C];
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp.length; j++) {
				for (int k = 0; k < dp[0].length; k++) {
					dp[i][k] += M[j][k];
				}
				ans = Math.max(ans, MAX_Sum_Contagious(dp[i]));
			}
		}

		return ans;
	}

	public static int MAX_Sum_Contagious(int[] arr) {
		int max_sum = Integer.MIN_VALUE;
		int max_sum_till_now = 0;
		for (int i = 0; i < arr.length; i++) {
			max_sum_till_now = max_sum_till_now + arr[i];

			if (max_sum_till_now > max_sum) {
				max_sum = max_sum_till_now;
			}

			if (max_sum_till_now < 0) {
				max_sum_till_now = 0;
			}
		}

		return max_sum;
	}

}
