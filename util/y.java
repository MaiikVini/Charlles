package com.xk72.util;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class y extends Inflater {
  public y() {}
  
  public y(boolean paramBoolean) {
    super(paramBoolean);
  }
  
  public int inflate(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return super.inflate(paramArrayOfbyte, paramInt1, paramInt2);
    } catch (OutOfMemoryError outOfMemoryError) {
      throw new DataFormatException("Possibly corrupt ZLIB compressed stream detected (caused out of memory condition while inflating)");
    } 
  }
  
  public int inflate(byte[] paramArrayOfbyte) {
    try {
      return super.inflate(paramArrayOfbyte);
    } catch (OutOfMemoryError outOfMemoryError) {
      throw new DataFormatException("Possibly corrupt ZLIB compressed stream detected (caused out of memory condition while inflating)");
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\y.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */