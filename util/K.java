package com.xk72.util;

import javax.swing.SwingUtilities;

public class k {
  private final l n;
  
  private final long a;
  
  public static k n(m paramm, long paramLong) {
    return new k(paramm, paramLong);
  }
  
  public k(m paramm, long paramLong) {
    this.n = new l(paramm);
    this.a = paramLong;
  }
  
  public void n() {
    long l1 = System.currentTimeMillis() + this.a;
    if (this.n.n(l1, SwingUtilities.isEventDispatchThread()))
      Xsnk.n(this.n); 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\k.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */