package practice;

public class FibonnaciNumbers {

	public static void main(String[] args) {
		
		int n = 9;
		
		System.out.println("Fibonnaci number at the location " + n + " is : " + fib_byTabulation(n));
		
		System.out.println("Fibonnaci number at the location " + n + " is : " + fib_byOptimimzedTabulation(n));
	}

	
	public static int fib_byTabulation(int n) {
		
		int fib_array[] = new int[n+2];
		
		fib_array[0] = 0;
		fib_array[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			
			fib_array[i] = fib_array[i-1] + fib_array[i-2];
		}
		
		return fib_array[n];
	}
	
	public static int fib_byOptimimzedTabulation(int n) {
		
		int a = 0, b = 1;
		
		int result=-1;
		
		for (int i = 2; i <= n; i++) {
			result = a + b;
			a = b;
			b = result;
		}
		
		return result;
	}
}
