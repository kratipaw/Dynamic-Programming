package gfg_top20DP_InterviewQuestions;

public class _7_SubsetSumProblem {

	public static void main(String[] args) {

		int set[] = {3, 34, 4, 12, 5, 2};
		
		int sum = 9;
		
		System.out.println(isSubset_recur(set, set.length, sum));
		
		System.out.println(isSubset_viaDP(set, sum));
		
		System.out.println(isSubset_DP_SpcOptimized(set, sum));
		
	}

	private static boolean isSubset_recur(int set[], int n, int sum) {
		
		if(sum == 0)
			return true;
		
		if(n == 0 && sum != 0)
			return false;
		
		if(set[n-1] > sum)
			return isSubset_recur(set, n-1, sum);
		
		return isSubset_recur(set, n-1, sum) || isSubset_recur(set, n-1, sum-set[n-1]);
		
	}
	
	private static boolean isSubset_viaDP(int set[], int sum) {
		
		int n = set.length;
		
		//sub[i][j] stores either true or false according to if 0..j-1 has subset with sum i then sub[i][j] is true
		boolean sub[][] = new boolean[sum+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			sub[0][i] = true;
		}
		
		for (int i = 0; i <= sum; i++) {
			sub[i][0] = false;
		}
		
		for (int i = 1; i <= sum; i++) {
			
			for (int j = 1; j <= n; j++) {
				
				sub[i][j] = sub[i][j-1];
				
				if(i >= set[j-1])
					sub[i][j] = sub[i][j] || sub[i-set[j-1]][j-1];
				
			}
			
		}
		
		return sub[sum][n];
	}
	
	private static boolean isSubset_DP_SpcOptimized(int set[], int sum) {
		
		 int n = set.length;

         if(n == 0 && sum == 0)
                return true;

         if(n == 0)
        	 return false;

         boolean sub[][] = new boolean[sum+1][2];

         int bi = 0;

         for (int i = 0; i <= sum; i++) {

            for (int j = 0; j <= n; j++) {

                  bi = j & 1;

                  if(i == 0)
                	  sub[i][bi] = true;

                  else if(j == 0)
                      sub[i][bi] = false;

                  else if(i >= set[j-1])
                      sub[i][bi] = sub[i][1-bi] || sub[i - set[j-1]][1-bi];

                  else
                      sub[i][bi] = sub[i][1-bi];

            }

         }

         return sub[sum][bi];
	}
	
}
