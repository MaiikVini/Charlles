package com.xk72.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Xsnk extends JSONObject {
  private List<String> n;
  
  public Xsnk() {}
  
  public Xsnk(String paramString) {
    this(new G(paramString));
  }
  
  public Xsnk(G paramG) {
    super(paramG);
  }
  
  public Xsnk(Xsnk paramXsnk, String[] paramArrayOfString) {
    super(paramXsnk, paramArrayOfString);
  }
  
  public Xsnk(Object paramObject, String[] paramArrayOfString) {
    super(paramObject, paramArrayOfString);
  }
  
  public Iterator<String> keys() {
    return (this.n != null) ? this.n.iterator() : Collections.<String>emptyList().iterator();
  }
  
  public JSONArray names() {
    if (this.n != null) {
      JSONArray jSONArray = new JSONArray();
      for (String str : this.n)
        jSONArray.put(str); 
      return jSONArray;
    } 
    return null;
  }
  
  public JSONObject put(String paramString, Object paramObject) {
    return n(paramString, -1, paramObject);
  }
  
  public JSONObject n(String paramString, int paramInt, Object paramObject) {
    if (this.n == null)
      this.n = new ArrayList<>(); 
    int i = this.n.indexOf(paramString);
    if (i < 0 && paramInt < 0) {
      this.n.add(paramString);
    } else if (i < 0) {
      this.n.add(paramInt, paramString);
    } else if (i != paramInt && paramInt >= 0) {
      this.n.add(paramInt, paramString);
      int j = (paramInt > i) ? i : (i + 1);
      this.n.remove(j);
    } 
    return super.put(paramString, paramObject);
  }
  
  public int n(String paramString) {
    return (this.n == null) ? -1 : this.n.indexOf(paramString);
  }
  
  public Object remove(String paramString) {
    if (this.n != null)
      this.n.remove(paramString); 
    return super.remove(paramString);
  }
  
  public void n(String paramString1, String paramString2) {
    if (paramString1.equals(paramString2))
      return; 
    if (has(paramString2))
      throw new JSONException("Name '" + paramString2 + "' already exists."); 
    super.put(paramString2, super.remove(paramString1));
    if (this.n != null) {
      int i = this.n.indexOf(paramString1);
      if (paramString2 != null && i >= 0)
        this.n.set(i, paramString2); 
    } 
  }
  
  public void n(int paramInt1, int paramInt2) {
    String str1 = this.n.get(paramInt1);
    String str2 = this.n.get(paramInt2);
    this.n.set(paramInt2, str1);
    this.n.set(paramInt1, str2);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\e\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */