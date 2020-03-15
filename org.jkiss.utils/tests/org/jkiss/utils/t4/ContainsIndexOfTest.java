package org.jkiss.utils.t4;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import org.jkiss.utils.ArrayUtils;
import org.junit.Before;

public class ContainsIndexOfTest {
	class O1 implements Cloneable{}

	class O2 implements Cloneable{}

	class O3 implements Cloneable{}

	class O4 implements Cloneable{}

	class O5 implements Cloneable{}
	
	class O6 implements Cloneable{}

	private short[] shortArray;
	private int[] intArray;
	private long[] longArray;
	private char[] charArray;
	private Object[] objectArray;

	@Before
	public void setUp() {
		shortArray = new short[] { 1, 2, 3, 4, 5 };
		intArray = new int[] { 1, 2, 3, 4, 5 };
		charArray = new char[] { '1', '2', '3', '4', '5' };
		longArray = new long[] { 1, 2, 3, 4, 5 };
		objectArray = new Object[] {
				new O1(),new O2(),new O3(),new O4(),new O5(),
		};
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

		int intValue = 3;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '3';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 3;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 3;
		assertTrue(ArrayUtils.contains(longArray, longValue));
	}
	
	@Test
	public void nominalArrayWithNullInputShoulGetFalseForContain() {
		assertFalse(ArrayUtils.contains(objectArray, (Object)null));
	}
	
	@Test
	public void emptyArrayWithNominalInputShouldGetFalseForContain() {
		int intValue = 3;
		assertFalse(ArrayUtils.contains(new int[0], intValue));

		char charValue = '3';
		assertFalse(ArrayUtils.contains(new char[0], charValue));

		short shortValue = 3;
		assertFalse(ArrayUtils.contains(new short[0], shortValue));

		long longValue = 3;
		assertFalse(ArrayUtils.contains(new long[0], longValue));
	}
	
	@Test
	public void nullArrayWithNominalInputShouldGetFalseForContain() {
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

		int intValue = 6;
		assertFalse(ArrayUtils.contains(intArray, intValue));

		char charValue = '6';
		assertFalse(ArrayUtils.contains(charArray, charValue));

		short shortValue = 6;
		assertFalse(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 6;
		assertFalse(ArrayUtils.contains(longArray, longValue));
	}
	
	@Test
	public void nominalArrayWithNominalValueContainedLowerShouldGetTrueAsContainsAndZeroForIndexOf() {
//		Object value = new O1();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[0]));
		assertEquals(0, ArrayUtils.indexOf(objectArray, objectArray[0]));

		int intValue = 1;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '1';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 1;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 1;
		assertTrue(ArrayUtils.contains(longArray, longValue));
	}
	
	@Test
	public void nominalArrayWithNominalValueContainedLowerPlus1ShouldGetTrueAsContainsAnd1ForIndexOf() {
//		Object value = new O2();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[1]));
		assertEquals(1, ArrayUtils.indexOf(objectArray, objectArray[1]));

		int intValue = 2;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '2';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 2;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 2;
		assertTrue(ArrayUtils.contains(longArray, longValue));
	}
	
	@Test
	public void nominalArrayWithNominalValueContainedUpperMinusOnePlus1ShouldGetTrueAsContainsAndLengthMinus2ForIndexOf() {
//		Object value = new O2();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[3]));
		assertEquals(3, ArrayUtils.indexOf(objectArray, objectArray[3]));

		int intValue = 4;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '4';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 4;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 4;
		assertTrue(ArrayUtils.contains(longArray, longValue));
	}
	
	@Test
	public void nominalArrayWithNominalValueContainedUpperShouldGetTrueAsContainsAndLengthMinusOneForIndexOf() {
//		O2 value = new O2();
		assertTrue(ArrayUtils.contains(objectArray, objectArray[4]));
		assertEquals(4, ArrayUtils.indexOf(objectArray, objectArray[4]));

		int intValue = 5;
		assertTrue(ArrayUtils.contains(intArray, intValue));

		char charValue = '5';
		assertTrue(ArrayUtils.contains(charArray, charValue));

		short shortValue = 5;
		assertTrue(ArrayUtils.contains(shortArray, shortValue));

		short longValue = 5;
		assertTrue(ArrayUtils.contains(longArray, longValue));
	}
	
}
