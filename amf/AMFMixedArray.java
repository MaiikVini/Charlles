package com.xk72.amf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AMFMixedArray extends HashMap<String, Object> implements m {
  private static final long serialVersionUID = 1538141495146276509L;
  
  private List<String> keysInOrder = new ArrayList<>();
  
  public String getType() {
    return "Mixed Array";
  }
  
  public Object put(String paramString, Object paramObject) {
    if (!containsKey(paramString))
      this.keysInOrder.add(paramString); 
    return super.put(paramString, paramObject);
  }
  
  public void clear() {
    super.clear();
    this.keysInOrder.clear();
  }
  
  public Object remove(Object paramObject) {
    this.keysInOrder.remove(paramObject);
    return super.remove(paramObject);
  }
  
  public List<String> getKeysInOrder() {
    return this.keysInOrder;
  }
  
  public void setKeysInOrder(List<String> paramList) {
    this.keysInOrder = paramList;
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("{ ");
    Iterator<String> iterator = this.keysInOrder.iterator();
    while (iterator.hasNext()) {
      String str = iterator.next();
      stringBuffer.append(str);
      stringBuffer.append(": ");
      Object object = get(str);
      if (object instanceof v) {
        stringBuffer.append('"');
        stringBuffer.append(object);
        stringBuffer.append('"');
      } else {
        stringBuffer.append(object);
      } 
      if (iterator.hasNext())
        stringBuffer.append(", "); 
    } 
    stringBuffer.append(" }");
    return stringBuffer.toString();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\AMFMixedArray.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */