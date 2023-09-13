package com.xk72.throttle;

import java.io.IOException;
import java.io.InterruptedIOException;

class a implements Runnable {
  a(G paramG) {}
  
  public void run() {
    try {
      while (true) {
        b b = this.n.a.f();
        try {
          int i = b.n(this.n.n);
          this.n.a.n(b);
          if (i < 0)
            break; 
        } catch (LatentExecutor$ExecutorCancelledException latentExecutor$ExecutorCancelledException) {
          break;
        } catch (InterruptedIOException interruptedIOException) {
          this.n.b.n();
        } catch (IOException iOException) {
          this.n.b.n(iOException);
          break;
        } 
      } 
    } finally {
      this.n.a();
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */