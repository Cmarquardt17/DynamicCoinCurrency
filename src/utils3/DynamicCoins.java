package utils3;
//Authors: Christian Marquardt, Will Dean, Michael Muffoletto
//Date: 4/20/2018
//Overview: We are using Eclipse Oxygen and this is Dynamic Testing for the best case scenario
//for any coin based currency giving you the minimum amount of coins needed
//Instead of using a main method to see what the output is or even to see if it works
//We are using JUnit 5 Testing to see when we pass in different coin currencies that they work
public class DynamicCoins {
	// Static Method for Dynamic coin currencies
	public static int coins(int[] array, int total) {
		// Throw Exception for Test
		if (array.length == 0) {
			throw new IllegalArgumentException("Array of size 0 is not allowed");
		}
		// Test Array with all the spots we are testing for how many coins are
		int[] Test = new int[total + 1];
		// Result Array that has all the coin values at there certain spot
		int[] Result = new int[total + 1];
		// The initial spot is 0 because currency can't be at zero and we start at spot
		// 1
		Test[0] = 0;
		// This initializes both arrays
		for (int i = 1; i <= total; i++) {
			// All infinities because we do not know how many coins it take
			Test[i] = Integer.MAX_VALUE-1;
			// -1 because we do not know the values but we still fill the array
			Result[i] = -1;
		}
		// First for loops that goes through the currency ex. {7, 4, 3, 6}
		for (int j = 0; j < array.length; j++)
			// A for loops that goes through the Test array until the total is no more
			for (int i = 1; i <= total; i++) {
				// If our Test spot is greater than the coin then we can see if the coin works
				// for it
				if (i >= array[j]) {
					// The second if statement goes along the lines of if the test spot minus the
					// coin value +1 is..
					// than Test are spot i hen we can access this...
					// ex. we are at spot 3 and our coin is 3 Test[3-3]+1 < 3 so it works and we can
					// fill it
					if (Test[i - array[j]] + 1 < Test[i]) {
						// Here we are going to store what that spot is in the test method until it gets
						// overwritten by the..
						// next coin currency if possible to basically find best case scenario
						// ex. at Test[3] we get 1+ Test[3-3] this means it takes one coin so we put one
						// there
						Test[i] = 1 + Test[i - array[j]];
						// Now since we have established how many coins it takes we put the of the coin
						// into our result
						// We must note that while we are going through the Test array we are at the
						// same spot in the Result array
						// ex. our spot R[3] we want to store the value of that coin we can use which
						// would be 0 if we are at the...
						// first coin in the array then is would be 0
						Result[i] = j;
					}
				}
			}
		//Print Statements for the desired Output
		System.out.println("How many coins does it take dynamically for the best choice case of " + total + "?");
		System.out.println("It took: " + Test[total] + " coins!");
		System.out.println();
		// After we have gone through all the tests for all the coins we should have the
		// best result for how many coins it takes
		// And what those coins are by having the least amount of coins it would take
		return Test[total];
	}
}
