package com.xk72.protobuf;

import com.google.protobuf.DescriptorProtos;
import java.io.InputStream;

public class b {
  private volatile G n = b();
  
  public void n() {
    this.n = b();
  }
  
  private G b() {
    try {
      i i1 = n("google.protobuf.desc");
      i i2 = n("unknown.desc");
      return new G(new i[] { i1, i2 });
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  private i n(String paramString) {
    InputStream inputStream = b.class.getResourceAsStream(paramString);
    try {
      i i = new i(DescriptorProtos.FileDescriptorSet.parseFrom(inputStream), paramString);
      if (inputStream != null)
        inputStream.close(); 
      return i;
    } catch (Throwable throwable) {
      if (inputStream != null)
        try {
          inputStream.close();
        } catch (Throwable throwable1) {
          throwable.addSuppressed(throwable1);
        }  
      throw throwable;
    } 
  }
  
  public g a() {
    return this.n;
  }
  
  public synchronized i n(String paramString, InputStream paramInputStream) {
    i i = new i(DescriptorProtos.FileDescriptorSet.parseFrom(paramInputStream), paramString);
    i[] arrayOfI1 = this.n.a();
    i[] arrayOfI2 = new i[arrayOfI1.length + 1];
    System.arraycopy(arrayOfI1, 0, arrayOfI2, 0, arrayOfI1.length);
    arrayOfI2[arrayOfI1.length] = i;
    G g = new G(arrayOfI2);
    this.n = g;
    return i;
  }
  
  public synchronized void n(i parami) {
    i[] arrayOfI1 = this.n.a();
    i[] arrayOfI2 = new i[arrayOfI1.length - 1];
    byte b1 = 0;
    for (i i1 : arrayOfI1) {
      if (!i1.equals(parami))
        if (b1 < arrayOfI2.length) {
          arrayOfI2[b1++] = i1;
        } else {
          throw new IllegalStateException("Descriptor set was not found");
        }  
    } 
    G g = new G(arrayOfI2);
    this.n = g;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */