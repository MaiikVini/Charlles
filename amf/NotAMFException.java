package com.xk72.amf;

public class NotAMFException extends AMFException {
  private static final long serialVersionUID = 1L;
  
  public NotAMFException() {}
  
  public NotAMFException(String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public NotAMFException(String paramString) {
    super(paramString);
  }
  
  public NotAMFException(Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\NotAMFException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */