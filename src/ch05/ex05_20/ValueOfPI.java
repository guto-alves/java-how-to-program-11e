/* 5.20 (Calculating the Value of PI) Calculate the value of from the infinite
series
  
  			PI = 4 - (4/3) + (4/5) - (4/7) + (4/9) - (4/11) + ...
   
Print a table that shows the value of π approximated by computing the first
200,000 terms of this series. How many terms do you have to use before
you first get a value that begins with 3.14159? */

package ch05.ex05_20;

public class ValueOfPI {

	public static void main(String[] args) {
		double pi = 0;
		double oddNumber = 1;

		for (int i = 0; i < 200000; i++) {
			if (i % 2 == 0)
				pi += 4 / oddNumber;
			else
				pi -= 4 / oddNumber;

			oddNumber += 2;
		}

		System.out.printf("PI = %f", pi);
	}

}
