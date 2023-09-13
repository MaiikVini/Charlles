package com.xk72.protobuf;

import com.google.protobuf.DescriptorProtos;
import java.net.URI;

public class i {
  public final DescriptorProtos.FileDescriptorSet n;
  
  public final String a;
  
  public final URI b;
  
  public i(DescriptorProtos.FileDescriptorSet paramFileDescriptorSet, String paramString) {
    this(paramFileDescriptorSet, paramString, null);
    if (paramString == null)
      throw new NullPointerException(); 
  }
  
  public i(DescriptorProtos.FileDescriptorSet paramFileDescriptorSet, URI paramURI) {
    this(paramFileDescriptorSet, null, paramURI);
    if (paramURI == null)
      throw new NullPointerException(); 
  }
  
  public i(DescriptorProtos.FileDescriptorSet paramFileDescriptorSet, String paramString, URI paramURI) {
    if (paramFileDescriptorSet == null)
      throw new NullPointerException(); 
    this.n = paramFileDescriptorSet;
    this.a = paramString;
    this.b = paramURI;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\i.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */