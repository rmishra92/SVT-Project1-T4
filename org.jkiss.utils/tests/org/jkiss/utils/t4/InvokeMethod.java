package org.jkiss.utils.t4;

import java.lang.reflect.InvocationTargetException;

import org.jkiss.utils.BeanUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvokeMethod {

    public static class TestStaticClass
    {
        public static Boolean isStaticMethodInvoked;
        public static Boolean isStaticInAccessibleMethodInvoked;

        public static void testStaticMethod(Integer argument1, Integer argument2)
        {
            TestStaticClass.isStaticMethodInvoked = true;
        }
		
		public static void testStaticMethodWithException(Integer argument1, Integer argument2) throws Exception {
            throw new Exception("Method Invocation error");
        }

        private static void testStaticInAccessibleMethod(Integer argument1, Integer argument2)
        {
            TestStaticClass.isStaticInAccessibleMethodInvoked = true;
        }
    }
    
    @Before
    public void setUp() {
    	TestStaticClass.isStaticInAccessibleMethodInvoked = false;
    	TestStaticClass.isStaticMethodInvoked = false;
    }

    @Test
    public void shouldBeAbleToInvokeAnExistingStaticMethodWithValidArguments() throws Throwable {
        BeanUtils.invokeStaticMethod(TestStaticClass.class, "testStaticMethod",
                new Class[]{Integer.class, Integer.class}, new Object[] {2, 3});

        Assert.assertTrue(TestStaticClass.isStaticMethodInvoked);
    }
    

    @Test
    public void shouldThrowAnErrorUponInvokingAnInAccessibleMethod() throws Throwable {
        try {
            BeanUtils.invokeStaticMethod(TestStaticClass.class, "testStaticInAccessibleMethod",
                    new Class[]{Integer.class, Integer.class}, new Object[] {2, 3});
            Assert.fail("Should have thrown an exception for an inaccessible method");
        } catch(Exception e) {
            Assert.assertTrue(e.toString().contains("NoSuchMethodException"));
        }
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
	
	@Test
    public void shouldExpectASimilarErrorAsRaisedByTargetMethodUponInvocation() throws Throwable {
        try {
            BeanUtils.invokeStaticMethod(TestStaticClass.class, "testStaticMethodWithException",
                    new Class[] { Integer.class, Integer.class}, new Object[] { 2, 3 });
            Assert.fail("Should have thrown an error for a target method raising an issue.");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals("Method Invocation error"));
        }
    }
}
