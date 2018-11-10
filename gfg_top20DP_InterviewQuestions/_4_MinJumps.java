package gfg_top20DP_InterviewQuestions;

public class _4_MinJumps {

	public static void main(String[] args) {

		//int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		
		int arr[] = {1, 2, 1, 0, 1, 1, 1};
		
		System.out.println(minJumps_viaDP(arr));
		
		System.out.println(minJumps_optimized(arr));
		
	}

	private static int minJumps_viaDP(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0 || arr[0] == 0)
			return 0;
		
		int jumps[] = new int[n];
		
		jumps[0] = 0;
		
		for (int i = 1; i < n; i++) {
			
			jumps[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < i; j++) {
				
				if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				
			}
			
		}
		
		return jumps[n-1];
	}
	
	private static int minJumps_optimized(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0 || arr[0] == 0)
			return -1;

		if(n == 1)
			return 0;
		
		int maxReach = arr[0];
		
		int step = arr[0];
		
		int jump = 1;
		
		for (int i = 1; i < n; i++) {
			
			if(i == n-1)
				return jump;
			
			maxReach = Math.max(maxReach, i+arr[i]);
			
			step--;
			
			if(step == 0) {
				
				jump++;
				
				if(i>=maxReach) {
					System.out.println("end");
					return -1;
				}
				step = maxReach - i;
				
			}
			
		}
		
		return -1;
	}
}
