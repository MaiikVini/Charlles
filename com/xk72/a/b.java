package com.xk72.a;

public class b<V> {
  private long n;
  
  private V a;
  
  public b(V paramV, long paramLong) {
    this.a = paramV;
    if (paramLong == -1L) {
      this.n = Long.MAX_VALUE;
    } else {
      this.n = System.currentTimeMillis() + paramLong;
    } 
  }
  
  public V n() {
    return (this.n > System.currentTimeMillis()) ? this.a : null;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */