package gfg_top20DP_InterviewQuestions;

import java.util.Arrays;

public class _3_01_Knapsack {

	public static void main(String[] args) {

		int val[] = new int[]{60, 100, 120};
		
        int wt[] = new int[]{10, 20, 30}; 
    
        int  W = 50; 
		
        int n = val.length;
        
        System.out.println(maxValue_recur(W, wt, val, n));
        
        System.out.println(maxValue_viaDP(W, wt, val, n));
        
        System.out.println(maxValue_Unbound(W, wt, val, n));
        
	}
	
	private static int maxValue_recur(int W, int wt[], int val[], int n ) {
		
		if(n == 0 || W == 0)
			return 0;
		
		if(wt[n-1] > W)
			return maxValue_recur(W, wt, val, n-1);
		
		else
			return Math.max(maxValue_recur(W, wt, val, n-1), val[n-1] + maxValue_recur(W-wt[n-1], wt, val, n-1));
		
	}
	
	private static int maxValue_viaDP(int W, int wt[], int val[], int n) {
		
		if(n == 0 || W == 0)
			return 0;
		
		int knap[][] = new int[n+1][W+1];
		
		for (int i = 0; i <= n; i++) {
			
			for (int j = 0; j <= W; j++) {
				
				if(i == 0 || j == 0)
					knap[i][j] = 0;
				
				else if(wt[i-1] > j)
					knap[i][j] = knap[i-1][j];
				
				else
					knap[i][j] = Math.max(knap[i-1][j], val[i-1] + knap[i-1][j-wt[i-1]]);
				
			}
			
		}
		
		return knap[n][W];
	}
	
	private static int maxValue_Unbound(int W, int wt[], int val[], int n) {
		
		if(n == 0 || W == 0)
			return 0;
		
		int knap[] = new int[W+1];
		
		Arrays.fill(knap, 0);
		
		for (int i = 0; i <= W; i++) {
			
			for (int j = 0; j < n; j++) {
				
				if(wt[j] <= i)
					knap[i] = Math.max(knap[i], val[j] + knap[i - wt[j]]);
				
			}
			
		}
		
		return knap[W];
	}

}
