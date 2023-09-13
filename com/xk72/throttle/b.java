package com.xk72.throttle;

import com.xk72.proxy.io.g;
import java.io.IOException;
import java.io.InputStream;

class b extends e<b> implements g {
  private final g c;
  
  private final byte[] d = new byte[28960];
  
  private int e = 0;
  
  public b(g paramg) {
    this.c = paramg;
  }
  
  public int n() {
    return this.d.length;
  }
  
  public void a() {}
  
  public int n(InputStream paramInputStream) {
    this.e = paramInputStream.read(this.d);
    return this.e;
  }
  
  public void b() {
    if (this.e < 0) {
      this.c.a();
    } else if (this.e > 0) {
      try {
        this.c.n(this.d, 0, this.e);
      } catch (IOException iOException) {
        throw new LatentExecutor$FatalException(iOException);
      } 
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */