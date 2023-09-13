package com.xk72.throttle;

import java.io.OutputStream;

public class n extends OutputStream {
  private final OutputStream n;
  
  private final l a;
  
  public n(OutputStream paramOutputStream, l paraml) {
    this.n = paramOutputStream;
    this.a = paraml;
  }
  
  public void write(int paramInt) {
    this.a.a(1);
    long l1 = System.currentTimeMillis();
    this.n.write(paramInt);
    this.a.n(1, l1);
  }
  
  public void write(byte[] paramArrayOfbyte) {
    write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = this.a.a(paramInt2);
    long l1 = System.currentTimeMillis();
    this.n.write(paramArrayOfbyte, paramInt1, i);
    this.a.n(i, l1);
    for (paramInt2 -= i; paramInt2 > 0; paramInt2 -= i) {
      paramInt1 += i;
      i = this.a.a(paramInt2);
      l1 = System.currentTimeMillis();
      this.n.write(paramArrayOfbyte, paramInt1, i);
      this.a.n(i, l1);
    } 
  }
  
  public void close() {
    this.n.close();
  }
  
  public void flush() {
    this.n.flush();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\n.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */