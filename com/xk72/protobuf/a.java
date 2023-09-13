package com.xk72.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

class a extends c {
  a(G paramG, Descriptors.Descriptor paramDescriptor, Xsnk paramXsnk) {
    super(paramDescriptor, paramXsnk);
  }
  
  public boolean n() {
    return true;
  }
  
  protected Message n(Message paramMessage) {
    UnknownFieldSet unknownFieldSet = n(paramMessage.getUnknownFields());
    return (unknownFieldSet != paramMessage.getUnknownFields()) ? paramMessage.toBuilder().setUnknownFields(unknownFieldSet).build() : paramMessage;
  }
  
  private UnknownFieldSet n(UnknownFieldSet paramUnknownFieldSet) {
    UnknownFieldSet.Builder builder = null;
    Map map = paramUnknownFieldSet.asMap();
    ArrayList<UnknownFieldSet> arrayList = new ArrayList();
    for (Map.Entry entry : map.entrySet()) {
      arrayList.clear();
      try {
        for (ByteString byteString : ((UnknownFieldSet.Field)entry.getValue()).getLengthDelimitedList()) {
          InputStream inputStream = byteString.newInput();
          try {
            arrayList.add(n(inputStream).getUnknownFields());
            if (inputStream != null)
              inputStream.close(); 
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
        if (!arrayList.isEmpty()) {
          UnknownFieldSet.Field.Builder builder1 = UnknownFieldSet.Field.newBuilder();
          for (UnknownFieldSet unknownFieldSet : arrayList)
            builder1.addGroup(n(unknownFieldSet)); 
          if (builder == null)
            builder = UnknownFieldSet.newBuilder(paramUnknownFieldSet); 
          builder.addField(((Integer)entry.getKey()).intValue(), builder1.build());
        } 
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
    } 
    return (builder != null) ? builder.build() : paramUnknownFieldSet;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */