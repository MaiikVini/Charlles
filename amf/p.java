package com.xk72.amf;

public class p {
  private String n;
  
  private boolean a;
  
  private Object b;
  
  public p(String paramString, boolean paramBoolean, Object paramObject) {
    this.n = paramString;
    this.a = paramBoolean;
    this.b = paramObject;
  }
  
  public Object getContent() {
    return this.b;
  }
  
  public void setContent(Object paramObject) {
    this.b = paramObject;
  }
  
  public String getName() {
    return this.n;
  }
  
  public void setName(String paramString) {
    this.n = paramString;
  }
  
  public boolean isMustUnderstand() {
    return this.a;
  }
  
  public void setMustUnderstand(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public String toString() {
    return "NAME: " + this.n + "\nMUST UNDERSTAND: " + this.a + "\nCONTENT:\n" + this.b;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\p.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */