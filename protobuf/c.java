package com.xk72.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class c {
  private final Descriptors.Descriptor n;
  
  private final Xsnk a;
  
  public c(Descriptors.Descriptor paramDescriptor, Xsnk paramXsnk) {
    this.n = paramDescriptor;
    this.a = paramXsnk;
  }
  
  public boolean n() {
    return false;
  }
  
  public Xsnk a() {
    return this.a;
  }
  
  public Descriptors.Descriptor b() {
    return this.n;
  }
  
  public Message n(JsonFormat.TypeRegistry paramTypeRegistry, Reader paramReader) {
    DynamicMessage.Builder builder = DynamicMessage.newBuilder(this.n);
    JsonFormat.parser().usingTypeRegistry(paramTypeRegistry).merge(paramReader, (Message.Builder)builder);
    return n((Message)builder.buildPartial());
  }
  
  public Message n(InputStream paramInputStream) {
    return n((Message)DynamicMessage.parseFrom(this.n, paramInputStream, this.a.a()));
  }
  
  public List<Message> n(InputStream paramInputStream, boolean paramBoolean) {
    ArrayList<Message> arrayList = new ArrayList();
    if (paramBoolean) {
      while (true) {
        DynamicMessage.Builder builder = DynamicMessage.newBuilder(this.n);
        if (builder.mergeDelimitedFrom(paramInputStream, (ExtensionRegistryLite)this.a.a())) {
          arrayList.add(n((Message)builder.build()));
          continue;
        } 
        break;
      } 
    } else {
      arrayList.add(n(paramInputStream));
    } 
    return arrayList;
  }
  
  protected Message n(Message paramMessage) {
    return paramMessage;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */