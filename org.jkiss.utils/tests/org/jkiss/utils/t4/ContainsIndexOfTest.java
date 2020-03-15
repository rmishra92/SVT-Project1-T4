package org.jkiss.utils.t4;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import org.jkiss.utils.ArrayUtils;
import org.junit.Before;

public class ContainsIndexOfTest {
	class O1 {
		@Override
		public boolean equals(Object o1) {
			return (o1 instanceof O1);
		}
	}

	class O2 {
		@Override
		public boolean equals(Object o2) {
			return (o2 instanceof O2);
		}
	}

	class O3 {
		@Override
		public boolean equals(Object o3) {
			return (o3 instanceof O3);
		}
	}

	class O4 {
		@Override
		public boolean equals(Object o4) {
			return (o4 instanceof O4);
		}
	}

	class O5 {
		@Override
		public boolean equals(Object o5) {
			return (o5 instanceof O5);
		}
	}

	class O6 {
		@Override
		public boolean equals(Object o6) {
			return (o6 instanceof O6);
		}
	}

	private short[] shortArray;
	private int[] intArray;
	private long[] longArray;
	private char[] charArray;
	private Object[] objectArray;
	private String[] stringArray;
	private Object[] valueArray;

	@Before
	public void setUp() {
		shortArray = new short[] { 1, 2, 3, 4, 5 };
		intArray = new int[] { 1, 2, 3, 4, 5 };
		charArray = new char[] { '1', '2', '3', '4', '5' };
		longArray = new long[] { 1, 2, 3, 4, 5 };
		objectArray = new Object[] { new O1(), new O2(), new O3(), new O4(), new O5()};
		stringArray = new String[] { "a1", "b2", "c3", "d4", "e5" };
		valueArray = new Object[] { new O6(), new O6(), new O6(), new O6(), new O6()};
		
	}

	@Test
	public void containsReturnTrueForIntArrayContainingTheNeedle() {
		int[] array = new int[] { 1 };
		int needle = 3;
		assertFalse(ArrayUtils.contains(array, needle));
	}

	@Test
	public void nominalArrayWithNominalValueContainedNominalShouldGetTrueAsContainsAndLengthDivided2ForIndexOf() {
//		Object value = new O1();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[2]));
		assertEquals(2, ArrayUtils.indexOf(objectArray, objectArray[2]));

		O3 o3 = new O3();
		assertTrue(ArrayUtils.contains(objectArray, o3));
		assertEquals(2, ArrayUtils.indexOf(objectArray, o3));
		assertFalse(ArrayUtils.containsRef(objectArray, o3));
		assertTrue(ArrayUtils.containsRef(objectArray, objectArray[2]));

		int intValue = 3;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '3';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 3;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		long longValue = 3;
		assertTrue(ArrayUtils.contains(longArray, longValue));

		String stringValue = "c3";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));

		stringValue = "C3";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
		

	}

	@Test
	public void nominalArrayWithNullInputShoulGetFalseForContain() {
		assertFalse(ArrayUtils.contains(objectArray, (Object) null));
		assertFalse(ArrayUtils.containsIgnoreCase(stringArray, null));
	}

	@Test
	public void emptyArrayWithNominalInputShouldGetFalseForContain() {
		Object value = new O3();
		assertFalse(ArrayUtils.contains(new Object[0], value));
		assertEquals(-1, ArrayUtils.indexOf(new Object[0], value));
		assertFalse(ArrayUtils.containsRef(new Object[0], value));
		
		int intValue = 3;
		assertFalse(ArrayUtils.contains(new int[0], intValue));

		char charValue = '3';
		assertFalse(ArrayUtils.contains(new char[0], charValue));

		short shortValue = 3;
		assertFalse(ArrayUtils.contains(new short[0], shortValue));

		long longValue = 3;
		assertFalse(ArrayUtils.contains(new long[0], longValue));

		String stringValue = "c3";
		assertFalse(ArrayUtils.containsIgnoreCase(new String[0], stringValue));
	}

	@Test
	public void nullArrayWithNominalInputShouldGetFalseForContain() {
		Object[] nullObject=null;
		Object value = new O3();
		assertFalse(ArrayUtils.contains(null, value));
		try {
			ArrayUtils.containsRef(null, value);
			fail();
		}
		catch(Exception e){
			assertEquals(NullPointerException.class, e.getClass());
		}
		
		try {
			ArrayUtils.indexOf(null, value);
			fail();
		}
		catch(Exception e){
			assertEquals(NullPointerException.class, e.getClass());
		}
		
		int nullInt[] = null;
		int intValue = 3;
		assertFalse(ArrayUtils.contains(nullInt, intValue));

		char nullChar[] = null;
		char charValue = '3';
		assertFalse(ArrayUtils.contains(nullChar, charValue));

		short nullShort[] = null;
		short shortValue = 3;
		assertFalse(ArrayUtils.contains(nullShort, shortValue));

		long nullLong[] = null;
		long longValue = 3;
		assertFalse(ArrayUtils.contains(nullLong, longValue));

		String nullString[] = null;
		String stringValue = "c3";
		assertFalse(ArrayUtils.containsIgnoreCase(nullString, stringValue));
	}

//	@Test
//	public void objectTypeNominalArrayNullValueReturnFalseForContainsAndMinusOneForIndexOf() {
//		OBJECT_TYPE ot =  new OBJECT_TYPE();
//	}

	@Test
	public void nullArrayWithNominalValueShouldGetFalseAsContainsAndErrorForIndexOf() {
		Integer[] array = null;
		Integer value = 2;
		assertFalse(ArrayUtils.contains(array, value));
		try {
			assertEquals(-1, ArrayUtils.indexOf(array, value));

		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}

	@Test
	public void nominalArrayWithNominalValueNotContainedShouldGetFalseAsContainsAndMinusOneForIndexOf() {
		Object value = new O6();
		assertFalse(ArrayUtils.contains(objectArray, value));
		assertEquals(-1, ArrayUtils.indexOf(objectArray, value));
		

		O6 o6 = new O6();
		assertEquals(-1, ArrayUtils.indexOf(objectArray, o6));
		assertFalse(ArrayUtils.containsRef(objectArray, o6));

		int intValue = 6;
		assertFalse(ArrayUtils.contains(intArray, intValue));

		char charValue = '6';
		assertFalse(ArrayUtils.contains(charArray, charValue));

		short shortValue = 6;
		assertFalse(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 6;
		assertFalse(ArrayUtils.contains(longArray, longValue));

		String stringValue = "f6";
		assertFalse(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
	}

	@Test
	public void nominalArrayWithNominalValueContainedLowerShouldGetTrueAsContainsAndZeroForIndexOf() {
//		Object value = new O1();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[0]));
		assertEquals(0, ArrayUtils.indexOf(objectArray, objectArray[0]));
		

		O1 o1 = new O1();
		assertTrue(ArrayUtils.contains(objectArray, o1));
		assertEquals(0, ArrayUtils.indexOf(objectArray, o1));
		assertFalse(ArrayUtils.containsRef(objectArray, o1));
		assertTrue(ArrayUtils.containsRef(objectArray, objectArray[0]));

		int intValue = 1;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '1';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 1;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 1;
		assertTrue(ArrayUtils.contains(longArray, longValue));

		String stringValue = "a1";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
		stringValue = "A1";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
	}

	@Test
	public void nominalArrayWithNominalValueContainedLowerPlus1ShouldGetTrueAsContainsAnd1ForIndexOf() {
//		Object value = new O2();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[1]));
		assertEquals(1, ArrayUtils.indexOf(objectArray, objectArray[1]));
		

		O2 o2 = new O2();
		assertTrue(ArrayUtils.contains(objectArray, o2));
		assertEquals(1, ArrayUtils.indexOf(objectArray, o2));
		assertFalse(ArrayUtils.containsRef(objectArray, o2));
		assertTrue(ArrayUtils.containsRef(objectArray, objectArray[1]));

		int intValue = 2;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '2';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 2;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 2;
		assertTrue(ArrayUtils.contains(longArray, longValue));

		String stringValue = "b2";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
		stringValue = "B2";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
	}

	@Test
	public void nominalArrayWithNominalValueContainedUpperMinusOnePlus1ShouldGetTrueAsContainsAndLengthMinus2ForIndexOf() {
//		Object value = new O2();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[3]));
		assertEquals(3, ArrayUtils.indexOf(objectArray, objectArray[3]));
		

		O4 o4 = new O4();
		assertTrue(ArrayUtils.contains(objectArray, o4));
		assertEquals(3, ArrayUtils.indexOf(objectArray, o4));
		assertFalse(ArrayUtils.containsRef(objectArray, o4));
		assertTrue(ArrayUtils.containsRef(objectArray, objectArray[3]));

		int intValue = 4;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '4';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 4;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 4;
		assertTrue(ArrayUtils.contains(longArray, longValue));

		String stringValue = "d4";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
		stringValue = "D4";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
	}

	@Test
	public void nominalArrayWithNominalValueContainedUpperShouldGetTrueAsContainsAndLengthMinusOneForIndexOf() {
		
		assertTrue(ArrayUtils.contains(objectArray, objectArray[4]));
		assertEquals(4, ArrayUtils.indexOf(objectArray, objectArray[4]));
		
		O5 o5 = new O5();
		assertTrue(ArrayUtils.contains(objectArray, o5));
		assertEquals(4, ArrayUtils.indexOf(objectArray, o5));
		assertFalse(ArrayUtils.containsRef(objectArray, o5));
		assertTrue(ArrayUtils.containsRef(objectArray, objectArray[4]));

		int intValue = 5;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '5';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 5;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 5;
		assertTrue(ArrayUtils.contains(longArray, longValue));

		String stringValue = "e5";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));
		stringValue = "E5";
		assertTrue(ArrayUtils.containsIgnoreCase(stringArray, stringValue));

	}

//	@Test
//	public void contain2Test() {
////		Object value = new O1();
//		assertTrue(ArrayUtils.contains(objectArray, new O1(), new O2()));
////		assertEquals(2, ArrayUtils.indexOf(objectArray, objectArray));
//	}
	
	
	//Contain values test(value is an array in this case)
	@Test
	public void nominalArrayMultiplicityValidValueMultiplicityNominalLocations() {
		valueArray[2] = new O3();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void nominalArrayMultiplicityNullValueMultiplicityError() {
		Object[] nullValueArray = null;
		try {
			ArrayUtils.contains(objectArray, nullValueArray);
		}
		catch(Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}
	
	@Test
	public void nominalArrayMultiplicityLowerValueMultiplicityReturnFalse() {
		Object[] lowerValueArray = new Object[0];
		assertFalse(ArrayUtils.contains(objectArray, lowerValueArray));
	}
	
	@Test
	public void nominalArrayMultiplicityLowerPlusOneValueMultiplicityReturnTrue() {
		Object[] valueArray = new Object[] {new O3()};
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void nullArrayMultiplicityNominalValueMultiplicityError() {
		valueArray[2] = new O3();
		Object[] objectArray = null;
		try {
			ArrayUtils.contains(objectArray, valueArray);
		}
		catch(Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}
	
	@Test
	public void lowerArrayMultiplicityLowerPlusOneValueMultiplicityReturnFalse() {
		valueArray[2] = new O3();
		Object[] objectArray = new Object[0] ;
		assertFalse(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void lowerPlusOneArrayMultiplicityLowerPlusOneValueMultiplicityReturnFalse() {
		valueArray[2] = new O3();
		Object[] objectArray = new Object[] {new O3()} ;
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationNominalAndLower() {
		valueArray[0] = new O3();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationNominalAndLowerPlusOne() {
		valueArray[1] = new O3();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationNominalAndUpperMinusOne() {
		valueArray[3] = new O3();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationNominalAndUpper() {
		valueArray[4] = new O3();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationLowerAndNominal() {
		valueArray[2] = new O1();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationLowerPlusOneAndNominal() {
		valueArray[2] = new O2();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationLowerUpperMinusOneAndNominal() {
		valueArray[2] = new O4();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
	
	@Test
	public void locationUpperAndNominal() {
		valueArray[2] = new O5();
		assertTrue(ArrayUtils.contains(objectArray, valueArray));
	}
}
