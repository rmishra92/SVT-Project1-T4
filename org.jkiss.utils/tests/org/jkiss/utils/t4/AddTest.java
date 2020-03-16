package org.jkiss.utils.t4;

import org.jkiss.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class AddTest {
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
}
