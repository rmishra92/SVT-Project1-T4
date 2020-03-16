package org.jkiss.utils;

import org.junit.Assert;
import org.junit.Test;

public class InvokeObjectMethodWithoutArguments {

    public class TestClass {
        public Boolean isMethodInvoked;

        public void testMethod()
        {
            isMethodInvoked = true;
        }

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
}
