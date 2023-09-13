package com.xk72.a;

import java.lang.ref.SoftReference;

public class j<V> extends SoftReference<V> {
  private long n;
  
  public j(V paramV, long paramLong) {
    super(paramV);
    if (paramLong == -1L) {
      this.n = Long.MAX_VALUE;
    } else {
      this.n = System.currentTimeMillis() + paramLong;
    } 
  }
  
  public V get() {
    V v = super.get();
    return (v != null && this.n > System.currentTimeMillis()) ? v : null;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\j.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */