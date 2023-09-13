package com.xk72.throttle;

import java.io.IOException;

public class ProxyAbortIOException extends IOException {
  private static final long serialVersionUID = 1L;
  
  public ProxyAbortIOException() {
    super("Connection dropped due to throttle reliability setting");
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\ProxyAbortIOException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */