package com.xk72.a;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class i<K, V> implements n<K, V> {
  private Map<K, j<V>> n = new ConcurrentHashMap<>();
  
  private long a = -1L;
  
  private k<K, V> b;
  
  public i() {
    this.b = new k<>(this);
  }
  
  public i(long paramLong) {
    this.a = paramLong;
    this.b = new k<>(this);
  }
  
  public void n(K paramK, V paramV) {
    n(paramK, paramV, this.a);
    this.b.a();
  }
  
  public boolean n(Object paramObject) {
    return (a(paramObject) != null);
  }
  
  public int n() {
    return this.n.size();
  }
  
  public void a() {
    this.n.clear();
  }
  
  public void n(K paramK, V paramV, long paramLong) {
    j<V> j = new j<>(paramV, paramLong);
    this.n.put(paramK, j);
    this.b.a();
  }
  
  public V a(Object paramObject) {
    this.b.a();
    j<Object> j = (j)this.n.get(paramObject);
    if (j != null) {
      V v = (V)j.get();
      if (v != null)
        return v; 
      c(paramObject);
      return null;
    } 
    return null;
  }
  
  public V c(Object paramObject) {
    j<V> j = this.n.remove(paramObject);
    return (j != null) ? j.get() : null;
  }
  
  public long c() {
    return this.a;
  }
  
  public Set<K> b() {
    return this.n.keySet();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\i.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */