package com.xk72.throttle;

import com.xk72.util.Xsnk;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.concurrent.Future;

public class p {
  protected static final long n = 10000L;
  
  private final Random a = new Random();
  
  private int b = 100;
  
  private int c = 100;
  
  private int d = 100;
  
  private volatile int e = 100;
  
  private Future<?> f;
  
  private final Runnable g = new q(this);
  
  private final PropertyChangeSupport h;
  
  public p(PropertyChangeSupport paramPropertyChangeSupport) {
    this.h = paramPropertyChangeSupport;
  }
  
  public void n(int paramInt1, int paramInt2, int paramInt3) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    if (this.d == 100) {
      n();
    } else {
      a();
      if (this.f == null || this.f.isDone())
        this.f = Xsnk.a(this.g); 
    } 
  }
  
  public void n() {
    if (this.f != null && !this.f.isDone())
      this.f.cancel(true); 
    if (this.e < 100) {
      int i = this.e;
      this.e = 100;
      this.h.firePropertyChange("tunnel", i, 100);
    } 
  }
  
  private void a() {
    int i = this.e;
    if (this.a.nextInt(100) >= this.d) {
      if (this.b >= this.c) {
        this.e = this.c;
      } else {
        this.e = this.b + this.a.nextInt(1 + this.c - this.b);
      } 
    } else {
      this.e = 100;
    } 
    int j = this.e;
    if (i != j)
      this.h.firePropertyChange("tunnel", i, j); 
  }
  
  public int n(int paramInt) {
    return paramInt * 100 / this.e;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\p.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */