package com.xk72.util;

import java.util.AbstractList;

class h<T> extends AbstractList<T> {
  private final Object[] n;
  
  public h(Object[] paramArrayOfObject) {
    this.n = paramArrayOfObject;
  }
  
  public T get(int paramInt) {
    return (T)this.n[paramInt];
  }
  
  public int size() {
    return this.n.length;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\h.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */