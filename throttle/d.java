package com.xk72.throttle;

import java.io.IOException;
import java.io.OutputStream;

class d extends e<d> implements g {
  private final OutputStream c;
  
  private LatencyOutputStream$Action d;
  
  private int e;
  
  private byte[] f;
  
  public d(OutputStream paramOutputStream) {
    this.c = paramOutputStream;
  }
  
  public int n() {
    return (this.f == null) ? 1 : this.f.length;
  }
  
  public void a() {
    this.f = null;
  }
  
  public void b() {
    try {
      switch (c.n[this.d.ordinal()]) {
        case 1:
          this.c.flush();
          break;
        case 2:
          this.c.write(this.e);
          break;
        case 3:
          this.c.write(this.f, 0, this.e);
          break;
      } 
    } catch (IOException iOException) {
      throw new LatentExecutor$FatalException(iOException);
    } 
  }
  
  public void c() {
    this.d = LatencyOutputStream$Action.n;
  }
  
  public void n(int paramInt) {
    this.d = LatencyOutputStream$Action.a;
    this.e = paramInt;
  }
  
  public void n(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.d = LatencyOutputStream$Action.b;
    this.e = paramInt2;
    if (this.f == null || this.f.length < paramInt2)
      this.f = new byte[paramInt2]; 
    System.arraycopy(paramArrayOfbyte, paramInt1, this.f, 0, paramInt2);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\d.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */