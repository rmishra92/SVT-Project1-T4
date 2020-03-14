package org.jkiss.utils;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

import org.jkiss.utils.BeanUtils;
import org.junit.Test;

public class GetMethodTest2 {
	public class GetTestClass1 {
		public void setAny() {

		}

		public String getProperty() {
			return "";
		}
	}

	// 1
	@Test
	public void baseCaseForValiditySetMethods() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "property");
			assertEquals(methodA, GetTestClass1.class.getMethod("getProperty"));
			assertEquals(methodB, GetTestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}

	// 2
	@Test
	public void invalidClassWithNominalPropertyName() {
		try {
			Method methodA = BeanUtils.getGetMethod(null, "property", true);
			Method methodB = BeanUtils.getGetMethod(null, "property");
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

	}

	// 3
	@Test
	public void nominalClassWithNullPropertyName() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, null, true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, null);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

	}

	public class GetTestClass2 {
	}

	// 4
	@Test
	public void lowerClassMultplicityWithNominalPropertyNameShouldReturnNull() {
		Method methodA = BeanUtils.getGetMethod(GetTestClass2.class, "property", false);
		Method methodB = BeanUtils.getGetMethod(GetTestClass2.class, "property");
		assertNull(methodA);
		assertNull(methodB);
	}

	public class GetTestClass3 {
		public void aMethod() {

		}
	}

	// 5
	@Test
	public void lowerPlus1ClassMultplicityWithNominalPropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getGetMethod(GetTestClass3.class, "property", true);
		Method methodB = BeanUtils.getGetMethod(GetTestClass3.class, "property");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 6
	@Test
	public void nominalClassMultplicityWithLowerPropertyWithoutTheMethodNameShouldThrowError() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "", false);
			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 7
	@Test
	public void lowerClassMultplicityWithLowerPropertyWithoutTheMethodNameShouldThrowError() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass2.class, "", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass2.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 8
	@Test
	public void lowerPlus1ClassMultplicityWithlowerPropertyWithoutTheMethodNameShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass3.class, "", false);
			Method methodB = BeanUtils.getGetMethod(GetTestClass3.class, "");
			fail("No Error Thrown");

		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 9
	@Test
	public void nominalClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "a", true);
		Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 10
	@Test
	public void lowerClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getGetMethod(GetTestClass2.class, "a", true);
		Method methodB = BeanUtils.getGetMethod(GetTestClass2.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 11
	@Test
	public void lowerPlus1ClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getGetMethod(GetTestClass3.class, "a", true);
		Method methodB = BeanUtils.getGetMethod(GetTestClass3.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 12
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "else", true);
		Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "else");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 13
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseShouldReturnMethodsForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "proPerty", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "proPerty");
			assertEquals(methodA, GetTestClass1.class.getMethod("getProperty"));
			assertEquals(methodB, GetTestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	// 14
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInSameCaseShouldReturnMethodsForFalseIgnoreCase() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "property", false);
			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "property");
			assertEquals(methodA, GetTestClass1.class.getMethod("getProperty"));
			assertEquals(methodB, GetTestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	public class GetTestClass4 {
		public void setAny() {

		}

		private String getProperty() {
			return "";
		}
	}

	// 15
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInSameCaseButPrivateShouldReturnNullForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass4.class, "property", false);
			Method methodB = BeanUtils.getGetMethod(GetTestClass4.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}

	// 16
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseShouldReturnNullForFalseIgnoreCase() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass1.class, "proPerty", false);
			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "proPerty");
			assertNull(methodA);
			assertEquals(methodB, GetTestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}

	// 17
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseAndPrivateShouldReturnNullForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass4.class, "proPerty", false);
			Method methodB = BeanUtils.getGetMethod(GetTestClass4.class, "proPerty");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}
	
	// 18
//	@Test
//	public void nominalMethodLocation() {
//		try {
//			Class<GetTestClass1> toBeSpy = GetTestClass1.class;
//			Class<GetTestClass1> spy = spy(toBeSpy);
//			Method nonTarget = GetTestClass1.class.getMethod("setAny");
//			Method target = GetTestClass1.class.getMethod("getProperty");
//			Method[] methodList = new Method[] {
//					nonTarget,
//					nonTarget,
//					target,
//					nonTarget,
//					nonTarget
//					};
//			when(spy.getMethods()).thenReturn(methodList);
//			Method methodA = BeanUtils.getGetMethod(spy, "property", true);
//			Method methodB = BeanUtils.getGetMethod(GetTestClass1.class, "property");
//			assertEquals(methodA, target);
//			assertEquals(methodB, target);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Something wrong with test");
//		}
//
//	}
	public class GetTestClass5{
		public void setAny() {
			
		}
		public String getProperty(String str) {
			return "";
		}
	}
	//23
	@Test
	public void classWithRightMethodNameButNoParamenterShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass5.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass5.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}
	public class GetTestClass6{
		public void setAny() {
			
		}
		public void getProperty() {
		}
	}
	//24
	@Test
	public void classWithRightMethodNameButNoReturnShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass5.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass5.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}
	public class GetTestClass7{
		public void setAny() {
			
		}
		
		public String isProperty() {
			return "";
		}
	}
	
	//25
	@Test
	public void classWithRightMethodNameIsButNotBooleanReturnShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass7.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass7.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}
	
	public class GetTestClass8{
		public void setAny() {
			
		}
		
		public boolean isProperty() {
			return true;
		}
	}
	
	//25
	@Test
	public void classWithRightMethodNameIsShouldReturnMethod() {
		try {
			Method methodA = BeanUtils.getGetMethod(GetTestClass8.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(GetTestClass8.class, "property");
			assertEquals( GetTestClass8.class.getMethod("isProperty"), methodA);
			assertEquals(GetTestClass8.class.getMethod("isProperty"), methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}
}
