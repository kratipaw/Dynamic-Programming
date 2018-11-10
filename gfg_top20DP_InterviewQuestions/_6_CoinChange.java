package gfg_top20DP_InterviewQuestions;

import java.util.Arrays;

public class _6_CoinChange {

	public static void main(String[] args) {

		int coins[] = {1, 2, 3}; 
		
		int sum = 4;
		
		System.out.println(countWays_recur(coins, coins.length, sum));
		
		System.out.println(countWays_viaDP(coins, sum));
		
	}
	
	private static int countWays_recur(int coins[], int size, int sum) {
		
		if(sum == 0)
			return 1;
		
		if(sum < 0)
			return 0;
		
		if(size <= 0 && sum > 0)
			return 0;
		
		return countWays_recur(coins, size-1, sum) + countWays_recur(coins, size, sum-coins[size-1]);
		
	}
	
	private static int countWays_viaDP(int coins[], int sum) {
		
		int n = coins.length;
		
		//tab[i] stores number of solutions possible for sum 'i'
		int tab[] = new int[sum+1];
		
		Arrays.fill(tab, 0);
		
		tab[0] = 1;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = coins[i]; j <= sum; j++) {
				
				tab[j] = tab[j] + tab[j-coins[i]];
			}
		}
		
		return tab[sum];
	}

}
