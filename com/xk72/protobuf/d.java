package com.xk72.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.xk72.util.p;
import com.xk72.util.q;
import com.xk72.util.u;
import java.net.URI;

public class d {
  private final p<DescriptorProtos.FileDescriptorSet, Descriptors.DescriptorValidationException> n = new p((q)new u(), new e(this));
  
  private b a;
  
  public d(b paramb) {
    this.a = paramb;
  }
  
  public p<DescriptorProtos.FileDescriptorSet, Descriptors.DescriptorValidationException> n() {
    return this.n;
  }
  
  public g a() {
    return this.a.a();
  }
  
  public g n(boolean paramBoolean, long paramLong, String paramString) {
    return n(a(), paramBoolean, paramLong, paramString);
  }
  
  public g n(g paramg, boolean paramBoolean, long paramLong, String paramString) {
    i[] arrayOfI1 = paramg.a();
    URI[] arrayOfURI = n(paramString);
    i[] arrayOfI2 = new i[arrayOfI1.length + arrayOfURI.length];
    System.arraycopy(arrayOfI1, 0, arrayOfI2, 0, arrayOfI1.length);
    for (byte b1 = 0; b1 < arrayOfURI.length; b1++)
      arrayOfI2[arrayOfI1.length + b1] = new i((DescriptorProtos.FileDescriptorSet)this.n.n(arrayOfURI[b1], paramBoolean, paramLong), arrayOfURI[b1]); 
    return new g(new f(this, paramBoolean, paramLong), arrayOfI2);
  }
  
  private URI[] n(String paramString) {
    String[] arrayOfString = paramString.trim().split(" ");
    URI[] arrayOfURI = new URI[arrayOfString.length];
    for (byte b1 = 0; b1 < arrayOfURI.length; b1++)
      arrayOfURI[b1] = new URI(arrayOfString[b1].trim()); 
    return arrayOfURI;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\d.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */