package com.xk72.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Xsnk {
  private static ExecutorService n;
  
  private static Timer a;
  
  public static void n() {
    n = Executors.newCachedThreadPool(new G());
    a = new Timer("Background timer tasks");
  }
  
  public static void a() {
    n.shutdown();
    a.cancel();
  }
  
  public static void n(Runnable paramRunnable) {
    n.execute(b.n(paramRunnable));
  }
  
  public static <T> Future<T> n(Callable<T> paramCallable) {
    return n.submit(a.n(paramCallable));
  }
  
  public static <T> Future<T> n(Runnable paramRunnable, T paramT) {
    return n.submit(b.n(paramRunnable), paramT);
  }
  
  public static Future<?> a(Runnable paramRunnable) {
    return n.submit(b.n(paramRunnable));
  }
  
  public static void n(TimerTask paramTimerTask, long paramLong) {
    a.schedule(paramTimerTask, paramLong);
  }
  
  public static void n(TimerTask paramTimerTask, long paramLong1, long paramLong2) {
    a.schedule(paramTimerTask, paramLong1, paramLong2);
  }
  
  static {
    n();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */