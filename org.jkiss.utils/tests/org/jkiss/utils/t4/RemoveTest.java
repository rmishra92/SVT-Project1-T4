package org.jkiss.utils.t4;

import org.jkiss.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class RemoveTest {
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
}
