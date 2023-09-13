package com.xk72.amf;

import com.xk72.util.w;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class g extends e {
  public q n(InputStream paramInputStream) {
    byte[] arrayOfByte = new byte[8192];
    PushbackInputStream pushbackInputStream = new PushbackInputStream(paramInputStream, arrayOfByte.length);
    try {
      int i = w.n(pushbackInputStream, arrayOfByte);
      try {
        b(new ByteArrayInputStream(arrayOfByte, 0, i));
        pushbackInputStream.unread(arrayOfByte, 0, i);
      } catch (IOException iOException) {
        pushbackInputStream.unread(arrayOfByte, 0, i);
        q q = super.n(pushbackInputStream);
        pushbackInputStream.close();
        return q;
      } 
      u u1 = new u();
      int j;
      for (j = b(pushbackInputStream); j != -1; j = b(pushbackInputStream)) {
        byte[] arrayOfByte1 = new byte[j];
        w.n(pushbackInputStream, arrayOfByte1);
        c(pushbackInputStream);
        this.p = new B(new ByteArrayInputStream(arrayOfByte1));
        n();
        Object object = f();
        u1.n(new j(null, null, object));
      } 
      u u2 = u1;
      pushbackInputStream.close();
      return u2;
    } catch (Throwable throwable) {
      try {
        pushbackInputStream.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      } 
      throw throwable;
    } 
  }
  
  private int b(InputStream paramInputStream) {
    int i;
    for (i = paramInputStream.read(); i == 0; i = paramInputStream.read());
    if (i == -1)
      return -1; 
    byte[] arrayOfByte = new byte[4];
    byte b = 0;
    arrayOfByte[b++] = (byte)i;
    for (i = paramInputStream.read(); i != 13; i = paramInputStream.read()) {
      if (b == arrayOfByte.length)
        throw new AMFException("Invalid chunk header format"); 
      arrayOfByte[b++] = (byte)i;
    } 
    i = paramInputStream.read();
    if (i == 10)
      try {
        return Integer.parseInt(new String(arrayOfByte, 0, b, "ASCII"), 16);
      } catch (NumberFormatException numberFormatException) {
        throw new AMFException("Invalid chunk header format: " + numberFormatException);
      }  
    throw new AMFException("Invalid chunk header format");
  }
  
  private void c(InputStream paramInputStream) {
    if (paramInputStream.read() != 13)
      throw new AMFException("Invalid chunk footer"); 
    if (paramInputStream.read() != 10)
      throw new AMFException("Invalid chunk footer"); 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\g.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */