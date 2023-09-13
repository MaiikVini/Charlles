package com.xk72.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class z {
  private static final Logger n = Logger.getLogger("com.xk72.util.JavascriptUtils");
  
  private static final A a = new c();
  
  public static String n(String paramString) {
    if (paramString == null)
      return null; 
    long l = System.currentTimeMillis();
    try {
      return a.n(paramString);
    } finally {
      if (n.isLoggable(Level.FINER))
        n.finer("Formatter returned in " + System.currentTimeMillis() - l + " ms"); 
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\z.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */