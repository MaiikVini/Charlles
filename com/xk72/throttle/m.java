package com.xk72.throttle;

import com.xk72.proxy.io.e;
import java.io.InputStream;

public class m extends InputStream implements e {
  private final InputStream n;
  
  private final l a;
  
  public m(InputStream paramInputStream, l paraml) {
    this.n = paramInputStream;
    this.a = paraml;
  }
  
  public InputStream h() {
    return this.n;
  }
  
  public int read() {
    long l1 = System.currentTimeMillis();
    int i = this.n.read();
    if (i == -1)
      return i; 
    this.a.n(1, l1);
    this.a.a(1);
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte) {
    return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException(); 
    if (paramInt2 == 0)
      return paramInt2; 
    if (paramInt2 == 1) {
      int k = read();
      if (k < 0)
        return k; 
      paramArrayOfbyte[paramInt1] = (byte)k;
      return 1;
    } 
    long l1 = System.currentTimeMillis();
    int i = this.n.read();
    if (i < 0)
      return i; 
    this.a.n(1, l1);
    paramArrayOfbyte[paramInt1] = (byte)i;
    int j = this.a.a(paramInt2);
    if (j == paramInt2)
      j--; 
    if (this.n.available() == 0)
      return 1; 
    l1 = System.currentTimeMillis();
    byte b = (j == 0) ? 0 : this.n.read(paramArrayOfbyte, paramInt1 + 1, j);
    if (b)
      return 1; 
    this.a.n(b, l1);
    return b + 1;
  }
  
  public boolean markSupported() {
    return this.n.markSupported();
  }
  
  public void mark(int paramInt) {
    this.n.mark(paramInt);
  }
  
  public int available() {
    return this.n.available();
  }
  
  public void close() {
    this.n.close();
  }
  
  public void reset() {
    this.n.reset();
  }
  
  public long skip(long paramLong) {
    return this.n.skip(paramLong);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\m.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */