package gfg_top20DP_InterviewQuestions;

public class _17_MatrixChainMultiplication {

	public static void main(String[] args) {

		/*int arr[] = {40, 20, 30, 10, 30};
		
		System.out.println(minOperataions(arr));
		
		int arr1[] = {10, 20, 30, 40, 30};
		
		System.out.println(minOperataions(arr1));
		
		int arr2[] = {10, 20, 30};
		
		System.out.println(minOperataions(arr2));*/
		
		int arr3[] = {1, 2, 3, 4, 5, 6};
		
		System.out.println(minOperataions(arr3));
		
	}

	private static int minOperataions(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return 0;
		
		int dp[][] = new int[n][n];
		
		for (int i = 1; i < n; i++) {
			dp[i][i] = 0;
		}
		
		for (int len = 2; len < n; len++) {
			
			for (int i = 1; i < n - len + 1; i++) {
				
				int j = i + len - 1;
				
				if(j == n)
					continue;
				
				dp[i][j] = Integer.MAX_VALUE;
				
				for (int k = i; k <= j -1 ; k++) {
					
					int min = dp[i][k] + dp[k+1][j] + (arr[i-1]*arr[k]*arr[j]);
					
					if(min < dp[i][j])
						dp[i][j] = min;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		
		return dp[1][n-1];
	}
	
}
