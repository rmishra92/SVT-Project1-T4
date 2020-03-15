package org.jkiss.utils.t4;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;


import org.jkiss.utils.BeanUtils;
import org.junit.Test;
public class PropertyMethodNameTest {
	//1
	@Test(expected =   NullPointerException.class)
	public void nullNameShouldGetNullException() {
		BeanUtils.propertyNameToMethodName(null);
		fail("Exception not thrown");
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void emptyStringShouldGetIndexOutOfBoundException() {
			BeanUtils.propertyNameToMethodName("");
			fail("Exception not thrown");
	}
	
	@Test
	public void oneCharacterStringWithCapitalFirstLetterGetTheSameStringBack() {
		String methodName = BeanUtils.propertyNameToMethodName("L");
		assertEquals("L", methodName);
	}
	
	@Test
	public void multipleCharactersStringWithNumberFirstLetterGetTheSameStringBack() {
		String methodName = BeanUtils.propertyNameToMethodName("1abcd");
		assertEquals("1abcd", methodName);
	}
	
	@Test
	public void oneCharactersStringWithNumberFirstLetterGetTheSameStringBack() {
		String methodName = BeanUtils.propertyNameToMethodName("3");
		assertEquals("3", methodName);
	}
	
	@Test
	public void oneCharactersStringWithLowerAlphabatFirstLetterGetUpperFirstLetterStringBack() {
		String methodName = BeanUtils.propertyNameToMethodName("a");
		assertEquals("A", methodName);
	}
	@Test
	public void multipleCharactersStringWithUpperAlphabatFirstLetterGetSameStringBack() {
		String methodName = BeanUtils.propertyNameToMethodName("Nominal");
		assertEquals("Nominal", methodName);
	}
	@Test
	public void multipleCharactersStringWithLowerAlphabatFirstLetterGetUpperFirstLetterStringBack() {
		String methodName = BeanUtils.propertyNameToMethodName("method");
		assertEquals("Method", methodName);
	}

}
