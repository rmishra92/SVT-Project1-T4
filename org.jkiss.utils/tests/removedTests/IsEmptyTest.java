package removedTests;

import org.jkiss.utils.ArrayUtils;
//import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class IsEmptyTest {
	
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
	public void isEmptyReturnTrueForNullShortArray() {
		short[] array=null;
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnTrueForEmptyShortArray() {
		short[] array=new short[0];
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnFalseForNorminalShortArray() {
		short[] array=new short[1];
		assertFalse(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnTrueForNullCharArray() {
		Character[] array=null;
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnTrueForEmptyCharArray() {
		Character[] array=new Character[0];
		assertTrue(ArrayUtils.isEmpty(array));
	}
	
	@Test
	public void isEmptyReturnFalseForNorminalCharArray() {
		Character[] array=new Character[] {'2'};
		assertFalse(ArrayUtils.isEmpty(array));
	}
	
}
