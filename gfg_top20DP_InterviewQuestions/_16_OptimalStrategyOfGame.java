package gfg_top20DP_InterviewQuestions;

/**
 * Consider a row of n coins of values v1 . . . vn, where n is even. 
 * We play a game against an opponent by alternating turns. 
 * In each turn, a player selects either the first or last coin from the row, 
 * removes it from the row permanently, and receives the value of the coin. 
 * Determine the maximum possible amount of money we can definitely win if we move first.
 * Note: The opponent is as clever as the user.
 * 
 * Examples : 
 * 
 * 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)
 * 
 * 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)
 *  
 * Does choosing the best at each move give an optimal solution?
 * 
 * No. In the second example, this is how the game can finish:
 * 
 * 1.
 * …….User chooses 8.
 * …….Opponent chooses 15.
 * …….User chooses 7.
 * …….Opponent chooses 3.
 * Total value collected by user is 15(8 + 7)
 * 
 * 2.
 * …….User chooses 7.
 * …….Opponent chooses 8.
 * …….User chooses 15.
 * …….Opponent chooses 3.
 * Total value collected by user is 22(7 + 15)
 * 
 * So if the user follows the second game state, maximum value can be collected although 
 * the first move is not the best.
 * 
 * There are two choices:
 * 1. The user chooses the ith coin with value Vi: 
 * The opponent either chooses (i+1)th coin or jth coin. 
 * The opponent intends to choose the coin which leaves the user with minimum value.i.e. 
 * The user can collect the value Vi + min(F(i+2, j), F(i+1, j-1) )
 * 
 * 2. The user chooses the jth coin with value Vj: 
 * The opponent either chooses ith coin or (j-1)th coin. 
 * The opponent intends to choose the coin which leaves the user with minimum value.i.e. 
 * The user can collect the value Vj + min(F(i+1, j-1), F(i, j-2) )
 * 
 * Following is recursive solution that is based on above two choices. 
 * We take the maximum of two choices.
 * 
 * F(i, j)  represents the maximum value the user can collect from 
 *          i'th coin to j'th coin.
 * 
 *     F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), 
 *                    Vj + min(F(i+1, j-1), F(i, j-2) )) 
 * Base Cases:
 *     F(i, j)  = Vi           If j == i
 *     F(i, j)  = max(Vi, Vj)  If j == i+1
 * 
 * 
 */

public class _16_OptimalStrategyOfGame {

	public static void main(String[] args) {

		int arr[] = {8, 15, 3, 7};
		
		System.out.println(optimalStrategyToMaxValue(arr));
		
		int arr1[] = { 2, 2, 2, 2 };
		
		System.out.println(optimalStrategyToMaxValue(arr1));
		
		int arr2[] = { 20, 30, 2, 2, 2, 10 };
		
		System.out.println(optimalStrategyToMaxValue(arr2));
		
	}
	
	private static int optimalStrategyToMaxValue(int arr[]) {
		
		int n = arr.length;
		
		int dp[][] = new int[n][n];
		
		for (int gap = 0; gap < n; gap++) { 
            for (int i = 0, j = gap; j < n; i++, j++) { 
                
                int x = ((i + 2) <= j) ? dp[i + 2][j] : 0; 
                //System.out.println("x: " + x);
                int y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
               //System.out.println("y : " + y);
                int z = (i <= (j - 2)) ? dp[i][j - 2] : 0; 
                //System.out.println("z: " + z);
                //System.out.println("dp[i][j]" + i + ", " + j);
                dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z)); 
                
                //System.out.println("dp[i][j] : " + dp[i][j]);
            } 
        } 
		
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}*/
		
		
		return dp[0][n-1];
		
	}

}
