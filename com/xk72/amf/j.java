package com.xk72.amf;

public class j {
  private String n;
  
  private String a;
  
  private Object b;
  
  public j(String paramString1, String paramString2, Object paramObject) {
    this.n = paramString1;
    this.a = paramString2;
    this.b = paramObject;
  }
  
  public Object getData() {
    return this.b;
  }
  
  public void setData(Object paramObject) {
    this.b = paramObject;
  }
  
  public String getResponse() {
    return this.a;
  }
  
  public void setResponse(String paramString) {
    this.a = paramString;
  }
  
  public String getTarget() {
    return this.n;
  }
  
  public void setTarget(String paramString) {
    this.n = paramString;
  }
  
  public String toString() {
    return "TARGET: " + this.n + "\nRESPONSE: " + this.a + "\nDATA:\n" + this.b;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\j.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */