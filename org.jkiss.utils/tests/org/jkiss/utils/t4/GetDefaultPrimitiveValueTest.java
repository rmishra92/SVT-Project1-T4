package org.jkiss.utils.t4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

import org.jkiss.utils.BeanUtils;

public class GetDefaultPrimitiveValueTest {

    public class TestClass
    {

    }

    @Test
    public void shouldThrowErrorForNonPrimitiveTypeInput()
    {
        try{
            Object returnObject = BeanUtils.getDefaultPrimitiveValue(TestClass.class);
            fail("should have thrown exception for a non-primitive input");

        } catch (Exception e)
        {

        }
    }

    @Test
    public void shouldReturnFalseAsDefaultValueOfBooleanType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Boolean.TYPE);
        Assert.assertEquals(returnObject, new Boolean(false));
    }

    @Test
    public void shouldReturn0AsDefaultValueOfShortType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Short.TYPE);
        Assert.assertEquals(returnObject, (short) 0);
    }

    @Test
    public void shouldReturn0AsDefaultValueOfIntegerType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Integer.TYPE);
        Assert.assertEquals(returnObject, 0);
    }

    @Test
    public void shouldReturn0AsDefaultValueOfLongType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Long.TYPE);
        Assert.assertEquals(returnObject, 0l);
    }

    @Test
    public void shouldReturn0AsDefaultValueOfFloatType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Float.TYPE);
        Assert.assertEquals(returnObject, new Float(0.0));
    }

    @Test
    public void shouldReturn0AsDefaultValueOfDoubleType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Double.TYPE);
        Assert.assertEquals(returnObject, 0.0);
    }

    @Test
    public void shouldReturn0AsDefaultValueOfByteType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Byte.TYPE);
        Assert.assertEquals(returnObject, (byte) 0);
    }

    @Test
    public void shouldReturn0AsDefaultValueOfCharacterType()
    {
        Object returnObject = BeanUtils.getDefaultPrimitiveValue(Character.TYPE);
        Assert.assertEquals(returnObject, (char) 0);
    }
}
