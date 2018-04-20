package utils3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils3.DynamicCoins;

class DynamicTest {

	//Testing for an array and int that have empty parameters
	@Test
	void testgetDynamicAllZeros() {
		int array[] = {0,0,0,0};
		int total = 0;
		assertEquals(0, DynamicCoins.coins(array, total));
	}
	//Testing US currency
	@Test
	void testAllUSCoinage() {
		int array[] = {25,10,5,1};
		int total = 123;
		assertEquals(9, DynamicCoins.coins(array, total));
	}
	//Calling in a custom currency
	@Test
	void testAllCustomCoinage() {
		int array[] = {20,8,2,1};
		int total = 52;
		assertEquals(5, DynamicCoins.coins(array, total));
	}
	//Another Test to see if it works
	@Test
	void testAllCustom2Coinage() {
		int array[] = {7,2,4,6};
		int total = 13;
		assertEquals(2, DynamicCoins.coins(array, total));
	}
	//If we have a size of 0 for our array then this will fail
	@Test
	void testGetEmptyArray() {
		int array[] = {};
		int total = 0;
		Exception e = assertThrows(IllegalArgumentException.class, () -> {  DynamicCoins.coins(array, total); } );
		assertEquals("Array of size 0 is not allowed", e.getMessage());

}
}
