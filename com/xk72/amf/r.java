package com.xk72.amf;

public class r implements s, t {
  private int n;
  
  private s a;
  
  public r(int paramInt) {
    this.n = paramInt;
  }
  
  public r(int paramInt, s params) {
    this(paramInt);
    this.a = params;
  }
  
  public String getType() {
    return (this.a != null) ? (this.a.getType() + " Reference") : "Unbound Reference";
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
  
  public void n(s params) {
    this.a = params;
  }
  
  public String toString() {
    return (this.a != null) ? ("<Reference to " + this.a.getType() + " (#" + this.n + ")>") : ("<Unresolved reference to #" + this.n + ">");
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\r.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */