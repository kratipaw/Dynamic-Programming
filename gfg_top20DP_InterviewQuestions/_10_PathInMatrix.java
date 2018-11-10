package gfg_top20DP_InterviewQuestions;

/**
 * Given a n*n matrix where all numbers are distinct, 
 * find the maximum length path (starting from any cell) such that all cells along the path 
 * are in increasing order with a difference of 1.
 * 
 * We can move in 4 directions from a given cell (i, j), i.e., 
 * we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) 
 * with the condition that the adjacent cells have a difference of 1.
 * 
 * Example:
 * 
 * Input:  mat[][] = {{1, 2, 9}
 *                    {5, 3, 8}
 *                    {4, 6, 7}}
 * Output: 4
 * The longest path is 6-7-8-9.
 *  
 */

public class _10_PathInMatrix {

	public static void main(String[] args) {

		int matrix[][] = {{1, 2, 9},
						 {5, 3, 8},
		                 {4, 6, 7}};
		
		System.out.println(longestPathInMatrix(matrix, matrix.length));
	}
	
	private static int longestPathInMatrix(int matrix[][], int n) {
		
		int result = 1;
		
		int dp[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(dp[i][j] == -1)
					helper(i, j, n, matrix, dp);
				
				result = Math.max(result, dp[i][j]);
			}
		}
		
		return result;
		
	}
	
	private static int helper(int i, int j, int n, int matrix[][], int dp[][]) {
		
		if(i < 0 || i >= n || j < 0 || j >= n)
			return 0;
		
		if(dp[i][j] != -1)
			return dp[i][j];
		
		//right to given cell i.e. i, j+1
		if(j < n-1 && ((matrix[i][j] +1) == matrix[i][j+1]))
			return dp[i][j] = 1 + helper(i, j+1, n, matrix, dp);
		
		//left to given cell i.e. i, j-1
		if(j > 0 && ((matrix[i][j] + 1) == matrix[i][j-1]))
			return dp[i][j] = 1 + helper(i, j-1, n, matrix, dp);
		
		//Above given cell i.e. i-1, j
		if(i > 0 && ((matrix[i][j] + 1) == matrix[i-1][j]))
			return dp[i][j] = 1 + helper(i-1, j, n, matrix, dp);
		
		//below given cell i.e. i+1, j
		if(i < n-1 && (matrix[i][j] + 1) == matrix[i+1][j])
			return dp[i][j] = 1 + helper(i+1, j, n, matrix, dp);
		
		//IF NONE of above i.e. none of adjacent cells is one greater then 
		return dp[i][j] = 1;
	}

}
