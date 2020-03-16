package org.jkiss.utils.t4;

import org.jkiss.utils.ArrayUtils;
//import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;


public class DeleteAreaTest {

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
