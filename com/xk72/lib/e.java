package com.xk72.lib;

public class e implements Comparable<e> {
  private Integer n;
  
  private Integer a;
  
  private Integer b;
  
  private Integer c;
  
  public e(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4) {
    this.n = paramInteger1;
    this.a = paramInteger2;
    this.b = paramInteger3;
    this.c = paramInteger4;
  }
  
  public e(Integer[] paramArrayOfInteger) {
    n(paramArrayOfInteger);
  }
  
  public e(String paramString) {
    String[] arrayOfString = paramString.split("(\\.|_)");
    Integer[] arrayOfInteger = new Integer[arrayOfString.length];
    for (byte b = 0; b < arrayOfString.length; b++) {
      try {
        arrayOfInteger[b] = Integer.valueOf(Integer.parseInt(arrayOfString[b]));
      } catch (NumberFormatException numberFormatException) {}
    } 
    n(arrayOfInteger);
  }
  
  private void n(Integer[] paramArrayOfInteger) {
    this.n = (paramArrayOfInteger.length > 0) ? paramArrayOfInteger[0] : null;
    this.a = (paramArrayOfInteger.length > 1) ? paramArrayOfInteger[1] : null;
    this.b = (paramArrayOfInteger.length > 2) ? paramArrayOfInteger[2] : null;
    this.c = (paramArrayOfInteger.length > 3) ? paramArrayOfInteger[3] : null;
  }
  
  public boolean n(String paramString) {
    e e1 = new e(paramString);
    return (n(e1) >= 0);
  }
  
  public boolean a(String paramString) {
    e e1 = new e(paramString);
    return (n(e1) != 0);
  }
  
  public Integer n() {
    return this.n;
  }
  
  public Integer a() {
    return this.a;
  }
  
  public Integer b() {
    return this.b;
  }
  
  public Integer c() {
    return this.c;
  }
  
  public static e d() {
    return new e(System.getProperty("java.version"));
  }
  
  public static e e() {
    return new e(System.getProperty("os.version"));
  }
  
  public int n(e parame) {
    if (n() != null && parame.n() != null) {
      if (n().intValue() < parame.n().intValue())
        return -1; 
      if (n().intValue() > parame.n().intValue())
        return 1; 
    } 
    if (a() != null && parame.a() != null) {
      if (a().intValue() < parame.a().intValue())
        return -1; 
      if (a().intValue() > parame.a().intValue())
        return 1; 
    } 
    if (b() != null && parame.b() != null) {
      if (b().intValue() < parame.b().intValue())
        return -1; 
      if (b().intValue() > parame.b().intValue())
        return 1; 
    } 
    if (c() != null && parame.c() != null) {
      if (c().intValue() < parame.c().intValue())
        return -1; 
      if (c().intValue() > parame.c().intValue())
        return 1; 
    } 
    return 0;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\e.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */