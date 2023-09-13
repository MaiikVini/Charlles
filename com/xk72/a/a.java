package com.xk72.a;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a<K, V> implements n<K, V> {
  private Map<K, b<V>> n = new ConcurrentHashMap<>();
  
  private long a = -1L;
  
  private k<K, V> b;
  
  public a() {
    this.b = new k<>(this);
  }
  
  public a(long paramLong) {
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
    b<V> b = new b<>(paramV, paramLong);
    this.n.put(paramK, b);
    this.b.a();
  }
  
  public V a(Object paramObject) {
    this.b.a();
    b<Object> b = (b)this.n.get(paramObject);
    if (b != null) {
      V v = (V)b.n();
      if (v != null)
        return v; 
      c(paramObject);
      return null;
    } 
    return null;
  }
  
  public V c(Object paramObject) {
    b<V> b = this.n.remove(paramObject);
    return (b != null) ? b.n() : null;
  }
  
  public long c() {
    return this.a;
  }
  
  public Set<K> b() {
    return this.n.keySet();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */