package com.xk72.amf;

public class k implements s {
  private byte[] n;
  
  public k() {}
  
  public k(byte[] paramArrayOfbyte) {
    this.n = paramArrayOfbyte;
  }
  
  public String getType() {
    return "Byte Array";
  }
  
  public byte[] n() {
    return this.n;
  }
  
  public void n(byte[] paramArrayOfbyte) {
    this.n = paramArrayOfbyte;
  }
  
  public String toString() {
    if (this.n != null) {
      StringBuffer stringBuffer = new StringBuffer();
      for (byte b : this.n)
        stringBuffer.append(n(b)); 
      return stringBuffer.toString();
    } 
    return null;
  }
  
  private static String n(int paramInt) {
    if (paramInt < 0)
      paramInt = 256 + paramInt; 
    return (paramInt < 16) ? ("0" + Integer.toHexString(paramInt)) : Integer.toHexString(paramInt);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\k.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */