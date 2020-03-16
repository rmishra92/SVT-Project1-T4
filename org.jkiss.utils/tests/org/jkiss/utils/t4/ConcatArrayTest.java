package org.jkiss.utils.t4;

import org.jkiss.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class ConcatArrayTest {
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
}
