package org.jkiss.utils.t4;

import org.jkiss.utils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

public class InvokeObjectMethodWithoutArguments {

    public class TestClass {
        public Boolean isMethodInvoked;

        public void testMethod()
        {
            isMethodInvoked = true;
        }
		
		public void testMethodWithException() throws Exception { throw new Exception("Method Invocation error"); }

        private void testInAccessibleMethod()
        {
            isMethodInvoked = true;
        }
    }

    @Test
    public void shouldBeAbleToInvokeAnExistingMethod() throws Throwable {
        TestClass obj = new TestClass();
        BeanUtils.invokeObjectMethod(obj, "testMethod");

        Assert.assertTrue(obj.isMethodInvoked);
    }

    @Test
    public void shouldThrowErrorForMethodInvocationOnNullObject() throws Throwable
    {
        try {
            TestClass obj = null;
            BeanUtils.invokeObjectMethod(obj, "testMethod");
            Assert.fail("Should have thrown an error for a null object");
        } catch (Exception e) {
            Assert.assertTrue(e != null);
        }
    }

    @Test
    public void shouldThrowErrorForMethodInvocationWithNonExistentName() throws Throwable
    {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "invalidMethodName");
            Assert.fail("Should have thrown an error for a non-existent method name");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }

    @Test
    public void shouldThrowErrorForInAccessibleMethodInvocation() throws Throwable
    {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "testInAccessibleMethod");
            Assert.fail("Should have thrown an error for an in-accessible method invocation");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }
	
	@Test
    public void shouldExpectASimilarErrorAsRaisedByTargetMethodUponInvocation() throws Throwable {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "testMethodWithException");
            Assert.fail("Should have thrown an error for a target method raising an issue.");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals("Method Invocation error"));
        }
    }
}
