//=========
//RECURSION
//=========

//In this lab, we practice some of well-known algorithms
//in recursive or/and non-recursive (i.e., iterative) version(s).

//------
//TASKS:
//------
//
//(1) Implement all the required methods in a java class,
//    called "RecursionAnswer.java".
//    ==> Let's add "public" access modifier to every method.
//    ==> Implement every to be a class method.
//    ==> Correct any possible errors (Hint: change method's signature).
//
//(2) Implement main() for all the methods.
//    ==> public static void main(String []args)
//    ==> Test what each method returns.

import java.util.Scanner;


public class RecursionAnswer {

	public static int fact1(int n) // COMPLETE
	{
		if (n == 0)
		{
			return 1;
		}// end if
		else
		{
			return (n * fact1(n-1));
		} //end else
  } //end fact1


	public static int fact2(int n)
	{
		int result = 1;
		if (n == 0)
		{
			return result; // do nothing (i.e. result = 1)
		}

		else
		{
			for (int i = 2; i <= n; i++){
				 result *= i;
			} //end for
		} //end else
		return result;
	}

	// --------------------------------------------------------
	// Writes a character string backward.
	// Precondition:
	//		The string s contains size characters, where size >= 1.
	// Postcondition:
	//		s is written backward, but remains unchanged.
	// --------------------------------------------------------


	public static void writeBackward(String s, int size)
	{  // base case
		if(size == 1)
		{
			System.out.print(s.charAt(0));
	    }
		// else, write rest of string
		else if (size > 1)
		{
			System.out.print(s.charAt(size-1));
			writeBackward(s, size - 1);
		}
	   // else size <= 0, do nothing;
	} // end writeBackward



	public static void writeBackward1(String s, int size)
	{
		if (size > 0){
			System.out.print(s.substring(size-1, size));
			writeBackward(s, size - 1);
		}
	}


	public static void writeBackward2(String s, int size)
	{
		while (size > 0){
			System.out.print(s.substring(size-1, size));
			--size;
		}
	}


	public static void writeBackward3(String s)
	{
		for (int i = s.length()-1; i>= 0; i--)
			System.out.print(s.charAt(i));
		System.out.println();
	}



public static void writeBackward4(String s, int size)
	{
		for (int i = size-1; i>= 0; i--)
			System.out.print(s.charAt(i));
		System.out.println();
	}

	//------------------------------------------------------
	// Evaluate the sum of the first n integers
	//
	// sum = 1				if n == 1
	// sum = n + sum(n-1)	if n > 1;
	//------------------------------------------------------


	public static int sum1(int n)
	{
		if (n == 1)
		{
			return 1;
		}

		else
		{
			return (n + sum1(n-1));
		}
	}


	public static int sum2(int n)
	{
		int result = 0;
		for (int i = 1; i <= n; i++)
			result += i;
		return result;
	}

	//---------------------------------------------------
	// Evaluate the sum of the integers in a given range
	//	(i.e., from start to end)
	//---------------------------------------------------


	public static int rangeSum1(int [] array, int start, int end)
	{
		if (start > end)
			return 0;
		else
			return array[start] + rangeSum1(array, start + 1, end);
	}


	public static int rangeSum2(int [] array, int start, int end)
	{
		int sum = 0;
		for (int i = start; i <= end; i++)
			sum += array[i];
		return sum;
	}

	//---------------------------------------------------
	// fib(n) = 0						if n == 0
	// fib(n) = 1						if n == 1
	// fib(n) = fib(n-1) + fib(n-2)		if >= 2
	//---------------------------------------------------


	public static int fib1(int n)
	{
		if (n == 0)
		{
			return n;
		}

		else if (n == 1)
		{
			return n;
		}
		else
		{
			return (fib1(n-1) + fib1(n-2));
		}
	}

	public static int fib2(int n) //use iteration
	{
		int x = 1;
		int y = 1;
		int z = 2;

		if (n == 1 || n == 2)
		{
			 return 1;
		}

		for (int i = 2; i <= n; i++)
		{
			x = y;
			y = z;
			z = x+y;
		}

		return x;

	}

	public static int fib3(int n)
	{
		int[] array = new int[n+1];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i <= n; i++){
			array[i]=array[i-1]+array[i-2];
		}
		return array[array.length - 2];
	}


	public static int acker(int m, int n)
	{
		if (m == 0)
		{
			return n+1;
		}

		else if (n == 0)
		{
			return acker(m-1, 1);
		}
		else
		{
			return acker(m-1, acker(m, n-1));
		}
	}

	public static int gcd(int a, int b)
	{
		if (a % b == 0){
			return b;
	    }
		else{
			return gcd(b, (a % b));
	    }
	}

	public static int c(int n, int k)
	{
		if ((k == 0) || (k == n))
		{
			return 1;
		}

		else if (k > n)
		{
			return 0;
		}

		else
		{
			return (c( n - 1, k - 1) + c(n - 1, k));
		}

	}

	public static void main(String [] args)
	{
		String str = new String("Jaken Herman");
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int m = 3;
		int n = array.length;
		int e = array.length - 1;



		System.out.println("Test fact(int n):");
		System.out.println("\tfact1(" + n + ") = " + fact1(n));
		System.out.println("\tfact2(" + n + ") = " + fact2(n));

		System.out.println("Test WriteBackward(String str, int size):");

		System.out.print("\twriteBackward("+str+",9)= ");
		writeBackward(str, 9);
		System.out.println();
		System.out.println("\twriteBackward1(\"Jaken Herman\",9)= ");
		writeBackward1(str, 9);
		System.out.println();
		System.out.println("\twriteBackward2(\"Jaken Herman\",9)= ");
		writeBackward2(str, 9);
		System.out.println();
		System.out.println("\twriteBackward3(\"Jaken Herman\",9)= ");
		writeBackward3(str);
		System.out.println("\twriteBackward4(\"Jaken Herman\",9)= ");
		writeBackward4(str, 9);
		System.out.println();
		System.out.println("Test sum(int n):");
		System.out.println("\tsum1(10) = " + sum1(10));
		System.out.println("\tsum2(10) = " + sum2(10));
		System.out.println("Test rangeSum(int array, int m, int e):");
		System.out.println("\trangeSum1(array, m, e) = " + rangeSum1(array, m, e));
		System.out.println("\trangeSum2(array, m, e) = " + rangeSum2(array, m, e));
		System.out.println("Test fib(int n): ");
		System.out.println("\tfib1(1) = "+fib1(1));
		System.out.println("\tfib2(1) = "+fib2(1));
		System.out.println("\tfib3(1) = "+fib3(1));
		System.out.println("\tfib1(2) = "+fib1(2));
		System.out.println("\tfib2(2) = "+fib2(2));
		System.out.println("\tfib3(2) = "+fib3(2));
		System.out.println("\tfib1(10) = "+fib1(n));
	    System.out.println("\tfib2(10) = "+fib2(n));
		System.out.println("\tfib3(10) = "+fib3(n));
		System.out.println("Test acker(int m, int n):");
		System.out.println("\tacker(0, 10) = " + acker(0, 10));
		System.out.println("\tacker(3, 0) = " + acker(3, 0));
		System.out.println("\tacker(3, 10) = " + acker(3, 10));
		System.out.println("Test gcd(m, n):");
		System.out.println("\tgcd(3, 10) = " + gcd(3, 10));
		System.out.println("Test c(n, m):");
		System.out.println("\tc(10,3) = " + c(10, 3));
	}


}
