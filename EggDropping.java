import java.util.Scanner;

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			System.out.println(solution(n, k));
			t--;
		}
	}
	
	public static int solution(int n, int k) {
		if (n == 1) {
			return k;
		}
		
		if (k == 1 || k == 0) {
			return k;
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			int temp = 1 + Math.max(solution(n - 1, i - 1) ,solution(n, k - i));
			ans = Math.min(temp, ans);
		}
		
		return ans;
	}

}
