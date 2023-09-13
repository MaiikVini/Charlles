package com.xk72.amf;

import java.text.DateFormat;
import java.util.Date;

public class n implements s {
  private Date n;
  
  private int a;
  
  public n(Date paramDate) {
    this(paramDate, 0);
  }
  
  public n(Date paramDate, int paramInt) {
    this.n = paramDate;
    this.a = paramInt;
  }
  
  public n(n paramn) {
    this.n = paramn.n;
    this.a = paramn.a;
  }
  
  public static n valueOf(String paramString) {
    DateFormat dateFormat = DateFormat.getDateTimeInstance(2, 2);
    Date date = dateFormat.parse(paramString);
    return new n(date);
  }
  
  public String getType() {
    return "Date";
  }
  
  public Date n() {
    return this.n;
  }
  
  public void n(Date paramDate) {
    this.n = paramDate;
  }
  
  public int a() {
    return this.a;
  }
  
  public void n(int paramInt) {
    this.a = paramInt;
  }
  
  public String toString() {
    DateFormat dateFormat = DateFormat.getDateTimeInstance(2, 2);
    return (this.n != null) ? dateFormat.format(this.n) : null;
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
    n n1 = (n)paramObject;
    if (this.n == null) {
      if (n1.n != null)
        return false; 
    } else if (!this.n.equals(n1.n)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\n.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */