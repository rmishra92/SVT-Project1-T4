package org.jkiss.utils;

import org.junit.Assert;
import org.junit.Test;

public class InvokeObjectMethodWithArguments {

    public class TestClass {
        public Boolean isMethodInvoked;

        public void testMethod(String arg1)
        {
            isMethodInvoked = true;
        }

        private void testInAccessibleMethod(String arg1)
        {
            isMethodInvoked = true;
        }
    }

    @Test
    public void shouldBeAbleToInvokeAnExistingMethodWithValidArguments() throws Throwable {
        TestClass obj = new TestClass();
        BeanUtils.invokeObjectMethod(obj, "testMethod",
                new Class[]{String.class}, new Object[] {"Test"});

        Assert.assertTrue(obj.isMethodInvoked);
    }

    @Test
    public void shouldThrowAnErrorUponInvokingAnInAccessibleMethodWithValidArguments() throws Throwable {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "testInAccessibleMethod",
                    new Class[]{String.class}, new Object[] {"Test"});
            Assert.fail("Should have thrown an exception upon invoking an inaccessible method");
        } catch(Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }

    @Test
    public void shouldThrowErrorForMethodInvocationOnInvalidObject() throws Throwable {
        try {
            BeanUtils.invokeObjectMethod(null, "testMethod",
                    new Class[] { String.class}, new Object[] { "Test" });
            Assert.fail("Should have thrown an error for an invalid object");
        } catch (Exception e) {
            Assert.assertTrue(e != null);
        }
    }

    @Test
    public void shouldThrowErrorForExistingMethodWithInvalidArguments() throws Throwable {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "testMethod",
                    new Class[] {String.class}, new Object[] {2});
            Assert.fail("Should have thrown an error for invalid argument");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("IllegalArgumentException"));
        }
    }

    @Test
    public void shouldThrowErrorForNonExistingMethodWithInvalidParameters() throws Throwable {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "testMethod",
                    new Class[] { Integer.class}, new Object[] {"Test"});
            Assert.fail("Should have thrown an error for non existing method invocation");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }

    @Test
    public void shouldThrowErrorForNonExistingMethodWithInvalidName() throws Throwable {
        try {
            TestClass obj = new TestClass();
            BeanUtils.invokeObjectMethod(obj, "invalidMethodName",
                    new Class[] { String.class }, new Object[] { "Test" });
            Assert.fail("Should have thrown an error for non existing method invocation");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }
}
