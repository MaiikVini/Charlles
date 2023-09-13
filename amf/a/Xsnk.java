package com.xk72.amf.a;

import com.xk72.amf.AMFMixedArray;

public class Xsnk {
  private final String n;
  
  private final AMFMixedArray a;
  
  public Xsnk(String paramString, AMFMixedArray paramAMFMixedArray) {
    this.n = paramString;
    this.a = paramAMFMixedArray;
  }
  
  public String n() {
    return this.n;
  }
  
  public AMFMixedArray a() {
    return this.a;
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(this.n);
    stringBuffer.append(": ");
    stringBuffer.append(this.a);
    return stringBuffer.toString();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\a\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */