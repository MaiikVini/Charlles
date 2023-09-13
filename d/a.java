package com.xk72.d;

import java.io.InputStream;

public class a extends Xsnk {
  public a(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  public a(InputStream paramInputStream, boolean paramBoolean) {
    super(paramInputStream, paramBoolean);
  }
  
  public int read() {
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void close() {
    this.in.close();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\d\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */