package com.xk72.c;

import java.net.InetAddress;

public class G implements Xsnk {
  public static final int n = 4;
  
  public static final int a = 16;
  
  private boolean b = true;
  
  protected InetAddress[] b(String paramString) {
    return InetAddress.getAllByName(paramString);
  }
  
  public InetAddress[] n(String paramString) {
    InetAddress[] arrayOfInetAddress1 = b(paramString);
    InetAddress[] arrayOfInetAddress2 = new InetAddress[arrayOfInetAddress1.length];
    byte b1 = this.b ? 16 : 4;
    byte b2 = 0;
    for (InetAddress inetAddress : arrayOfInetAddress1) {
      if ((inetAddress.getAddress()).length == b1)
        arrayOfInetAddress2[b2++] = InetAddress.getByAddress(paramString, inetAddress.getAddress()); 
    } 
    for (InetAddress inetAddress : arrayOfInetAddress1) {
      if ((inetAddress.getAddress()).length != b1)
        arrayOfInetAddress2[b2++] = InetAddress.getByAddress(paramString, inetAddress.getAddress()); 
    } 
    if (b2 != arrayOfInetAddress2.length)
      throw new IllegalStateException("Somehow we didn't get all the addresses"); 
    return arrayOfInetAddress2;
  }
  
  public InetAddress a(String paramString) {
    InetAddress inetAddress = n(b(paramString));
    return InetAddress.getByAddress(paramString, inetAddress.getAddress());
  }
  
  private InetAddress n(InetAddress[] paramArrayOfInetAddress) {
    if (paramArrayOfInetAddress.length == 1)
      return paramArrayOfInetAddress[0]; 
    byte b = this.b ? 16 : 4;
    for (InetAddress inetAddress : paramArrayOfInetAddress) {
      if ((inetAddress.getAddress()).length == b)
        return inetAddress; 
    } 
    return paramArrayOfInetAddress[0];
  }
  
  public boolean n() {
    return this.b;
  }
  
  public void n(boolean paramBoolean) {
    this.b = paramBoolean;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\c\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */