package gfg_top20DP_InterviewQuestions;

/**
 * Given a rope of length n meters, cut the rope in different parts of integer lengths 
 * in a way that maximizes product of lengths of all parts. 
 * You must make at least one cut. Assume that the length of rope is more than 2 meters.
 * 
 * Examples:
 * 
 * Input: n = 2
 * Output: 1 (Maximum obtainable product is 1*1)
 * 
 * Input: n = 3
 * Output: 2 (Maximum obtainable product is 1*2)
 * 
 * Input: n = 4
 * Output: 4 (Maximum obtainable product is 2*2)
 * 
 * Input: n = 5
 * Output: 6 (Maximum obtainable product is 2*3)
 * 
 * Input: n = 10
 * Output: 36 (Maximum obtainable product is 3*3*4)
 * 
 */

public class _14_MaximumProductCutting {

	public static void main(String[] args) {

		int n = 100;
		
		//System.out.println(maxProd_recur(n));
		
		System.out.println(maxProd_viaDP(n));
		
		System.out.println(maxProd_TOptimized(n));
	}
	
	private static double maxProd_recur(int n) {
		
		if(n == 0 || n == 1)
			return 0;
		
		double max = 0;
		
		for (int i = 1; i < n; i++) {
			
			max = Math.max(max, Math.max(i * (n-i), i * maxProd_recur(n-i)));
			
		}
		
		return max;
		
	}
	
	private static long maxProd_viaDP(int n) {
		
		//dp[i] stores max product that can be achieved by length i.
		long dp[] = new long[n+1];
		
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			
			long max = 0;
			
			for (int j = 1; j <= i/2; j++) {
				
				max = Math.max(max, Math.max(j * (i-j), j * dp[i-j]));
				
			}
			
			dp[i] = max;
		}
		
		return dp[n];
	}
	
	private static long maxProd_TOptimized(int n) {
		
		if(n == 0 || n == 1)
			return 0;
		
		if(n == 2 || n == 3)
			return n-1;
		
		long result = 1;
		
		while(n > 4) {
			
			result = result * 3;
			
			n = n - 3;
		}

		result = result * n;
		
		return result;
	}

}
