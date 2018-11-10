package gfg_top20DP_InterviewQuestions;

/**
 * Partition problem is to determine whether a given set can be partitioned into 
 * two subsets such that the sum of elements in both subsets is same.
 * 
 * Examples:
 * 
 * arr[] = {1, 5, 11, 5}
 * Output: true 
 * The array can be partitioned as {1, 5, 5} and {11}
 * 
 * arr[] = {1, 5, 3}
 * Output: false 
 * The array cannot be partitioned into equal sum sets.
 * 
 * ALGORITHM :
 * 
 * Following are the two main steps to solve this problem:
 * 1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, 
 * 		so return false.
 * 2) If sum of array elements is even, calculate sum/2 and find a subset of array with 
 * 		sum equal to sum/2. (SUBSET SUM PROBLEM)
 * 
 */

public class _11_PartitionProblem {

	public static void main(String[] args) {

		//int arr[] = {1, 5, 11, 5};
		
		int arr[] = {1, 5, 3};
		
		System.out.println(hasPartition(arr));
		
	}
	
	private static boolean hasPartition(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return false;
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		
		if(sum%2 != 0)
			return false;
		
		return isSubSetSum(arr, sum/2);
		
	}
	
	private static boolean isSubSetSum(int arr[], int sum) {
		
		int n = arr.length;
		
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

		return sub[sum][bi];
	}
	
}
