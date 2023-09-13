package com.xk72.amf;

public class o extends n implements t {
  private int n;
  
  private final n a;
  
  public o(int paramInt, n paramn) {
    super(paramn);
    this.n = paramInt;
    this.a = paramn;
  }
  
  public String getType() {
    return "Date Reference";
  }
  
  public int b() {
    return this.n;
  }
  
  public void a(int paramInt) {
    this.n = paramInt;
  }
  
  public s c() {
    return this.a;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\o.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */