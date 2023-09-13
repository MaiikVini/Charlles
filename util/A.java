package com.xk72.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

final class a<T> implements Callable<T> {
  private static final BlockingQueue<a> n = new LinkedBlockingQueue<>(100);
  
  private volatile Callable<T> a;
  
  public static <T> a<T> n(Callable<T> paramCallable) {
    a<T> a1 = n.poll();
    if (a1 == null)
      a1 = new a(); 
    a1.a(paramCallable);
    return a1;
  }
  
  public void a(Callable<T> paramCallable) {
    this.a = paramCallable;
  }
  
  public T call() {
    Thread thread = Thread.currentThread();
    String str = thread.getName();
    thread.setName("Background Task Thread - " + this.a.getClass().getName());
    try {
      return this.a.call();
    } finally {
      thread.setName(str);
      this.a = null;
      n.offer(this);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */