package com.xk72.amf;

import java.io.IOException;

public class AMFException extends IOException {
  private static final long serialVersionUID = 1L;
  
  public AMFException() {}
  
  public AMFException(String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public AMFException(String paramString) {
    super(paramString);
  }
  
  public AMFException(Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\AMFException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */