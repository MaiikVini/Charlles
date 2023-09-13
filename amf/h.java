package com.xk72.amf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class h extends f {
  private static final byte[] r = new byte[] { 13, 10 };
  
  public void n(q paramq, OutputStream paramOutputStream) {
    if (paramq instanceof u) {
      n((u)paramq, paramOutputStream);
    } else {
      super.n(paramq, paramOutputStream);
    } 
  }
  
  private void n(u paramu, OutputStream paramOutputStream) {
    for (j j : paramu.a()) {
      n();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this.p = new C(byteArrayOutputStream);
      c(j.getData());
      this.p.flush();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      n(arrayOfByte.length, paramOutputStream);
      paramOutputStream.write(arrayOfByte);
      n(paramOutputStream);
    } 
    paramOutputStream.close();
  }
  
  private void n(int paramInt, OutputStream paramOutputStream) {
    byte[] arrayOfByte = Integer.toHexString(paramInt).getBytes("ASCII");
    paramOutputStream.write(arrayOfByte);
    paramOutputStream.write(r);
  }
  
  private void n(OutputStream paramOutputStream) {
    paramOutputStream.write(r);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\h.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */