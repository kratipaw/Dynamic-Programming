package gfg_top20DP_InterviewQuestions;

/**
* Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
* Examples :
*
* Input:  n = 3
* Output: 4
* Below are the four ways
*  1 step + 1 step + 1 step
*  1 step + 2 step
*  2 step + 1 step
*  3 step
*
* Input:  n = 4
* Output: 7
*/

public class _13_WaysToCoverADistance {

	public static void main(String[] args) {
		
		int dist = 4;

        System.out.println(countWays_recur(dist));

        System.out.println(countWays_viaDP(dist));

	}
	
	 //TC = O(3^dist)

    private static int countWays_recur(int dist)
    {
       if(dist < 0)
          return 0;

       if(dist == 0)
          return 1;

       return countWays_recur(dist-1) + countWays_recur(dist-2) + countWays_recur(dist-3);
    }

    private static int countWays_viaDP(int n)
    {
    	//dp[i] stores number of ways to cover distance i with 1, 2 or 3 steps
        int dp[] = new int[n+1];
        
        dp[0] = 1;
        
        dp[1] = 1;
        
        dp[2] = 2;
        
        for (int i = 3; i <= n ; i++) {
        	dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[n];
    }

}
