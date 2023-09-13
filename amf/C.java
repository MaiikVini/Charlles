package com.xk72.amf;

import java.util.ArrayList;
import java.util.List;

public class c extends Xsnk {
  private boolean a;
  
  private boolean b;
  
  private final List<String> c = new ArrayList<>();
  
  public c(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramString);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public List<String> b() {
    return this.c;
  }
  
  public void a(String paramString) {
    this.c.add(paramString);
  }
  
  public boolean a() {
    return this.b;
  }
  
  public void n(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public boolean c() {
    return this.a;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public int d() {
    return this.c.size();
  }
  
  public String n(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public boolean b(String paramString) {
    return this.c.contains(paramString);
  }
  
  public int hashCode() {
    byte b = 31;
    null = super.hashCode();
    null = 31 * null + (this.b ? 1231 : 1237);
    null = 31 * null + (this.a ? 1231 : 1237);
    return 31 * null + ((this.c == null) ? 0 : this.c.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!super.equals(paramObject))
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    c c1 = (c)paramObject;
    if (this.b != c1.b)
      return false; 
    if (this.a != c1.a)
      return false; 
    if (this.c == null) {
      if (c1.c != null)
        return false; 
    } else if (!this.c.equals(c1.c)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */