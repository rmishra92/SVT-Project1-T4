package org.jkiss.utils.t4;

import org.jkiss.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class InsertAreaTest {

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
	public void insertAreaWithNullClassThrowException() {
		Assert.assertArrayEquals(new Object[] { 1, 2, 3, 6, 7, 4, 5 },
				ArrayUtils.insertArea(null, new Object[] { 1, 2, 3, 4, 5 }, 3, new Object[] { 6, 7 }));
	}
}
