package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.util.B;
import com.xk72.util.C;

@XStreamAlias("descriptor")
@B
@C
public class ProtobufConfiguration$DescriptorFile {
  private String name;
  
  private byte[] desc;
  
  public ProtobufConfiguration$DescriptorFile() {}
  
  public ProtobufConfiguration$DescriptorFile(String paramString, byte[] paramArrayOfbyte) {
    this.name = paramString;
    this.desc = paramArrayOfbyte;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public byte[] getDesc() {
    return this.desc;
  }
  
  public void setDesc(byte[] paramArrayOfbyte) {
    this.desc = paramArrayOfbyte;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ProtobufConfiguration$DescriptorFile.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */