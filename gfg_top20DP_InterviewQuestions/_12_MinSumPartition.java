package gfg_top20DP_InterviewQuestions;

/**
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that 
 * the absolute difference between their sums is minimum.
 * 
 * If there is a set S with n elements, then if we assume Subset1 has m elements, 
 * Subset2 must have n-m elements and 
 * the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * 
 * Example:
 * 
 * Input:  arr[] = {1, 6, 11, 5} 
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12 
 * Subset2 = {11}, sum of Subset2 = 11
 * 
 */

public class _12_MinSumPartition {

	public static void main(String[] args) {

		int arr[] = {3, 1, 4, 2, 2, 1};
		
		System.out.println(getMinDiffBtwPartitions(arr));
		
	}
	
	private static int getMinDiffBtwPartitions(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return 0;
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		
		boolean sub[][] = new boolean[sum+1][2];
		
		int bi = 0;
		
		for (int i = 0; i <= sum ; i++) {
			
			for (int j = 0; j <= n; j++) {
				
				bi = j & 1;
				
				if(i == 0)
					sub[i][bi] = true;
				
				else if(j == 0)
					sub[i][bi] = false;
				
				else if(i < arr[j-1])
					sub[i][bi] = sub[i][1-bi];
				
				else
					sub[i][bi] = sub[i][1-bi] || sub[i-arr[j-1]][1-bi];
				
			}
		}

		int diff = Integer.MAX_VALUE;
		
		for (int i = sum/2; i >= 0 ; i--) {
			  
            if (sub[i][bi] == true) 
            { 
                diff = sum - 2 * i; 
                break; 
            } 
		}
		
		return diff;
		
	}
	
}
