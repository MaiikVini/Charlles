package com.xk72.lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;

public class Xsnk {
  private static ClassLoader n;
  
  public static ClassLoader n() {
    if (n == null) {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      if (classLoader instanceof URLClassLoader) {
        G g = new G((URLClassLoader)classLoader);
        classLoader = g;
      } 
      n = classLoader;
    } 
    return n;
  }
  
  public static void n(String paramString, String[] paramArrayOfString, ClassLoader paramClassLoader) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      Thread.currentThread().setContextClassLoader(paramClassLoader);
      Class<?> clazz = paramClassLoader.loadClass(paramString);
      Method method = clazz.getMethod("main", new Class[] { String[].class });
      try {
        method.invoke(null, new Object[] { paramArrayOfString });
      } catch (InvocationTargetException invocationTargetException) {
        throw invocationTargetException.getTargetException();
      } 
    } finally {
      Thread.currentThread().setContextClassLoader(classLoader);
    } 
  }
  
  public static void n(String paramString, ClassLoader paramClassLoader) {
    Class<?> clazz = paramClassLoader.loadClass(paramString);
    Object object = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    Method method = clazz.getMethod("run", (Class[])null);
    try {
      method.invoke(object, (Object[])null);
    } catch (InvocationTargetException invocationTargetException) {
      throw invocationTargetException.getTargetException();
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */