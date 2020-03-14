package org.jkiss.utils;

import org.jkiss.utils.ArrayUtils;
//import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class ArrayUtilsTest0 {
	
	@Test
	public void isEmptyReturnTrueForNullIntArray() {
		int[] array=null;
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnTrueForEmptyIntArray() {
		int[] array=new int[0];
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnFalseForNorminalIntArray() {
		int[] array=new int[1];
		assertFalse(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnTrueForNullLongArray() {
		long[] array=null;
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnTrueForEmptyLongArray() {
		long[] array=new long[0];
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnFalseForNorminalLongArray() {
		long[] array=new long[1];
		assertFalse(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void containsReturnTrueForIntArrayContainingTheNeedle() {
		int[] array = new int[]{1};
		int needle = 1;
		assertTrue(ArrayUtils.contains(array, needle));
	}
}
