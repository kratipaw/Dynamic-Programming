package gfg_top20DP_InterviewQuestions;

public class _15_DiceThrowProblem {

	public static void main(String[] args) {

		//System.out.println(countWays(2, 4, 1));
		
		//System.out.println(countWays(2, 2, 3));
		
		System.out.println(countWays(3, 6, 8));
		
		//System.out.println(countWays(2, 4, 5));
		
		//System.out.println(countWays(3, 4, 5));
		
	}

	private static int countWays(int dices, int faces, int sum) {
		
		int dp[][] = new int[dices+1][sum+1];
		
		for (int i = 0; i <= dices; i++) {
			for (int j = 0; j <= sum; j++) {
				dp[i][j] = 0;
			}
		}
		
		//if only 1 dice present, then for every sum <= face, there is only 1 way. 
		for (int i = 1; i <= sum && i <= faces ; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= dices; i++) {
			
			for (int j = 1; j <= sum ; j++) {
				
				for (int k = 1; k<=faces && k < j; k++) {
					
					dp[i][j] = dp[i][j] + dp[i-1][j - k];
				}
			}
		}
		
		/*for (int i = 0; i <= dices; i++) {
			for (int j = 0; j <= sum; j++) {
				System.out.print(dp[i][j] + "   ");
			}
			System.out.println();
		}*/
		
		return dp[dices][sum];
	}
	
}
