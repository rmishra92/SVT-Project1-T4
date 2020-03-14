package org.jkiss.utils;

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

public class GetterNameTest {
	
	@Test(expected =  NullPointerException.class)
	public void isGetterNameThrowErrorIfInputIsInvalid() {
		BeanUtils.isGetterName(null);
	}

	@Test
	public void isGetterNameReturnFalseForNonGetterInput() {
		String input = "notGetter";
		assertFalse(BeanUtils.isGetterName(input));
	}
	
	@Test
	public void isGetterNameReturnFalseForGetterInputStartsWithIs() {
		String input = "isGetter";
		assertTrue(BeanUtils.isGetterName(input));
	}
	@Test
	public void iisGetterNameReturnFalseForGetterInputStartsWithGet() {
		String input = "getGetter";
		assertTrue(BeanUtils.isGetterName(input));
	}
	@Test
	public void isGetterNameReturnFalseForGetterInputStartsWithHas() {
		String input = "hasGetter";
		assertTrue(BeanUtils.isGetterName(input));
	}
	
	
	@Test(expected =  NullPointerException.class)
	public void getSetterNameThrowErrorIfInputIsInvalid() {
		BeanUtils.getSetterName(null);
	}

	@Test
	public void getSetterNameReturnNullForNonGetterInput() {
		String input = "notGetter";
		assertNull(BeanUtils.getSetterName(input));
	}
	
	@Test
	public void getSetterNameReturnPropertyForGetterInputStartsWithIs() {
		String input = "isGetter";
		assertEquals("setGetter", BeanUtils.getSetterName(input));
	}
	
	@Test
	public void getSetterNameReturnPropertyForGetterInputStartsWithGet() {
		String input = "getGetter";
		assertEquals("setGetter", BeanUtils.getSetterName(input));
	}
	
	@Test
	public void getSetterNameReturnPropertyForGetterInputStartsWithHas() {
		String input = "hasGetter";
		assertEquals("setGetter", BeanUtils.getSetterName(input));
	}
	
	
	
	@Test(expected =  NullPointerException.class)
	public void getPropertyNameThrowErrorIfInputIsInvalid() {
		BeanUtils.getPropertyNameFromGetter(null);
	}

	@Test
	public void getPropertyNameReturnNullForNonGetterInput() {
		String input = "notGetter";
		assertNull(BeanUtils.getPropertyNameFromGetter(input));
	}
	
	@Test
	public void getPropertyNameReturnPropertyForGetterInputStartsWithIs() {
		String input = "isGetter";
		assertEquals("getter", BeanUtils.getPropertyNameFromGetter(input));
	}
	
	@Test
	public void getPropertyNameReturnPropertyForGetterInputStartsWithGet() {
		String input = "getGetter";
		assertEquals("getter", BeanUtils.getPropertyNameFromGetter(input));
	}
	
	@Test
	public void getPropertyNameReturnPropertyForGetterInputStartsWithHas() {
		String input = "hasGetter";
		assertEquals("getter", BeanUtils.getPropertyNameFromGetter(input));
	}
	
}
