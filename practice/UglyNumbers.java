package practice;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, � shows the first 11 ugly numbers. 
 * By convention, 1 is included.
 */

public class UglyNumbers {

	public static void main(String[] args) {

		int n = 10;
		
		System.out.println("n-th ugly number is (by brute force ): " +  getNthUgleNumber_bruteForce(n));
		
		System.out.println("n-th ugly number is (by DP ): " + getNthUglyNumber_Optimized(n));
	}

	private static int getNthUgleNumber_bruteForce(int n)
	{
		int i = 1;
		
		int count=1;
		
		while(n > count)
		{
			i++;
			
			if(isUgly(i))
				count++;
			
		}
		
		return i;
	}
	
	private static int divide(int a, int b)
	{
		while(a%b == 0)
		{
			a = a/b;
		}
		return a;
	}
	
	private static boolean isUgly(int num)
	{
		num = divide(num, 2);
		num = divide(num, 3);
		num = divide(num, 5);
		
		if(num == 1)
			return true;
		else
			return false;
	}
	
	//Via DP - tabulation
	//TC = O(n) where n is nth ugly number
	//SC = O(n)
	private static int getNthUglyNumber_Optimized(int n)
	{
		int ugly[] = new int[n];
		
		int i = 0, j = 0, k = 0;
		
		int next_of_2 = 2;
		int next_of_3 = 3;
		int next_of_5 = 5;
		
		int ugly_number = 1;
		
		ugly[0] = ugly_number;
		
		for (int l = 1; l < ugly.length; l++) {
			
			ugly_number = Math.min(next_of_2, Math.min(next_of_3, next_of_5));
			
			ugly[l] = ugly_number;
			
			if(ugly_number == next_of_2)
			{
				i++;
				next_of_2 = ugly[i] * 2;
			}
			else if(ugly_number == next_of_3)
			{
				j++;
				next_of_3 = ugly[j]*3;
			}
			else if (ugly_number == next_of_5)
			{
				k++;
				next_of_5 = ugly[k] * 5;
			}
		}
		/*
		for (int l = 0; l < ugly.length; l++) {
			System.out.print(ugly[l] + "  ");
		}
		System.out.println();
		*/
		return ugly_number;
	}
}
