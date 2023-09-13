package com.xk72.lib;

import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class f implements c, Runnable {
  private static final Logger n = Logger.getLogger("com.xk72.lib.SerialEventDispatcher");
  
  private static final int a = 1000;
  
  private final Thread b = new Thread(this, "SerialEventDispatcher");
  
  private final BlockingQueue<Runnable> c = new LinkedBlockingQueue<>(1000);
  
  public f() {
    this.b.setPriority(10);
    this.b.setDaemon(true);
    this.b.start();
  }
  
  public void n(EventObject paramEventObject, d paramd, List<? extends EventListener> paramList) {
    if (paramList != null)
      if (Thread.currentThread() == this.b) {
        a(paramEventObject, paramd, paramList);
      } else {
        try {
          this.c.put(new g(paramEventObject, paramd, paramList));
        } catch (InterruptedException interruptedException) {}
      }  
  }
  
  public void run() {
    while (this.b != null) {
      try {
        Runnable runnable = this.c.take();
        try {
          runnable.run();
        } catch (Throwable throwable) {
          n.log(Level.SEVERE, "Throwable in EventDispatcher for " + runnable + ": " + throwable, throwable);
        } 
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  private static void a(EventObject paramEventObject, d paramd, List<? extends EventListener> paramList) {
    int i = paramList.size();
    for (byte b = 0; b < i; b++) {
      EventListener eventListener = paramList.get(b);
      paramd.n(eventListener, paramEventObject);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\f.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */