package com.xk72.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class b implements Runnable {
  private static final BlockingQueue<b> n = new LinkedBlockingQueue<>(100);
  
  private volatile Runnable a;
  
  public static synchronized b n(Runnable paramRunnable) {
    b b1 = n.poll();
    if (b1 == null)
      b1 = new b(); 
    b1.a(paramRunnable);
    return b1;
  }
  
  public void a(Runnable paramRunnable) {
    this.a = paramRunnable;
  }
  
  public void run() {
    Thread thread = Thread.currentThread();
    String str = thread.getName();
    thread.setName("Background Task Thread - " + this.a.getClass().getName());
    try {
      this.a.run();
    } finally {
      thread.setName(str);
      this.a = null;
      n.offer(this);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */