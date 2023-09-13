package com.xk72.amf;

public class Xsnk implements l {
  protected String n;
  
  public Xsnk(String paramString) {
    this.n = paramString;
  }
  
  public String n() {
    return this.n;
  }
  
  public void n(String paramString) {
    this.n = paramString;
  }
  
  public boolean a() {
    return true;
  }
  
  public int hashCode() {
    byte b = 31;
    null = 1;
    return 31 * null + ((this.n == null) ? 0 : this.n.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    Xsnk xsnk = (Xsnk)paramObject;
    if (this.n == null) {
      if (xsnk.n != null)
        return false; 
    } else if (!this.n.equals(xsnk.n)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */