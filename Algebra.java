// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus( -1, 1));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-2,-3));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int i = 0;
		if (x1 < 0) {
			if (x2 < 0) {
				while (i > x2) {
					x1--;
					i--;
				}
			} else { 
				while (i < x2) {
					x1++;
					i++;
				}
			}
		} else { 
			if (x2 < 0) { 
				while (i > x2) {
					x1--;
					i--;
				}
			} else { 
				while (i < x2) {
					x1++;
					i++;
				}
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int i = 0;
		if (x1 < 0) {
			if (x2 < 0) {
				while (i < Math.abs(x2)) {
					x1++;
					i++;
				}
			} else { 
				while (i < x2) {
					x1--; 
					i++;
				}
			}
		} else { 
			if (x2 < 0) {
				while (i < Math.abs(x2)) {
					x1++; 
					i++;
				}
			} else { 
				while (i < x2) {
					x1--; 
					i++;
				}
			}
		}
		return x1;
	}
		
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int i = 0;
		int total = 0;
		boolean isNegative = (x1 < 0 && x2 >= 0) || (x2 < 0 && x1 >= 0);
		if (x1 < 0) {
			x1 = -x1; 
		}
		if (x2 < 0) {
			x2 = -x2; 
		}
		while (i < x2) {
			total = plus(total, x1); 
			i++;
		}
		if (isNegative) {
			total = -total;
		}
		return total;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i = 0; 
		int total = 1; 
		while (i < n) {
			total = times(total, x);
			i++; 
		}
		return total;
	}
	
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i = 0;
		int total = 0;
		boolean isNegative = (x1 < 0 && x2 >= 0) || (x2 < 0 && x1 >= 0);
		if (x1 < 0) {
			x1 = -x1; 
		}
		if (x2 < 0) {
			x2 = -x2; 
		}
		while (total + x2 <= x1) {
			total = plus(total, x2);  
			i++; 
		}
		if (isNegative) {
			i = -i;
		}
		return i;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) {
			return 0;
		}
		int quotient = div(x1, x2);  
		int product = times(quotient, x2);
		int remainder = minus(x1, product);
		if (remainder < 0) {
			remainder = plus(remainder, x2); 
		}
	
		return remainder;
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		int low = 1, high = x;
		int result = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2; 
			int midSquared = times(mid, mid); 
			if (midSquared == x) {
				return mid; 
			} else if (midSquared < x) {
				low = mid + 1; 
				result = mid; 
			} else {
				high = mid - 1; 
			}
		}
		return result;
	} 
}