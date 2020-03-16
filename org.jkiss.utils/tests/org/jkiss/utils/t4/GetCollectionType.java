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
public class GetCollectionType {
	
	@Test
	public void nullTypeShouldGetNullAsResult(){
		assertNull(BeanUtils.getCollectionType(null));
	}
	
	@Test
	public void stringTypeShouldGetStringClassAsResult(){
		ParameterizedType parameterizedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{String.class};
            }

            @Override
            public Type getRawType() {
                return null;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        assertEquals(String.class, BeanUtils.getCollectionType(parameterizedType));
	}
	
	@Test
	public void nonWildCardNonClassTypeShouldGetNullAsResult(){
		ParameterizedType parameterizedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{null};
            }

            @Override
            public Type getRawType() {
                return null;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        assertNull(BeanUtils.getCollectionType(parameterizedType));
	}
	
	@Test
	public void wildCardNonClassTypeWithUpperBoundsShouldGetClassAsResult(){
		WildcardType wildcardType = new WildcardType() {
	        @Override
	        public Type[] getUpperBounds() {
	            return new Type[] {String.class};
	        }
	
	        @Override
	        public Type[] getLowerBounds() {
	            return new Type[]{String.class, Integer.class};
	        }
	    };
		ParameterizedType parameterizedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{wildcardType};
            }

            @Override
            public Type getRawType() {
                return null;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        assertEquals(String.class, BeanUtils.getCollectionType(parameterizedType));
	}
	
	@Test
	public void wildCardNonClassTypeWithoutUpperBoundsButWithLowerBoundsShouldGetClassAsResult(){
		WildcardType wildcardType = new WildcardType() {
	        @Override
	        public Type[] getUpperBounds() {
	            return new Type[0];
	        }
	
	        @Override
	        public Type[] getLowerBounds() {
	            return new Type[]{String.class, Integer.class};
	        }
	    };
		ParameterizedType parameterizedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{wildcardType};
            }

            @Override
            public Type getRawType() {
                return null;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        assertEquals(String.class, BeanUtils.getCollectionType(parameterizedType));
	}
	
	@Test
	public void wildCardNonClassTypeWithoutBoundsShouldGetNullAsResult(){
		WildcardType wildcardType = new WildcardType() {
	        @Override
	        public Type[] getUpperBounds() {
	            return new Type[0];
	        }
	
	        @Override
	        public Type[] getLowerBounds() {
	            return new Type[0];
	        }
	    };
		ParameterizedType parameterizedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{wildcardType};
            }

            @Override
            public Type getRawType() {
                return null;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        assertNull(BeanUtils.getCollectionType(parameterizedType));
	}
//	
//	

}
