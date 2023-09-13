package com.xk72.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

public class n {
  public static Class<?> n(Class<?> paramClass1, Class<?> paramClass2) {
    return n(paramClass1, paramClass2, 0);
  }
  
  public static Class<?> n(Class<?> paramClass1, Class<?> paramClass2, int paramInt) {
    Type type = a(paramClass1, paramClass2, paramInt);
    return (type instanceof Class) ? (Class)type : null;
  }
  
  public static Type a(Class<?> paramClass1, Class<?> paramClass2) {
    return a(paramClass1, paramClass2, 0);
  }
  
  public static Type a(Class<?> paramClass1, Class<?> paramClass2, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (Class<?> clazz = paramClass1; clazz != null; clazz = clazz1) {
      for (Type type : clazz.getGenericInterfaces()) {
        if (type instanceof ParameterizedType && ((ParameterizedType)type).getRawType().equals(paramClass2)) {
          Type type1;
          for (type1 = ((ParameterizedType)type).getActualTypeArguments()[paramInt]; type1 instanceof TypeVariable; type1 = (Type)hashMap.get(type1));
          return type1;
        } 
      } 
      Class<?> clazz1 = clazz.getSuperclass();
      if (clazz1 != null) {
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
          Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
          TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz1.getTypeParameters();
          for (byte b = 0; b < arrayOfType.length; b++)
            hashMap.put(arrayOfTypeVariable[b], arrayOfType[b]); 
        } 
      } 
    } 
    return null;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\n.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */