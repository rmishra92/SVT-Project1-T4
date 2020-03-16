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
public class MethodToPropertyTest {
	@Test
	public void exceptionShouldBeThrownIfNameIsInvalid() {
		try {
			BeanUtils.methodNameToPropertyName(null);
		}
		catch(Exception e) {
			assertEquals( NullPointerException.class, e.getClass());
		}
	}
	
	@Test
	public void exceptionShouldBeThrownIfNameIsEmpty() {
		try {
			BeanUtils.methodNameToPropertyName("");
		}
		catch(Exception e) {
			assertEquals(StringIndexOutOfBoundsException.class, e.getClass());
		}
	}
	
	@Test
	public void lowerStringShouldBeReturnIfOneCharacterStringWithUpperFirstLetterInput() {
		String pName = BeanUtils.methodNameToPropertyName("L");
		assertEquals("l", pName);
	}
	
	@Test
	public void sameStringShouldBeReturnIfMultipleCharacterStringWithNonAlphaFirstLetterInput() {
		String pName = BeanUtils.methodNameToPropertyName("12");
		assertEquals("12", pName);
	}
	
	@Test
	public void lowerThirdLetterStartedStringShouldBeReturnIfMultipleCharacterStringWithIsGetMethodName() {
		String pName = BeanUtils.methodNameToPropertyName("isB");
		assertEquals("b", pName);
	}
	
	@Test
	public void fourthLetterStaredStringShouldBeReturnIfMultipleCharacterStringWithgetGetMethodName() {
		String pName = BeanUtils.methodNameToPropertyName("geta");
		assertEquals("a", pName);
	}
	
	@Test
	public void sameStringShouldBeReturnIfMultipleCharacterStringWithNoMethodNameAndLowerFirstLetter() {
		String pName = BeanUtils.methodNameToPropertyName("ha");
		assertEquals("ha", pName);
	}
	
	@Test
	public void sameStringShouldBeReturnIfSingleCharacterStringWithNumberMethodName() {
		String pName = BeanUtils.methodNameToPropertyName("2");
		assertEquals("2", pName);
	}
	@Test
	public void sameStringShouldBeReturnIfSingleCharacterStringWithLowerFirstLetterMethodName() {
		String pName = BeanUtils.methodNameToPropertyName("c");
		assertEquals("c", pName);
	}
	
	@Test
	public void lowerFirstLetterStringShouldBeReturnIfMultipleCharacterStringWithUpperFirstLetterMethodName() {
		String pName = BeanUtils.methodNameToPropertyName("Ab");
		assertEquals("ab", pName);
	}
	
	@Test
	public void errorShouldBeThrownIfMultipleCharacterStringWithOnlyisGetMethodName() {
		try {
			String pName = BeanUtils.methodNameToPropertyName("is");
		}
		catch(Exception e) {
			assertEquals(StringIndexOutOfBoundsException.class, e.getClass());
		}
	}
	
	@Test
	public void numberShouldBeThrownIfMultipleCharacterStringWithOnlyisGetMethodNameAndANumber() {
		
			String pName = BeanUtils.methodNameToPropertyName("is1");
			assertEquals("1", pName);
	}
	
	@Test
	public void lowerSingleCharacterShouldBeReturnedIfMultipleCharacterStringWIithOnlyIsMethodAndALowerLetter(){
		String pName = BeanUtils.methodNameToPropertyName("isa");
		assertEquals("a", pName);
	}
	
	@Test
	public void errorShouldBeThrownIf3CharacterStringWIithOnlyTGetMethod(){
		try {
			String pName = BeanUtils.methodNameToPropertyName("get");
		}
		catch(Exception e) {
			assertEquals(StringIndexOutOfBoundsException.class, e.getClass());
		}
	} 
	@Test
	public void errorShouldBeThrownIf3CharacterStringWIithOnlyHasMethod(){
		try {
			String pName = BeanUtils.methodNameToPropertyName("has");
		}
		catch(Exception e) {
			assertEquals(StringIndexOutOfBoundsException.class, e.getClass());
		}
	} 
	@Test
	public void errorShouldBeThrownIf3CharacterStringWIithOnlySetMethod(){
		try {
			String pName = BeanUtils.methodNameToPropertyName("set");
		}
		catch(Exception e) {
			assertEquals(StringIndexOutOfBoundsException.class, e.getClass());
		}
	} 
	@Test
	public void numberShouldBeReturnedIf4CharacterStringWIithOnly3CharacterMethodAndANumber(){
		String pName = BeanUtils.methodNameToPropertyName("get1");
		assertEquals("1", pName);
//		pName = BeanUtils.methodNameToPropertyName("has1");
//		assertEquals("1", pName);
		pName = BeanUtils.methodNameToPropertyName("set1");
		assertEquals("1", pName);
	}
	@Test
	public void lowerLetterShouldBeReturnedIf4CharacterStringWIithOnly3CharacterMethodAndAUpperLetter(){
		String pName = BeanUtils.methodNameToPropertyName("getC");
		assertEquals("c", pName);
//		pName = BeanUtils.methodNameToPropertyName("hasC");
//		assertEquals("c", pName);
		pName = BeanUtils.methodNameToPropertyName("setC");
		assertEquals("c", pName);
	}
	@Test
	public void lowerLetterShouldBeReturnedIf4CharacterStringWIithOnly3CharacterMethodAndALowerLetter(){
		String pName = BeanUtils.methodNameToPropertyName("getd");
		assertEquals("d", pName);
//		pName = BeanUtils.methodNameToPropertyName("hasd");
//		assertEquals("d", pName);
		pName = BeanUtils.methodNameToPropertyName("setd");
		assertEquals("d", pName);
	}
	
	
	// Cyclomatic Whitebox tests
	@Test
	public void stringWithOnlyGetShouldReturnNull() {
		String input = "get";
		assertNull(BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithGetAbShouldReturnNull() {
		String input = "getAb";
		assertEquals( "ab", BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithGetAShouldReturnNull() {
		String input = "getA";
		assertEquals( "a", BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithGetABShouldReturnNull() {
		String input = "getAB";
		assertEquals( "AB", BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithabShouldReturnNull() {
		String input = "getab";
		assertEquals( "ab", BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithOnlySetShouldReturnNull() {
		String input = "set";
		assertNull(BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithOnlyIsShouldReturnNull() {
		String input = "is";
		assertNull(BeanUtils.methodNameToPropertyName(input));
	}
	@Test
	public void stringWithEmptyShouldReturnNull() {
		String input = "";
		assertNull(BeanUtils.methodNameToPropertyName(input));
	}
}
