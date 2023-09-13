package com.xk72.throttle;

class q implements Runnable {
  q(p paramp) {}
  
  public void run() {
    while (true) {
      try {
        Thread.sleep(10000L);
      } catch (InterruptedException interruptedException) {
        return;
      } 
      this.n.a();
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\q.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */