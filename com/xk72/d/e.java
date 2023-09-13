package com.xk72.d;

import java.io.EOFException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class e extends GZIPInputStream {
  public e(InputStream paramInputStream, int paramInt) {
    super(paramInputStream, paramInt);
  }
  
  public e(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return super.read(paramArrayOfbyte, paramInt1, paramInt2);
    } catch (EOFException eOFException) {
      return -1;
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\d\e.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */