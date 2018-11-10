package gfg_top20DP_InterviewQuestions;

import java.util.Arrays;

public class _1_LongestIncreasingSubSequence {

	public static void main(String[] args) {
		
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		
		System.out.println(lis_viaDP(arr));

		System.out.println(lis_optimized(arr));
	}

	//TC = O(n^2), SC = O(n)
	private static int lis_viaDP(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return 0;
		
		int lis[] = new int[n];
		
		Arrays.fill(lis, 1);
		
		for (int i = 1; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			
			if(max < lis[i]) {
				max = lis[i];
			}
			
		}
		
		return max;
	}
	
	private static int lis_optimized(int arr[]) {
		
		int n = arr.length;
		
		int lis[] = new int[n];
		
		lis[0] = arr[0];
		
		int len = 1;
		
		for (int i = 1; i < n; i++) {
			
			if(arr[i] < lis[len-1]) 
				lis[0] = arr[i];
			
			else if (arr[i] > lis[len-1]) {
				lis[len] = arr[i];
				len++;
			}
			
			else {
				
				int idx = getIndex(lis, arr[i]);
				arr[idx] = arr[i];
			}
		}
		
		return len;
	}
	
	private static int getIndex(int arr[], int key) {
		
		int left = 0;
		
		int right = arr.length;
		
		while(left<right) {
			
			int mid = left + (right-left)/2;
			
			if(arr[mid]>=key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return right;
	}
}
