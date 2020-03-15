package org.jkiss.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class IsOfTypeTest {

    public interface ITestInterface {

    }

    @Test
    public void shouldReturnFalseForAnInvalidInput()
    {
        Boolean isArray = BeanUtils.isArrayType(ITestInterface.class);
        Boolean isCollection = BeanUtils.isCollectionType(ITestInterface.class);
        Boolean isBoolean = BeanUtils.isBooleanType(ITestInterface.class);
        Boolean isNumericType = BeanUtils.isNumericType(ITestInterface.class);

        Assert.assertFalse(isArray);
        Assert.assertFalse(isCollection);
        Assert.assertFalse(isBoolean);
        Assert.assertFalse(isNumericType);
    }

    @Test
    public void isArrayTypeShouldReturnsTrueForAnArrayTypeInput()
    {
        Integer[]  array = {1, 2, 3};
        Boolean isArrayType = BeanUtils.isArrayType(array.getClass());

        Assert.assertTrue(isArrayType);
    }

    @Test
    public void isCollectionTypeReturnsTrueForACollectionTypeInput()
    {
        Collection<String> collection = new ArrayList<String>();
        Boolean isCollectionType = BeanUtils.isCollectionType(collection.getClass());

        Assert.assertTrue(isCollectionType);
    }

    @Test
    public void isBooleanTypeReturnsTrueForABooleanTypeInput()
    {
        Boolean booleanVal = true;
        Boolean isBooleanType = BeanUtils.isBooleanType(booleanVal.getClass());

        Assert.assertTrue(isBooleanType);
    }

    @Test
    public void isNumericTypeReturnsTrueForAShortTypeInput()
    {
        Short shortVal = 0;
        Boolean isNumericType = BeanUtils.isNumericType(shortVal.getClass());

        Assert.assertTrue(isNumericType);
    }

    @Test
    public void isNumericTypeReturnsTrueForAnIntegerTypeInput()
    {
        Integer integerVal = 0;
        Boolean isNumericType = BeanUtils.isNumericType(integerVal.getClass());

        Assert.assertTrue(isNumericType);
    }

    @Test
    public void isNumericTypeReturnsTrueForALongTypeInput()
    {
        Long longVal = Long.valueOf(0);
        Boolean isNumericType = BeanUtils.isNumericType(longVal.getClass());

        Assert.assertTrue(isNumericType);
    }

    @Test
    public void isNumericTypeReturnsTrueForADoubleTypeInput()
    {
        Double doubleVal = Double.valueOf(0);
        Boolean isNumericType = BeanUtils.isNumericType(doubleVal.getClass());

        Assert.assertTrue(isNumericType);
    }

    @Test
    public void isNumericTypeReturnsTrueForAFloatTypeInput()
    {
        Float floatVal = Float.valueOf(0);
        Boolean isNumericType = BeanUtils.isNumericType(floatVal.getClass());

        Assert.assertTrue(isNumericType);
    }

    @Test
    public void isNumericTypeReturnsTrueForAByteTypeInput()
    {
        Byte byteVal = 0;
        Boolean isNumericType = BeanUtils.isNumericType(byteVal.getClass());

        Assert.assertTrue(isNumericType);
    }
}
