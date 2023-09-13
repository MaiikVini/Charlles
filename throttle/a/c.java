package com.xk72.throttle.a;

import com.xk72.throttle.Xsnk;

public class c implements Xsnk {
  protected volatile boolean n;
  
  protected volatile int a;
  
  public void n(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public void n(int paramInt) {
    this.a = paramInt;
  }
  
  public long n() {
    if (this.n) {
      long l = (this.a / 2);
      if (l > 0L) {
        try {
          Thread.sleep(l);
        } catch (InterruptedException interruptedException) {}
        return l;
      } 
    } 
    return 0L;
  }
  
  public long a() {
    return this.n ? (this.a / 2) : 0L;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\a\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */