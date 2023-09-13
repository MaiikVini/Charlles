package com.xk72.throttle.a;

class G {
  private a n;
  
  private a a;
  
  private a b;
  
  private a c;
  
  private a a() {
    if (this.b != null) {
      a a1 = this.b;
      this.b = a1.n;
      if (this.c == a1)
        this.c = a1.n; 
      a1.n = null;
      return a1;
    } 
    return new a();
  }
  
  private void n(a parama) {
    parama.n = null;
    if (this.c == null) {
      this.b = parama;
    } else {
      this.c.n = parama;
    } 
    this.c = parama;
  }
  
  private a b() {
    a a1 = a();
    if (this.a == null) {
      this.n = a1;
    } else {
      this.a.n = a1;
    } 
    this.a = a1;
    return a1;
  }
  
  private void c() {
    a a1 = this.n;
    this.n = a1.n;
    if (this.a == a1)
      this.a = a1.n; 
    n(a1);
  }
  
  public synchronized Object n() {
    a a1 = b();
    try {
      while (a1 != this.n)
        wait(); 
      return a1;
    } catch (InterruptedException interruptedException) {
      if (this.n == a1) {
        this.n = a1.n;
        if (this.a == a1)
          this.a = a1.n; 
      } else {
        a a2 = this.n;
        while (a2 != null) {
          if (a2.n == a1) {
            a2.n = a1.n;
            if (this.a == a1)
              this.a = a2; 
            break;
          } 
        } 
      } 
      throw interruptedException;
    } 
  }
  
  public synchronized void n(Object paramObject) {
    if (paramObject != this.n)
      throw new IllegalStateException(); 
    c();
    notifyAll();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\a\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */