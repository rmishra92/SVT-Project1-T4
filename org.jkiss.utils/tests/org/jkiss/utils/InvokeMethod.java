package org.jkiss.utils;

import org.junit.Assert;
import org.junit.Test;

public class InvokeMethod {

    public static class TestStaticClass
    {
        public static Boolean isStaticMethodInvoked;

        public static void testStaticMethod(Integer argument1, Integer argument2)
        {
            TestStaticClass.isStaticMethodInvoked = true;
        }
    }

    @Test
    public void shouldBeAbleToInvokeAnExistingStaticMethodWithValidArguments() throws Throwable {
        BeanUtils.invokeStaticMethod(TestStaticClass.class, "testStaticMethod",
                new Class[]{Integer.class, Integer.class}, new Object[] {2, 3});

        Assert.assertTrue(TestStaticClass.isStaticMethodInvoked);
    }

    @Test
    public void shouldThrowErrorForMethodInvocationOnInvalidType() throws Throwable {
        try {
            BeanUtils.invokeStaticMethod(null, "testStaticMethod",
                    new Class[] { Integer.class, Integer.class}, new Object[] { 2, 3 });
            Assert.fail("Should have thrown an error for an invalid type");
        } catch (Exception e) {
            Assert.assertTrue(e != null);
        }
    }

    @Test
    public void shouldThrowErrorForExistingStaticMethodWithInvalidArguments() throws Throwable {
        try {
            BeanUtils.invokeStaticMethod(TestStaticClass.class, "testStaticMethod",
                    new Class[] {Integer.class, Integer.class}, new Object[] {2, "invalidValue"});
            Assert.fail("Should have thrown an error for invalid argument");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("IllegalArgumentException"));
        }
    }

    @Test
    public void shouldThrowErrorForNonExistingStaticMethodWithInvalidParameters() throws Throwable {
        try {
            BeanUtils.invokeStaticMethod(TestStaticClass.class, "testStaticMethod",
                    new Class[] { Integer.class, String.class}, new Object[] {2, 3});
            Assert.fail("Should have thrown an error for non existing method invocation");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }

    @Test
    public void shouldThrowErrorForNonExistingStaticMethodWithInvalidName() throws Throwable {
        try {
            BeanUtils.invokeStaticMethod(TestStaticClass.class, "invalidMethodName",
                    new Class[] { Integer.class, Integer.class}, new Object[] { 2, 3 });
            Assert.fail("Should have thrown an error for non existing method invocation");
        } catch (Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
    }
}
