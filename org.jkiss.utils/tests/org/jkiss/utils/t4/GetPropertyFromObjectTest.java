package org.jkiss.utils.t4;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.lang.Class;


import org.jkiss.utils.BeanUtils;
import org.junit.Test;
public class GetPropertyFromObjectTest {
	public class T1{
		public T1 getLayered() {
			return new T1();
		}
		public String getProperty() {
			return "property";
		}
	}
	
	@Test
	public void nominalObjectNominalPropNameWithFirstLayerShouldGetPropertyResponse() {
		try {
			assertEquals("property", BeanUtils.readObjectProperty(new T1(), "property"));
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	
	@Test
	public void nullObjectNominalPropNameShouldGetError() {
		try {
			BeanUtils.readObjectProperty(null, "property");
		}
		catch(Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}
	
	@Test
	public void nominalObjectNullPropNameShouldGetError() {
		try {
			BeanUtils.readObjectProperty(new T1(), null);
		}
		catch(Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}
	
	@Test
	public void nullObjectEmptyPropNameShouldGetError() {
		try {
			BeanUtils.readObjectProperty(new T1(), "property");
		}
		catch(Exception e) {
			assertEquals(StringIndexOutOfBoundsException.class, e.getClass());
		}
	}
	
	@Test
	public void nominalObjectNominalPropNameWithNoMatchInFirstLayerShouldGetNull() {
		try {
			assertNull(BeanUtils.readObjectProperty(new T1(), "nothing"));
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	
	@Test
	public void nominalObjectNominalPropNameWithNoMatchInSecondLayerShouldGetNull() {
		try {
			assertNull(BeanUtils.readObjectProperty(new T1(), "layered.nothing"));
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	
	@Test
	public void nominalObjectNominalPropNameWithNoMatchInThirdLayerShouldGetNull() {
		try {
			assertNull(BeanUtils.readObjectProperty(new T1(), "layered.layered.nothing"));
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	
	@Test
	public void nominalObjectNominalPropNameWithSecondLayerMatchShouldGetPropertyResponse() {
		try {
			assertEquals("property", BeanUtils.readObjectProperty(new T1(), "layered.property"));
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	
	@Test
	public void nominalObjectNominalPropNameWithThirdLayerMatchShouldGetPropertyResponse() {
		try {
			assertEquals("property", BeanUtils.readObjectProperty(new T1(), "layered.layered.property"));
		}
		catch(Exception e) {
			fail(e.getClass().getName());
		}
	}
	
}
