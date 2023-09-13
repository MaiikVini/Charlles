package com.xk72.a;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class h<K, V> implements e<K, V> {
  private Map<K, SoftReference<V>> n = new ConcurrentHashMap<>();
  
  public void n(K paramK, V paramV) {
    this.n.put(paramK, new SoftReference<>(paramV));
  }
  
  public boolean n(Object paramObject) {
    return (a(paramObject) != null);
  }
  
  public V a(Object paramObject) {
    SoftReference<Object> softReference = (SoftReference)this.n.get(paramObject);
    if (softReference != null) {
      V v = (V)softReference.get();
      if (v != null)
        return v; 
      this.n.remove(paramObject);
      return null;
    } 
    return null;
  }
  
  public V c(Object paramObject) {
    SoftReference<V> softReference = this.n.remove(paramObject);
    return (softReference != null) ? softReference.get() : null;
  }
  
  public int n() {
    return this.n.size();
  }
  
  public void a() {
    this.n.clear();
  }
  
  public Set<K> b() {
    return this.n.keySet();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\h.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */