package com.xk72.a;

import java.util.Set;

public class m<K, V> implements n<K, V> {
  private e<K, b<V>> n;
  
  private long a;
  
  private k<K, V> b;
  
  public m(e<K, b<V>> parame) {
    this(-1L, parame);
  }
  
  public m(long paramLong, e<K, b<V>> parame) {
    this.a = paramLong;
    this.n = parame;
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
    return this.n.n();
  }
  
  public void a() {
    this.n.a();
  }
  
  public void n(K paramK, V paramV, long paramLong) {
    b<V> b = new b<>(paramV, paramLong);
    this.n.n(paramK, b);
    this.b.a();
  }
  
  public V a(Object paramObject) {
    this.b.a();
    b<Object> b = (b)this.n.a(paramObject);
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
    b<V> b = this.n.c(paramObject);
    return (b != null) ? b.n() : null;
  }
  
  public long c() {
    return this.a;
  }
  
  public Set<K> b() {
    return this.n.b();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\m.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */