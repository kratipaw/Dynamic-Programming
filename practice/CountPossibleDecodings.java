package practice;

/**
 * Let 1 represent ‘A’, 2 represents ‘B’, etc. 
 * Given a digit sequence, count the number of possible decodings of the given digit sequence.
 * Examples:
 * 
 * Input:  digits[] = "121"
 * Output: 3
 * // The possible decodings are "ABA", "AU", "LA"
 * 
 * Input: digits[] = "1234"
 * Output: 3
 * // The possible decodings are "ABCD", "LCD", "AWD"
 * 
 * An empty digit sequence is considered to have one decoding. 
 * It may be assumed that the input contains valid digits from 0 to 9 and 
 * there are no leading 0’s, no extra trailing 0’s and no two or more consecutive 0’s.
 */

public class CountPossibleDecodings {

	public static void main(String[] args) {

		char digits[] = {'1', '2', '2', '4'}; 
		
		System.out.println(count_recur(digits, digits.length));
		
		System.out.println(count_viaDP(digits));
		
	}

	private static int count_recur(char digits[], int n) {
		
		if(n == 0 || n == 1)
			return 1;
		
		int count = 0;
		
		if(digits[n - 1] > '0')
			count = count_recur(digits, n-1);
		
		if(digits[n-2] == '1' || digits[n-2] == '2' && digits[n-1] < '7')
			count = count + count_recur(digits, n-2);
		
		
		return count;
		
	}
	
	private static int count_viaDP(char digits[]) {
		
		int n = digits.length;
		
		if(n == 0 || n == 1)
			return 1;
		
		//count[i] stores the number of valid decodings we can get from 0...i digits
		int count[] = new int[n+1];
		
		count[0] = 1;
		count[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			
			if(digits[i-1] > '0' && digits[i-1] <= '9')
				count[i] = count[i-1];
			
			if(digits[i-2] == '1' || (digits[i-2] == '2' && digits[i-1] < '7'))
				count[i] = count[i] + count[i-2];
			
		}
		
		return count[n];
	}
	
}
