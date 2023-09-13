package com.xk72.charles.command;

import com.xk72.charles.CharlesContext;

public class c implements Xsnk {
  private CharlesContext n;
  
  public void run() {
    System.out.println("Charles Proxy " + this.n.getVersionName());
    System.exit(0);
  }
  
  public void n(CharlesContext paramCharlesContext) {
    this.n = paramCharlesContext;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\command\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */