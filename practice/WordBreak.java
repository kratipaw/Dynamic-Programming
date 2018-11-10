package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	Note:
	
	The same word in the dictionary may be reused multiple times in the segmentation.
	You may assume the dictionary does not contain duplicate words.
	Example 1:
	
	Input: s = "leetcode", wordDict = ["leet", "code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	Example 2:
	
	Input: s = "applepenapple", wordDict = ["apple", "pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	             Note that you are allowed to reuse a dictionary word.
	Example 3:
	
	Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output: false
 */

public class WordBreak {

	public static void main(String[] args) {

		/*List<String> wordDict = new ArrayList<>();
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		
		String s = "catsandog";
		*/
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("pen");
		
		String s = "applepenapple";
		
		System.out.println(new WordBreak().wordBreak_recur(s, wordDict));
		
		System.out.println(new WordBreak().wordBreak_viaDP(s, wordDict));
		
		System.out.println(new WordBreak().wordBreak_better(s, wordDict));
	}
	
	//Recursively
	public boolean wordBreak_recur(String s, List<String> wordDict) {
		return wordBreakHelper(s, wordDict, 0);
    }
	
	public boolean wordBreakHelper(String s, List<String> wordDict, int startIdx) {
		
		if(startIdx == s.length())
			return true;
		
		for (int i = 0; i < wordDict.size(); i++) {
			
			String tmp = wordDict.get(i);
			int n = tmp.length();
			int end = startIdx + n;
			
			if(end > s.length())
				continue;
			
			if(s.substring(startIdx, end).equals(tmp)) {
				if (wordBreakHelper(s, wordDict, end)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean wordBreak_viaDP(String s, List<String> wordDict) {
		
		int n = s.length();
		
		if(n == 0)
			return true;
		
		boolean dp[] = new boolean[n + 1];
		
		dp[0] = true; //Here dp[i] is true if 's' can be broken into parts 0-i & i-1 and both the sub-strings present in dict 
		
		for (int i = 0; i < n; i++) {
			
			if(!dp[i])
				continue;
			
			for(String word : wordDict) {
				
				int len = word.length();
				
				int end = i + len;
				
				if(end > n)
					continue;
				
				if(dp[end])
					continue;
				
				if(s.substring(i, end).equals(word))
					dp[end] = true;
			}
		}
		
		return dp[n];
	}
	
	public boolean wordBreak_better(String s, List<String> wordDict) {
		
		int n = s.length();
		
		if(n == 0)
			return true;
		
		int res[] = new int[n + 1];
		
		Arrays.fill(res, -1);
		
		res[0] = 0; 
		
		for (int i = 0; i < n; i++) {
			
			if(res[i] != -1) {
				
				for (int j = i + 1; j <= n; j++) {
					
					String tmp = s.substring(i, j);
					if(wordDict.contains(tmp))
						res[j] = i;
				}
			}
		}
		
		return res[n] != -1;
	}

}
