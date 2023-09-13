package com.xk72.protobuf;

public class NoSuchMessageTypeException extends Exception {
  private static final long serialVersionUID = -6461085579410133166L;
  
  private final String messageType;
  
  public NoSuchMessageTypeException(String paramString) {
    super("No message type with name '" + paramString + "' found.");
    this.messageType = paramString;
  }
  
  public String getMessageType() {
    return this.messageType;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\protobuf\NoSuchMessageTypeException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */