package org.jkiss.utils.t4;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import removedTests.GetGetMethodTest.TestClass1;
import removedTests.GetGetMethodTest.TestClass2;
import removedTests.GetGetMethodTest.TestClass4;
import removedTests.GetGetMethodTest.TestClass5;

import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

import org.jkiss.utils.BeanUtils;
import org.junit.Test;

public class GetMethodTest {
	public class TestClass1 {
		public void setAny() {

		}

		public void setProperty(String str) {

		}
		
		public String getProperty() {
			return "";
		}
	}

	// 1
	@Test
	public void baseCaseForValiditySetMethods() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass1.class, "property", true);
			Method methodB = BeanUtils.getSetMethod(TestClass1.class, "property");
			assertEquals(methodA, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
			assertEquals(methodB, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass1.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(TestClass1.class, "property");
			assertEquals(methodA, TestClass1.class.getMethod("getProperty"));
			assertEquals(methodB, TestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}

	// 2
	@Test
	public void invalidClassWithNominalPropertyName() {
		try {
			Method methodA = BeanUtils.getSetMethod(null, "property", true);
			Method methodB = BeanUtils.getSetMethod(null, "property");
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
		
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
			Method methodA = BeanUtils.getSetMethod(TestClass1.class, null, true);
			Method methodB = BeanUtils.getSetMethod(TestClass1.class, null);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass1.class, null, true);
			Method methodB = BeanUtils.getGetMethod(TestClass1.class, null);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}


	}

	public class TestClass2 {
	}

	// 4
	@Test
	public void lowerClassMultplicityWithNominalPropertyNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(TestClass2.class, "property", false);
		Method methodB = BeanUtils.getSetMethod(TestClass2.class, "property");
		assertNull(methodA);
		assertNull(methodB);
		
		methodA = BeanUtils.getGetMethod(TestClass2.class, "property", false);
		methodB = BeanUtils.getGetMethod(TestClass2.class, "property");
		assertNull(methodA);
		assertNull(methodB);
	}



	// 6
	@Test
	public void nominalClassMultplicityWithLowerPropertyWithoutTheMethodNameShouldThrowError() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass1.class, "", false);
			Method methodB = BeanUtils.getSetMethod(TestClass1.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass1.class, "", false);
			Method methodB = BeanUtils.getGetMethod(TestClass1.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 7
	@Test
	public void lowerClassMultplicityWithLowerPropertyWithoutTheMethodNameShouldThrowError() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass2.class, "", true);
			Method methodB = BeanUtils.getSetMethod(TestClass2.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass2.class, "", true);
			Method methodB = BeanUtils.getGetMethod(TestClass2.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}


	// 9
	@Test
	public void nominalClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(TestClass1.class, "a", true);
		Method methodB = BeanUtils.getSetMethod(TestClass1.class, "a");
		assertNull(methodA);
		assertNull(methodB);
		
		methodA = BeanUtils.getGetMethod(TestClass1.class, "a", true);
		methodB = BeanUtils.getGetMethod(TestClass1.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}
	

	// 10
	@Test
	public void lowerClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(TestClass2.class, "a", true);
		Method methodB = BeanUtils.getSetMethod(TestClass2.class, "a");
		assertNull(methodA);
		assertNull(methodB);
		
		methodA = BeanUtils.getGetMethod(TestClass2.class, "a", true);
		methodB = BeanUtils.getGetMethod(TestClass2.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}


	// 12
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(TestClass1.class, "else", true);
		Method methodB = BeanUtils.getSetMethod(TestClass1.class, "else");
		assertNull(methodA);
		assertNull(methodB);
		
		methodA = BeanUtils.getGetMethod(TestClass1.class, "else", true);
		methodB = BeanUtils.getGetMethod(TestClass1.class, "else");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 13
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseShouldReturnMethodsForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass1.class, "proPerty", true);
			Method methodB = BeanUtils.getSetMethod(TestClass1.class, "proPerty");
			assertEquals(methodA, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
			assertEquals(methodB, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass1.class, "proPerty", true);
			Method methodB = BeanUtils.getGetMethod(TestClass1.class, "proPerty");
			assertEquals(methodA, TestClass1.class.getMethod("getProperty"));
			assertEquals(methodB, TestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	// 14
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInSameCaseShouldReturnMethodsForFalseIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass1.class, "property", false);
			Method methodB = BeanUtils.getSetMethod(TestClass1.class, "property");
			assertEquals(methodA, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
			assertEquals(methodB, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass1.class, "property", false);
			Method methodB = BeanUtils.getGetMethod(TestClass1.class, "property");
			assertEquals(methodA, TestClass1.class.getMethod("getProperty"));
			assertEquals(methodB, TestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	public class TestClass4 {
		public void setAny() {

		}

		private void setProperty(String str) {

		}
		
		private String getProperty() {
			return "";
		}
	}

	// 15
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInSameCaseButPrivateShouldReturnNullForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass4.class, "property", false);
			Method methodB = BeanUtils.getSetMethod(TestClass4.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass4.class, "property", false);
			Method methodB = BeanUtils.getGetMethod(TestClass4.class, "property");
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
			Method methodA = BeanUtils.getSetMethod(TestClass1.class, "proPerty", false);
			Method methodB = BeanUtils.getSetMethod(TestClass1.class, "proPerty");
			assertNull(methodA);
			assertEquals(methodB, TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass1.class, "proPerty", false);
			Method methodB = BeanUtils.getGetMethod(TestClass1.class, "proPerty");
			assertNull(methodA);
			assertEquals(methodB, TestClass1.class.getMethod("getProperty"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}

	// 17
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseAndPrivateShouldReturnNullForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass4.class, "proPerty", false);
			Method methodB = BeanUtils.getSetMethod(TestClass4.class, "proPerty");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass4.class, "proPerty", false);
			Method methodB = BeanUtils.getGetMethod(TestClass4.class, "proPerty");
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
//			Class<TestClass1> toBeSpy = TestClass1.class;
//			Class<TestClass1> spy = spy(toBeSpy);
//			Method nonTarget = TestClass1.class.getMethod("setAny");
//			Method target = TestClass1.class.getMethod("setProperty", new Class<?>[] { String.class });
//			Method[] methodList = new Method[] {
//					nonTarget,
//					nonTarget,
//					target,
//					nonTarget,
//					nonTarget
//					};
//			when(spy.getMethods()).thenReturn(methodList);
//			Method methodA = BeanUtils.getSetMethod(spy, "property", true);
//			Method methodB = BeanUtils.getSetMethod(TestClass1.class, "property");
//			assertEquals(methodA, target);
//			assertEquals(methodB, target);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Something wrong with test");
//		}
//
//	}
	public class TestClass5{
		public void setAny() {
			
		}
		public void setProperty() {
			
		}
		public String getProperty(String str) {
			return "";
		}
	}
	//23
	@Test
	public void classWithRightMethodNameButNoParamenterShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass5.class, "property", true);
			Method methodB = BeanUtils.getSetMethod(TestClass5.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass5.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(TestClass5.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}
	
	public class TestClass9{
		
		public void setProperty(String property) {
		}
		
		public void getProperty() {
		}
	}
	
	//18
	@Test
	public void classWithOneAndOnlyOneRightMethodNameShouldReturnTheMethod() {
		try {
			Method methodA = BeanUtils.getSetMethod(TestClass9.class, "property", true);
			Method methodB = BeanUtils.getSetMethod(TestClass9.class, "property");
			assertEquals(TestClass9.class.getMethod("setProperty", new Class<?>[] { String.class }), methodA);
			assertEquals(TestClass9.class.getMethod("setProperty", new Class<?>[] { String.class }), methodB);
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	public class TestClass7 {
		public void setAny() {

		}

		public String isProperty() {
			return "";
		}
	}

	// 25
	@Test
	public void classWithRightMethodNameIsButNotBooleanReturnShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass7.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(TestClass7.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
		
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass5.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(TestClass5.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	public class TestClass8 {
		public void setAny() {

		}

		public boolean isProperty() {
			return true;
		}
	}

	// 25
	@Test
	public void classWithRightMethodNameIsShouldReturnMethod() {
		try {
			Method methodA = BeanUtils.getGetMethod(TestClass8.class, "property", true);
			Method methodB = BeanUtils.getGetMethod(TestClass8.class, "property");
			assertEquals(TestClass8.class.getMethod("isProperty"), methodA);
			assertEquals(TestClass8.class.getMethod("isProperty"), methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

}
