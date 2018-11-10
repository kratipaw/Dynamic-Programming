package gfg_top20DP_InterviewQuestions;

/**
 * Minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Operations allowed are : Insertion, Remove, Replace
 */

public class _5_EditDistance {

	public static void main(String[] args) {

		String str1 = "";
		
		String str2 = "";
		
		System.out.println(editDistance_recur(str1, str2, str1.length(), str2.length()));
		
		System.out.println(editDistance_viaDP(str1, str2));
		
	}

	private static int editDistance_recur(String str1, String str2, int m, int n) {
		
		if(m == 0)
			return n;
		
		if(n == 0)
			return m;
		
		if(str1.charAt(m-1) == str2.charAt(n-1))
			return editDistance_recur(str1, str2, m-1, n-1); 
		
		return 1 + Math.min(editDistance_recur(str1, str2, m, n-1), //Insert
				Math.min(editDistance_recur(str1, str2, m-1, n-1),  //Replace
						editDistance_recur(str1, str2, m-1, n)));   //Delete or Remove
		
	}
	
	private static int editDistance_viaDP(String str1, String str2) {
		
		int m = str1.length();
		
		int n = str2.length();
		
		int tab[][] = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			
			for (int j = 0; j <= n; j++) {
				
				if(i == 0)
					tab[i][j] = j;
				
				else if(j == 0)
					tab[i][j] = i;
				
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					tab[i][j] = tab[i-1][j-1];
				
				else
					tab[i][j] = 1 + Math.min(tab[i][j-1], Math.min(tab[i-1][j-1], tab[i-1][j]));
			}
			
		}
		
		return tab[m][n];
	}
	
}
