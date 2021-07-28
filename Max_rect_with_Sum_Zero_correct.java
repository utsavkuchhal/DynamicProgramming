import java.util.*;

public class Max_rect_with_Sum_Zero {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		int[][] a = new int[row][col];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = scn.nextInt();
			}
		}

//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a.length; j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
		maximumSumRectangle(row, col, a);
	}

	static int maximumSumRectangle(int R, int C, int M[][]) {
		// code here
		int ans = Integer.MIN_VALUE;
		int size = 0;
		int sr = 0;
		int sc = 0;
		int er = 0;
		int ec = 0;
		int[][] dp = new int[R][C];
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp.length; j++) {
				for (int k = 0; k < dp[0].length; k++) {
					dp[i][k] += M[j][k];
				}

				int[] temp = largestSubarrayWithZeroSum(dp[i]);
				int b = temp[0];
				int h = j - i + 1;
				int area = b * h;
				if (area > size) {
					size = area;
					sr = i;
					sc = temp[1];
					er = j;
					ec = temp[2];
				}
			}
		}

		for (int i = sr; i <= er; i++) {
			for (int j = sc; j <= ec; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}

		return ans;
	}

	public static int[] largestSubarrayWithZeroSum(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int length = 0;
		int start = 0;
		int end = 0;
		map.put(sum, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				int temp = i - map.get(sum);
				if (temp > length) {
					length = temp;
					start = map.get(sum) + 1;
					end = i;
				}
			} else {
				map.put(sum, i);
			}
		}

		int[] temp = new int[3];
//		System.out.println(" l " + length + " start " + start + " end " + end);
		temp[0] = length;
		temp[1] = start;
		temp[2] = end;
		return temp;
	}

}
