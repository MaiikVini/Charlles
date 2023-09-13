package com.xk72.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;

public class g {
  private static final Logger n = Logger.getLogger("com.xk72.protobuf.ParserSet");
  
  private static final Descriptors.FileDescriptor[] a = new Descriptors.FileDescriptor[0];
  
  private i[] b;
  
  private final Map<String, Descriptors.Descriptor> c;
  
  private final Xsnk d;
  
  private static Map<String, Descriptors.Descriptor> n(j paramj, Xsnk paramXsnk, i... paramVarArgs) {
    HashMap<Object, Object> hashMap1 = new HashMap<>();
    for (i i1 : paramVarArgs) {
      for (DescriptorProtos.FileDescriptorProto fileDescriptorProto : i1.n.getFileList()) {
        if (hashMap1.put(fileDescriptorProto.getName(), new h(i1, fileDescriptorProto)) != null);
      } 
    } 
    n(paramj, (Map)hashMap1);
    for (h h : hashMap1.values())
      n(h, (Map)hashMap1); 
    HashMap<Object, Object> hashMap2 = new HashMap<>();
    for (h h : hashMap1.values()) {
      for (Descriptors.Descriptor descriptor : h.b.getMessageTypes())
        n((Map)hashMap2, descriptor); 
      for (Descriptors.FieldDescriptor fieldDescriptor : h.b.getExtensions()) {
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          paramXsnk.n(fieldDescriptor, DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()));
          continue;
        } 
        paramXsnk.n(fieldDescriptor);
      } 
    } 
    for (Descriptors.Descriptor descriptor : hashMap2.values()) {
      for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.getExtensions()) {
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          paramXsnk.n(fieldDescriptor, DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()));
          continue;
        } 
        paramXsnk.n(fieldDescriptor);
      } 
    } 
    if (hashMap2.isEmpty())
      throw new InvalidProtocolBufferException("Empty File Descriptor Set"); 
    return (Map)hashMap2;
  }
  
  private static void n(j paramj, Map<String, h> paramMap) {
    LinkedList<h> linkedList = new LinkedList(paramMap.values());
    while (!linkedList.isEmpty()) {
      h h = linkedList.pop();
      int k = h.a.getDependencyCount();
      for (byte b = 0; b < k; b++) {
        String str = h.a.getDependency(b);
        if (!paramMap.containsKey(str) && h.n.b != null && paramj != null)
          try {
            URI uRI = n(h.n.b, h.a.getName(), str);
            DescriptorProtos.FileDescriptorSet fileDescriptorSet = paramj.n(uRI);
            i i1 = new i(fileDescriptorSet, uRI);
            for (DescriptorProtos.FileDescriptorProto fileDescriptorProto : fileDescriptorSet.getFileList()) {
              h h1 = new h(i1, fileDescriptorProto);
              if (paramMap.put(fileDescriptorProto.getName(), h1) != null);
              linkedList.add(h1);
            } 
          } catch (Exception exception) {} 
      } 
    } 
  }
  
  private static URI n(URI paramURI, String paramString1, String paramString2) {
    String str4;
    String str1 = paramString2.replace(".proto", ".");
    String str2 = paramString1.replace(".proto", ".");
    String str3 = paramURI.getSchemeSpecificPart();
    if (str3.contains(str2)) {
      str4 = str3.replace(str2, str1);
    } else {
      String str;
      int j = str3.lastIndexOf('.');
      int k = str3.lastIndexOf('/');
      if (j < 0 || j < k) {
        str = "";
      } else {
        str = str3.substring(j);
      } 
      str4 = str3.substring(0, k + 1) + str3.substring(0, k + 1) + (str1.endsWith(".") ? str1.substring(0, str1.length() - 1) : str1);
    } 
    return new URI(paramURI.getScheme(), str4, paramURI.getFragment());
  }
  
  private static Descriptors.FileDescriptor n(h paramh, Map<String, h> paramMap) {
    return (paramh.b == null) ? (paramh.b = Descriptors.FileDescriptor.buildFrom(paramh.a, n(paramh.a, paramMap))) : paramh.b;
  }
  
  private static Descriptors.FileDescriptor[] n(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto, Map<String, h> paramMap) {
    if (paramFileDescriptorProto.getDependencyCount() == 0)
      return a; 
    Descriptors.FileDescriptor[] arrayOfFileDescriptor = new Descriptors.FileDescriptor[paramFileDescriptorProto.getDependencyCount()];
    for (byte b = 0; b < arrayOfFileDescriptor.length; b++) {
      h h = paramMap.get(paramFileDescriptorProto.getDependency(b));
      if (h == null)
        throw new InvalidProtocolBufferException("Unresolved dependency.  Missing descriptor file for '" + paramFileDescriptorProto.getDependency(b) + "'"); 
      arrayOfFileDescriptor[b] = n(h, paramMap);
    } 
    return arrayOfFileDescriptor;
  }
  
  private static void n(Map<String, Descriptors.Descriptor> paramMap, Descriptors.Descriptor paramDescriptor) {
    if (paramMap.put(paramDescriptor.getFullName(), paramDescriptor) != null);
    for (Descriptors.Descriptor descriptor : paramDescriptor.getNestedTypes())
      n(paramMap, descriptor); 
  }
  
  public g(j paramj, i... paramVarArgs) {
    this.b = paramVarArgs;
    Xsnk xsnk = new Xsnk();
    this.c = Collections.unmodifiableMap(n(paramj, xsnk, paramVarArgs));
    this.d = xsnk.n();
  }
  
  public i[] a() {
    return this.b;
  }
  
  public Collection<Descriptors.Descriptor> b() {
    return this.c.values();
  }
  
  public c n(String paramString) {
    return new c(a(paramString), this.d);
  }
  
  protected Xsnk c() {
    return this.d;
  }
  
  protected Descriptors.Descriptor a(String paramString) {
    if (paramString == null)
      throw new NoSuchMessageTypeException(paramString); 
    Descriptors.Descriptor descriptor = this.c.get(paramString);
    if (descriptor == null)
      throw new NoSuchMessageTypeException(paramString); 
    return descriptor;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\g.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */