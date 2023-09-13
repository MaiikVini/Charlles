package com.xk72.throttle;

import com.xk72.util.Xsnk;

public class LatentExecutor<T extends e<T>> implements Runnable {
  private static final int n = 256;
  
  private final Xsnk a;
  
  private final f<T> b;
  
  private T c;
  
  private int d = 0;
  
  private int e = 0;
  
  private T f;
  
  private T g;
  
  private int h = 0;
  
  private boolean i = false;
  
  private volatile boolean j = false;
  
  private volatile Throwable k;
  
  private final int l;
  
  public LatentExecutor(Xsnk paramXsnk, f<T> paramf) {
    this(paramXsnk, paramf, 2147483647);
  }
  
  public LatentExecutor(Xsnk paramXsnk, f<T> paramf, int paramInt) {
    this.a = paramXsnk;
    this.b = paramf;
    this.l = paramInt;
  }
  
  public void n() {
    this.j = true;
  }
  
  public boolean a() {
    return this.j;
  }
  
  public Throwable b() {
    return this.k;
  }
  
  public synchronized boolean c() {
    return this.i;
  }
  
  public synchronized void d() {
    while (this.i)
      wait(); 
  }
  
  public synchronized T e() {
    return (c() || (this.a != null && this.a.a() > 0L)) ? f() : null;
  }
  
  public synchronized T f() {
    if (this.c == null)
      return this.b.createTask(); 
    T t = this.c;
    this.c = ((e)t).a;
    ((e)t).a = null;
    this.d--;
    this.e -= ((e)t).b;
    return t;
  }
  
  private synchronized void a(T paramT) {
    if (this.d < 256) {
      int i = ((e)paramT).b;
      if (this.e + i + this.h > this.l)
        if (paramT instanceof g) {
          ((g)paramT).a();
          i = ((g)paramT).n();
          if (this.e + i + this.h > this.l)
            return; 
        } else {
          return;
        }  
      this.d++;
      this.e += i;
      ((e)paramT).n = -1L;
      ((e)paramT).b = i;
      ((e)paramT).a = this.c;
      this.c = paramT;
    } 
  }
  
  public void n(T paramT) {
    if (this.j)
      throw new LatentExecutor$ExecutorCancelledException(this.k); 
    long l = (this.a == null) ? 0L : this.a.a();
    if (c() || l > 0L) {
      n(paramT, l);
    } else {
      b(paramT);
    } 
  }
  
  private void b(T paramT) {
    try {
      paramT.b();
    } catch (LatentExecutor$FatalException latentExecutor$FatalException) {
      this.j = true;
      this.k = latentExecutor$FatalException.getCause();
    } finally {
      a(paramT);
    } 
  }
  
  private synchronized void n(T paramT, long paramLong) {
    ((e)paramT).n = System.currentTimeMillis() + paramLong;
    ((e)paramT).a = null;
    ((e)paramT).b = (paramT instanceof g) ? ((g)paramT).n() : 1;
    try {
      while (this.h + ((e)paramT).b > this.l)
        wait(); 
    } catch (InterruptedException interruptedException) {}
    this.h += ((e)paramT).b;
    if (this.g == null) {
      this.f = paramT;
    } else {
      ((e)this.g).a = paramT;
    } 
    this.g = paramT;
    if (!this.j && !this.i) {
      this.i = true;
      Xsnk.n(this);
    } 
  }
  
  private synchronized T g() {
    T t = this.f;
    if (t != null) {
      this.f = ((e)t).a;
      ((e)t).a = null;
      this.h -= ((e)t).b;
    } 
    if (this.f == null)
      this.g = null; 
    return t;
  }
  
  public void run() {
    try {
      while (!this.j) {
        T t = g();
        if (t == null)
          break; 
        long l = ((e)t).n - System.currentTimeMillis();
        if (l > 0L)
          try {
            Thread.sleep(l);
          } catch (InterruptedException interruptedException) {} 
        if (!this.j)
          b(t); 
      } 
    } finally {
      if (this.j) {
        this.f = null;
        this.g = null;
        this.h = 0;
      } 
      synchronized (this) {
        this.i = false;
        notifyAll();
      } 
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\LatentExecutor.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */