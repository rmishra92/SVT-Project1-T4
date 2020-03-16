package org.jkiss.utils;

import org.jkiss.utils.ArrayUtils;
//import org.junit.Assert;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtilsTest0 {

	@Test
	public void isEmptyReturnTrueForNullIntArray() {
		int[] array = null;
		assertTrue(ArrayUtils.isEmpty(array));
	}

	@Test
	public void isEmptyReturnTrueForEmptyIntArray() {
		int[] array = new int[0];
		assertTrue(ArrayUtils.isEmpty(array));
	}

	@Test
	public void isEmptyReturnFalseForNorminalIntArray() {
		int[] array = new int[1];
		assertFalse(ArrayUtils.isEmpty(array));
	}

	@Test
	public void isEmptyReturnTrueForNullLongArray() {
		long[] array = null;
		assertTrue(ArrayUtils.isEmpty(array));
	}

	@Test
	public void isEmptyReturnTrueForEmptyLongArray() {
		long[] array = new long[0];
		assertTrue(ArrayUtils.isEmpty(array));
	}

	@Test
	public void isEmptyReturnFalseForNorminalLongArray() {
		long[] array = new long[1];
		assertFalse(ArrayUtils.isEmpty(array));
	}

	@Test
	public void containsReturnTrueForIntArrayContainingTheNeedle() {
		int[] array = new int[] { 1 };
		int needle = 1;
		assertTrue(ArrayUtils.contains(array, needle));
	}

	@Test(expected = NullPointerException.class)
	public void concatArraysThrowsExceptionForNullArrayOne() {
		Assert.assertArrayEquals(new String[] { "a", "b" }, ArrayUtils.concatArrays(null, new String[] { "b" }));
	}

	@Test
	public void concatArraysReturnSizeOneArrayforEmptyArray1andLengthOneArrayTwo() {
		Assert.assertArrayEquals(new String[] { "a" }, ArrayUtils.concatArrays(new String[] {}, new String[] { "a" }));
	}

	@Test
	public void concatArraysOneNominalandLengthOneArray() {
		Assert.assertArrayEquals(new String[] { "a", "b", "c" },
				ArrayUtils.concatArrays(new String[] { "a", "b" }, new String[] { "c" }));
	}

	@Test
	public void concatArrayTwoNominalArray() {
		Assert.assertArrayEquals(new String[] { "a", "b", "c", "d" },
				ArrayUtils.concatArrays(new String[] { "a", "b" }, new String[] { "c", "d" }));
	}

	@Test
	public void safeArrayReturnEmptyListforNullInput() {
		String[] arr = null;
		List<Object> emptyList = new ArrayList<>();
		Assert.assertEquals(emptyList, ArrayUtils.safeArray(null));

	}

	@Test
	public void safeArrayReturnEmptyListForEmptyArray() {
		String[] arr = null;
		List<Object> emptyList = new ArrayList<>();
		Assert.assertEquals(emptyList, ArrayUtils.safeArray(arr));

	}

	@Test
	public void safeArrayReturnOneItemListForSizeOneArray() {
		String[] arr = null;
		List<Object> emptyList = new ArrayList<>();
		Assert.assertEquals(emptyList, ArrayUtils.safeArray(null));

		List<String> list = new ArrayList<>();
		list.add("a");
		Assert.assertEquals(list, ArrayUtils.safeArray(new String[] { "a" }));
	}

	@Test
	public void safeArrayReturnNominalListForNominalArray() {
		String[] arr = null;
		List<Object> emptyList = new ArrayList<>();
		Assert.assertEquals(emptyList, ArrayUtils.safeArray(null));

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		Assert.assertEquals(list, ArrayUtils.safeArray(new String[] { "a", "b", "c" }));
	}

	@Test
	public void addNominalArraywithRobustValue() {
		Assert.assertArrayEquals(new Object[] { 'a', 'b', 'c' },
				ArrayUtils.add(Object.class, new Object[] { 'a', 'b' }, 'c'));
	}

	@Test(expected = NullPointerException.class)
	public void addNullArrayWithRobustValue() {
		Assert.assertArrayEquals(new Object[] { 'a', 'b', 'c' }, ArrayUtils.add(Object.class, null, 'c'));
	}

	@Test
	public void addEmptyArrayWithRobustValue() {
		Assert.assertArrayEquals(new Object[] { 'c' }, ArrayUtils.add(Object.class, new Object[] {}, 'c'));
	}

	@Test
	public void addOneItemArrayWithRobustValue() {
		Assert.assertArrayEquals(new Object[] { 'a', 'c' }, ArrayUtils.add(Object.class, new Object[] { 'a' }, 'c'));
	}

	@Test
	public void addNominalArrayWithNullValue() {
		Assert.assertArrayEquals(new Object[] { 'a', 'b', null },
				ArrayUtils.add(Object.class, new Object[] { 'a', 'b' }, null));
	}

	@Test(expected = NullPointerException.class)
	public void addNominalArrayWithRobustValueNullClassThrowException() {
		Assert.assertArrayEquals(new Object[] { 'a', 'b', 'c' }, ArrayUtils.add(null, new Object[] { 'a', 'b' }, 'c'));
	}

	@Test
	public void testRemoveWithNominalInputsReturnRemovedArray() {
		Assert.assertArrayEquals(new Object[] { 2, 3, 4, 5 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 0));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveWithNominalArrayRoubustClassFalseIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 2, 3, 4, 5 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, -1));
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveWithNullArrayRoubustClassAndIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 2, 3, 4, 5 }, ArrayUtils.remove(Object.class, null, 2));
	}

	@Test(expected = NegativeArraySizeException.class)
	public void testRemoveWithEmptyArrayRoubustClassAndIndexReturnError() {
		Assert.assertArrayEquals(new Object[] {}, ArrayUtils.remove(Object.class, new Object[] {}, 2));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveWithOneItemArrayRoubustClassAndIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 1 }, ArrayUtils.remove(Object.class, new Object[] { 1 }, 6));
	}

	@Test
	public void testRemoveWithLowerPlusOneIndexReturnRemovedArray() {
		Assert.assertArrayEquals(new Object[] { 1, 3, 4, 5 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 1));
	}

	@Test
	public void testRemoveWithNominalIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 4, 5 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 2));
	}

	@Test
	public void testRemoveWithUpperIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 4 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 4));
	}

	@Test
	public void testRemoveWithUpperMinusOneIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 5 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 3));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveWithRobustUpperIndexReturnError() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 },
				ArrayUtils.remove(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 8));
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveWithNullClassReturnError() {
		Assert.assertArrayEquals(new Object[] { 2, 3, 4, 5 },
				ArrayUtils.remove(null, new Object[] { 1, 2, 3, 4, 5 }, 3));
	}

	@Test
	public void insertAreaWithNominalInputs () {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 3, new Object[] { 6, 7 }));
	}

	@Test(expected = NullPointerException.class)
	public void insertAreaWithNullSecondArrayThorwException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 3, null));
	}

	@Test
	public void insertAreaWithEmptySecondArray() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 3, new Object[] {}));
	}

	@Test
	public void insertAreaWithOneItemSecondArray() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 3, new Object[] { 6 }));
	}

	@Test(expected = NullPointerException.class)
	public void insertAreaWithNullFirstArrayThrowException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(Object.class, null, 6, new Object[] { 6, 7 }));
	}

	@Test
	public void insertAreaWithEmptyFirstArray() {
		Assert.assertArrayEquals(new Object[] { 6, 7 },
				ArrayUtils.insertArea(Object.class, new Object[] {}, 0, new Object[] { 6, 7 }));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAreaWithOneItemFirstArray() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1 }, 2, new Object[] { 6, 7 }));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAreaWithNegativeFromThrowsException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, -1, new Object[] { 6, 7 }));
	}

	@Test
	public void insertAreaWithLowerFrom() {
		Assert.assertArrayEquals(new Object[] { 6, 7, 1, 2, 3, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 0, new Object[] { 6, 7 }));
	}

	@Test
	public void insertAreaWithLowerPlusOneFrom() {
		Assert.assertArrayEquals(new Object[] { 1, 6, 7, 2, 3, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 1, new Object[] { 6, 7 }));
	}

	@Test
	public void insertAreaWithUpperFrom() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 4, 5, 6, 7 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 5, new Object[] { 6, 7 }));
	}

	@Test
	public void insertAreaWithUpperMinusOneFrom() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 4, 6, 7, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 4, new Object[] { 6, 7 }));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAreaWithRobustUpperFromThrowsException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 10, new Object[] { 6, 7 }));
	}

	@Test(expected = NullPointerException.class)
	public void tinsertAreaWithNullClassThrowException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(null, new Object[] { 1, 2, 3, 4, 5 }, 3, new Object[] { 6, 7 }));
	}

	// delete area
	@Test
	public void deleteAreawithNominalInputs() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 2, 3));

	}
	/*
	@Test
	public void a2() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 1 ,2,3,4,5},
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 2, -1));

	}
	*/
	@Test(expected = NullPointerException.class)
	public void deleteAreaWithNullArrayThrowsException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 5 },
				ArrayUtils.deleteArea(Object.class, null, 2, 3));

	}
	/*
	@Test(expected = NegativeArraySizeException.class)
	public void a4() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { }, 2, 3));

	}
	@Test(expected = NegativeArraySizeException.class)
	public void a5() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 5 },
				ArrayUtils.deleteArea(Object.class, new Object[] {1}, 2, 3));

	}
	*/
	@Test(expected = NullPointerException.class)
	public void deleteAreaWithNullClassThrowsException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 5 },
				ArrayUtils.deleteArea(null, new Object[] { 1, 2, 3, 4, 5 }, 2, 3));

	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deleteAreaWithNegativeFromThrowsException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, -1, 3));

	}
	/*
	@Test
	public void a8() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3,4,5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 4, 3));

	}
	*/
	@Test
	public void deleteAreaWithLowerFrom() {
		Assert.assertArrayEquals(new Object[] { 5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 0, 3));

	}

	@Test
	public void deleteAreaWithLowerPlusOneFrom() {
		Assert.assertArrayEquals(new Object[] { 1,5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 1, 3));

	}
	@Test
	public void deleteAreaWithLowerMinusOneFrom() {
		Assert.assertArrayEquals(new Object[] { 1, 2,5 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 2, 3));

	}
	@Test
	public void deleteAreaWithUpperTo() {
		Assert.assertArrayEquals(new Object[] { 1, 2 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 2, 4));

	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deleteAreaWithRobustToThrowsException() {
		Assert.assertArrayEquals(new Object[] { 1, 2 },
				ArrayUtils.deleteArea(Object.class, new Object[] { 1, 2, 3, 4, 5 }, 2, 6));

	}
}
