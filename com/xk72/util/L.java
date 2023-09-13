package com.xk72.util;

import javax.swing.SwingUtilities;

class l implements Runnable {
  private final m n;
  
  private boolean a;
  
  private long b = -1L;
  
  public l(m paramm) {
    this.n = paramm;
  }
  
  public synchronized boolean n(long paramLong, boolean paramBoolean) {
    if (this.b < 0L) {
      this.a = paramBoolean;
      this.b = paramLong;
      return true;
    } 
    this.b = paramLong;
    return false;
  }
  
  public void run() {
    synchronized (this) {
      long l1 = this.b - System.currentTimeMillis();
      try {
        while (l1 > 0L) {
          wait(l1);
          l1 = this.b - System.currentTimeMillis();
        } 
      } catch (InterruptedException interruptedException) {}
      this.b = -1L;
    } 
    if (this.a) {
      SwingUtilities.invokeLater(this.n);
    } else {
      this.n.run();
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\l.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */