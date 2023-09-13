package com.xk72.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class g {
  public static <T> List<T> n() {
    return Collections.EMPTY_LIST;
  }
  
  public static <K, V> Map<K, V> a() {
    return Collections.EMPTY_MAP;
  }
  
  @SafeVarargs
  public static <T> List<T> n(T... paramVarArgs) {
    return new h<>((Object[])paramVarArgs);
  }
  
  public static <T> List<T> n(List<T> paramList, T paramT) {
    Object[] arrayOfObject = paramList.toArray(new Object[paramList.size() + 1]);
    arrayOfObject[arrayOfObject.length - 1] = paramT;
    return new h<>(arrayOfObject);
  }
  
  public static <T> List<T> a(List<T> paramList, T paramT) {
    int i = paramList.lastIndexOf(paramT);
    if (i < 0)
      return paramList; 
    Object[] arrayOfObject = new Object[paramList.size() - 1];
    byte b1 = 0;
    for (byte b2 = 0; b2 < paramList.size(); b2++) {
      if (b2 != i)
        arrayOfObject[b1++] = paramList.get(b2); 
    } 
    return new h<>(arrayOfObject);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\g.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */