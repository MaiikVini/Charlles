package com.xk72.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Xsnk {
  private final ExtensionRegistry n = ExtensionRegistry.newInstance();
  
  private final Map<Descriptors.Descriptor, SortedSet<Integer>> a = new HashMap<>();
  
  private final Map<Descriptors.Descriptor, List<ExtensionRegistry.ExtensionInfo>> b = null;
  
  public Xsnk() {}
  
  private Xsnk(ExtensionRegistry paramExtensionRegistry, Map<Descriptors.Descriptor, List<ExtensionRegistry.ExtensionInfo>> paramMap) {}
  
  public Xsnk n() {
    if (this.b == null) {
      ExtensionRegistry extensionRegistry = this.n.getUnmodifiable();
      HashMap<Object, Object> hashMap = new HashMap<>();
      for (Map.Entry<Descriptors.Descriptor, SortedSet<Integer>> entry : this.a.entrySet()) {
        ArrayList<ExtensionRegistry.ExtensionInfo> arrayList = new ArrayList(((SortedSet)entry.getValue()).size());
        for (Integer integer : entry.getValue())
          arrayList.add(extensionRegistry.findImmutableExtensionByNumber((Descriptors.Descriptor)entry.getKey(), integer.intValue())); 
        hashMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
      } 
      return new Xsnk(extensionRegistry, (Map)Collections.unmodifiableMap(hashMap));
    } 
    return new Xsnk(this.n, this.b);
  }
  
  public ExtensionRegistry a() {
    return this.n;
  }
  
  public void n(Descriptors.FieldDescriptor paramFieldDescriptor) {
    a(paramFieldDescriptor);
    this.n.add(paramFieldDescriptor);
  }
  
  public void n(Descriptors.FieldDescriptor paramFieldDescriptor, DynamicMessage paramDynamicMessage) {
    a(paramFieldDescriptor);
    this.n.add(paramFieldDescriptor, (Message)paramDynamicMessage);
  }
  
  private void a(Descriptors.FieldDescriptor paramFieldDescriptor) {
    if (this.a == null)
      throw new IllegalStateException("Cannot add field to immutable registry"); 
    SortedSet<Integer> sortedSet = this.a.get(paramFieldDescriptor.getContainingType());
    if (sortedSet == null) {
      sortedSet = new TreeSet();
      this.a.put(paramFieldDescriptor.getContainingType(), sortedSet);
    } 
    sortedSet.add(Integer.valueOf(paramFieldDescriptor.getNumber()));
  }
  
  public List<ExtensionRegistry.ExtensionInfo> n(Descriptors.Descriptor paramDescriptor) {
    if (this.b == null)
      throw new IllegalStateException("Cannot retrieve extensions from non-immutable registry"); 
    List<ExtensionRegistry.ExtensionInfo> list = this.b.get(paramDescriptor);
    return (list == null) ? Collections.emptyList() : list;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */