package org.jkiss.utils.t4;

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

public class GetMethodsTest {
	public class SetTestClass1 {
		public void setAny() {

		}

		public void setProperty(String str) {

		}
	}

	// 1
	@Test
	public void baseCaseForValiditySetMethods() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "property", true);
			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "property");
			assertEquals(methodA, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
			assertEquals(methodB, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
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

	}

	// 3
	@Test
	public void nominalClassWithNullPropertyName() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, null, true);
			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, null);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

	}

	public class SetTestClass2 {
	}

	// 4
	@Test
	public void lowerClassMultplicityWithNominalPropertyNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(SetTestClass2.class, "property", false);
		Method methodB = BeanUtils.getSetMethod(SetTestClass2.class, "property");
		assertNull(methodA);
		assertNull(methodB);
	}

	public class SetTestClass3 {
		public void aMethod() {

		}
	}

	// 5
	@Test
	public void lowerPlus1ClassMultplicityWithNominalPropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(SetTestClass3.class, "property", true);
		Method methodB = BeanUtils.getSetMethod(SetTestClass3.class, "property");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 6
	@Test
	public void nominalClassMultplicityWithLowerPropertyWithoutTheMethodNameShouldThrowError() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "", false);
			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 7
	@Test
	public void lowerClassMultplicityWithLowerPropertyWithoutTheMethodNameShouldThrowError() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass2.class, "", true);
			Method methodB = BeanUtils.getSetMethod(SetTestClass2.class, "");
			fail("No Error Thrown");
		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 8
	@Test
	public void lowerPlus1ClassMultplicityWithlowerPropertyWithoutTheMethodNameShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass3.class, "", false);
			Method methodB = BeanUtils.getSetMethod(SetTestClass3.class, "");
			fail("No Error Thrown");

		} catch (Exception e) {
			assertEquals(e.getClass(), StringIndexOutOfBoundsException.class);
		}
	}

	// 9
	@Test
	public void nominalClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "a", true);
		Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 10
	@Test
	public void lowerClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(SetTestClass2.class, "a", true);
		Method methodB = BeanUtils.getSetMethod(SetTestClass2.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 11
	@Test
	public void lowerPlus1ClassMultplicityWithlowerPlus1PropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(SetTestClass3.class, "a", true);
		Method methodB = BeanUtils.getSetMethod(SetTestClass3.class, "a");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 12
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithoutTheMethodNameShouldReturnNull() {
		Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "else", true);
		Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "else");
		assertNull(methodA);
		assertNull(methodB);
	}

	// 13
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseShouldReturnMethodsForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "proPerty", true);
			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "proPerty");
			assertEquals(methodA, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
			assertEquals(methodB, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	// 14
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInSameCaseShouldReturnMethodsForFalseIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "property", false);
			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "property");
			assertEquals(methodA, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
			assertEquals(methodB, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}
	}

	public class SetTestClass4 {
		public void setAny() {

		}

		private void setProperty(String str) {

		}
	}

	// 15
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInSameCaseButPrivateShouldReturnNullForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass4.class, "property", false);
			Method methodB = BeanUtils.getSetMethod(SetTestClass4.class, "property");
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
			Method methodA = BeanUtils.getSetMethod(SetTestClass1.class, "proPerty", false);
			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "proPerty");
			assertNull(methodA);
			assertEquals(methodB, SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class }));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}

	// 17
	@Test
	public void nominalClassMultplicityWithnominalPropertyWithTheMethodNameInDifferentCaseAndPrivateShouldReturnNullForTrueIgnoreCase() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass4.class, "proPerty", false);
			Method methodB = BeanUtils.getSetMethod(SetTestClass4.class, "proPerty");
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
//			Class<SetTestClass1> toBeSpy = SetTestClass1.class;
//			Class<SetTestClass1> spy = spy(toBeSpy);
//			Method nonTarget = SetTestClass1.class.getMethod("setAny");
//			Method target = SetTestClass1.class.getMethod("setProperty", new Class<?>[] { String.class });
//			Method[] methodList = new Method[] {
//					nonTarget,
//					nonTarget,
//					target,
//					nonTarget,
//					nonTarget
//					};
//			when(spy.getMethods()).thenReturn(methodList);
//			Method methodA = BeanUtils.getSetMethod(spy, "property", true);
//			Method methodB = BeanUtils.getSetMethod(SetTestClass1.class, "property");
//			assertEquals(methodA, target);
//			assertEquals(methodB, target);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Something wrong with test");
//		}
//
//	}
	public class SetTestClass5{
		public void setAny() {
			
		}
		public void setProperty() {
			
		}
	}
	//23
	@Test
	public void classWithRightMethodNameButNoParamenterShouldReturnNull() {
		try {
			Method methodA = BeanUtils.getSetMethod(SetTestClass5.class, "property", true);
			Method methodB = BeanUtils.getSetMethod(SetTestClass5.class, "property");
			assertNull(methodA);
			assertNull(methodB);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Something wrong with test");
		}

	}
}
