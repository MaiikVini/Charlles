package com.xk72.d;

import com.xk72.util.Xsnk;
import java.io.IOException;
import java.io.InputStream;

public class d implements Runnable {
  private final InputStream n;
  
  public static void n(InputStream paramInputStream) {
    d d1 = new d(paramInputStream);
    Xsnk.n(d1);
  }
  
  private d(InputStream paramInputStream) {
    this.n = paramInputStream;
  }
  
  public void run() {
    try {
      byte[] arrayOfByte = new byte[8192];
      try {
        for (int i = this.n.read(arrayOfByte); i != -1; i = this.n.read(arrayOfByte));
      } finally {
        this.n.close();
      } 
    } catch (IOException iOException) {}
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\d\d.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */