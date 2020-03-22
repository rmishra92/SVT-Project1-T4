package org.jkiss.utils.t4;

import org.jkiss.utils.ArrayUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class ConcatArrayTest {
	@Test(expected = NullPointerException.class)
	public void concatArraysThrowsExceptionForNullArrayOne() {
		ArrayUtils.concatArrays(null, new String[] { "d" , "e", "f" });
	}

	@Test
	public void concatArraysReturnSizeOneArrayforEmptyArray1andNominalArrayTwo() {
		assertArrayEquals(new String[] { "a","b","c" }, ArrayUtils.concatArrays(new String[] {}, new String[] { "a", "b", "c"  }));
	}

	@Test
	public void concatArraysOneNominalandArrayTwoNominal() {
		assertArrayEquals(new String[] { "a","d","e","f" },
				ArrayUtils.concatArrays(new String[] { "a" }, new String[] { "d","e","f" }));
	}

	@Test
	public void concatArrayTwoNominalArray() {
		assertArrayEquals(new String[] { "a", "b", "c", "d", "e", "f" },
				ArrayUtils.concatArrays(new String[] { "a", "b", "c" }, new String[] { "d", "e", "f" }));
	}
	@Test(expected = NullPointerException.class)
	public void concatArraysThrowsExceptionForNullArrayTwo() {
		ArrayUtils.concatArrays(new String[] { "d","e", "f"}, null);
		fail();
	}

	@Test
	public void concatArraysReturnSizeOneArrayforLowerPlusOneArray2andNominalArrayOne() {
		assertArrayEquals(new String[] { "a","b","c","d" }, ArrayUtils.concatArrays(new String[] {"a","b","c"}, new String[] { "d" }));
	}

	@Test
	public void concatArraysOneNominalandLengthZeroArrayTwo() {
		assertArrayEquals(new String[] { "a", "b", "c" },
				ArrayUtils.concatArrays(new String[] { "a", "b", "c" }, new String[] {}));
	}

}
