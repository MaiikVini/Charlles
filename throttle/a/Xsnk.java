package com.xk72.throttle.a;

import com.xk72.throttle.ProxyAbortIOException;
import com.xk72.throttle.h;
import com.xk72.throttle.l;

public abstract class Xsnk implements l, Runnable {
  private static final int d = 250;
  
  protected int n = 0;
  
  protected volatile boolean a = false;
  
  protected volatile h b;
  
  private final Object e = new Object();
  
  private final G f = new G();
  
  public static final double c = 10240.0D;
  
  public void c() {
    n(false);
  }
  
  public void n(h paramh) {
    this.b = paramh;
  }
  
  public int n() {
    return 4;
  }
  
  public void run() {
    long l1 = System.currentTimeMillis() + 250L;
    while (this.a) {
      synchronized (this) {
        this.n = 0;
        notifyAll();
      } 
      try {
        synchronized (this.e) {
          long l2 = System.currentTimeMillis();
          long l3 = l1 - l2;
          l1 += 250L;
          if (l3 > 0L)
            this.e.wait(l3); 
        } 
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public void n(int paramInt, long paramLong) {
    h h1 = this.b;
    if (!this.a || h1 == null || paramInt == 0)
      return; 
    if (paramInt > 0 && h1.n() < 100) {
      double d1 = paramInt / 10240.0D;
      double d2 = h1.n() / 100.0D;
      double d3 = Math.pow(d2, d1);
      if (Math.random() > d3)
        throw new ProxyAbortIOException(); 
    } 
    long l1 = System.currentTimeMillis() - paramLong;
    int i = h1.a();
    long l2 = paramInt * 1000L / i;
    if (l1 < l2) {
      try {
        Thread.sleep(l2 - l1);
      } catch (InterruptedException interruptedException) {}
    } else if (l1 == 0L && l2 == 0L) {
      int j = paramInt * 1000000 / i;
      try {
        Thread.sleep(0L, j);
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public abstract int a(h paramh);
  
  public int a(int paramInt) {
    h h1 = this.b;
    if (!this.a || h1 == null)
      return paramInt; 
    int i = Math.min(paramInt, a(h1));
    int j = h1.a() / n();
    try {
      Object object = this.f.n();
      try {
        synchronized (this) {
          int k = i;
          while (k > 0 && this.a) {
            int m = j - this.n;
            int n = Math.min(m, k);
            k -= n;
            this.n += n;
            if (k > 0)
              wait(); 
          } 
        } 
      } finally {
        this.f.n(object);
      } 
    } catch (InterruptedException interruptedException) {}
    return i;
  }
  
  public boolean b() {
    return this.a;
  }
  
  public void n(boolean paramBoolean) {
    if (paramBoolean != this.a)
      synchronized (this.e) {
        this.a = paramBoolean;
        if (paramBoolean) {
          com.xk72.util.Xsnk.n(this);
        } else {
          this.e.notify();
        } 
      }  
    synchronized (this) {
      notifyAll();
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\a\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */