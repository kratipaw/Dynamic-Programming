package gfg_top20DP_InterviewQuestions;

/**
 * Given a rod of length n inches and an array of prices that contains 
 * prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 * 
 * For example, if length of the rod is 8 and the values of different pieces are given as 
 * following, then the maximum obtainable value is 22 
 * (by cutting in two pieces of lengths 2 and 6)
 * 
 * length   | 1   2   3   4   5   6   7   8  
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * 
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * 
 * length   | 1   2   3   4   5   6   7   8  
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 * 
 * 
 */

public class _9_RodCutting {

	public static void main(String[] args) {

		int prices[] = {3, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println(rodCutting_recur(prices, prices.length));
		
		System.out.println(rodCutting_viaDP(prices));
		
	}

	private static int rodCutting_recur(int prices[], int n) {
		
		if(n <= 0)
			return 0;
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			max = Math.max(max, prices[i] + rodCutting_recur(prices, n - i -1));
		}
		
		return max;
	}
	
	private static int rodCutting_viaDP(int prices[]) {
		
		int n = prices.length;
		
		//dp[i] stores the max price we can get for rod length i
		int dp[] = new int[n+1];
		
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			
			int max = Integer.MIN_VALUE;
			
			for (int j = 0; j < i; j++) {
				
				max = Math.max(max, prices[j] + dp[i-j-1]);
			}
			
			dp[i] = max;
		}
		
		return dp[n];
		
	}
}
