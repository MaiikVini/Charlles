package com.xk72.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.xk72.util.r;
import java.io.InputStream;

class e implements r<DescriptorProtos.FileDescriptorSet, Descriptors.DescriptorValidationException> {
  e(d paramd) {}
  
  public DescriptorProtos.FileDescriptorSet n(InputStream paramInputStream) {
    return DescriptorProtos.FileDescriptorSet.parseFrom(paramInputStream);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\e.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */