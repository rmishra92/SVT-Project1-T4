package removedTests;

import java.util.ArrayList;
import java.util.List;

import org.jkiss.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class SafeArrayTest {
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
}
