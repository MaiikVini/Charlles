package com.xk72.lib;

import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

class g implements Runnable {
  private final EventObject n;
  
  private final d a;
  
  private final List<? extends EventListener> b;
  
  public g(EventObject paramEventObject, d paramd, List<? extends EventListener> paramList) {
    this.n = paramEventObject;
    this.a = paramd;
    this.b = paramList;
  }
  
  public void run() {
    f.a(this.n, this.a, this.b);
  }
  
  public String toString() {
    return "event from " + this.n.getSource();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\g.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */