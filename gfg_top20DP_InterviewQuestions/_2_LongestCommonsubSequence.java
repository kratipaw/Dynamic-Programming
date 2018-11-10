package gfg_top20DP_InterviewQuestions;

public class _2_LongestCommonsubSequence {

	public static void main(String[] args) {

		/*String X = "ADGHYB";
		String Y = "SDFJGNB";
		*/
		
		String X = "bbcdef";
		String Y = "fedcbb";
		
		System.out.println(lcs_recur(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));
	
		System.out.println(lcs_viaDP(X.toCharArray(), Y.toCharArray()));
	
		System.out.println(lcs_DP_optimized(X.toCharArray(), Y.toCharArray()));
		
	}
	
	private static int lcs_recur(char X[], int xLen, char Y[], int yLen) {
		
		if(xLen == 0 || yLen == 0)
			return 0;
		
		if(X[xLen-1] == Y[yLen-1])
			return 1 + lcs_recur(X, xLen-1, Y, yLen-1);
		else
			return Math.max(lcs_recur(X, xLen, Y, yLen-1), lcs_recur(X, xLen-1, Y, yLen));
		
	}

	private static int lcs_viaDP(char X[], char Y[]) {
		
		int x = X.length;
		
		int y = Y.length;
		
		int lcs[][] = new int[x+1][y+1];
		
		for (int i = 0; i <= x; i++) {
			
			for (int j = 0; j <= y; j++) {
				
				if(i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (X[i-1] == Y[j-1])
					lcs[i][j] = 1 + lcs[i-1][j-1];
				else
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
			}
		}
		
		return lcs[x][y];
	}
	
	private static int lcs_DP_optimized(char X[], char Y[]) {
		
		int x = X.length;
		
		int y = Y.length;
		
		int lcs[][] = new int[2][y+1];
		
		int bi = 0;
		
		for (int i = 0; i <= x; i++) {
			
			bi = i & 1;
			
			for (int j = 0; j <= y; j++) {
				
				if(i == 0 || j == 0)
					lcs[bi][j] = 0;
				else if (X[i-1] == Y[j-1])
					lcs[bi][j] = 1 + lcs[1 - bi][j];
				else
					lcs[bi][j] = Math.max(lcs[bi][j-1], lcs[1-bi][j]);
				
			}
		}
		
		return lcs[bi][y];
	}
	
}
