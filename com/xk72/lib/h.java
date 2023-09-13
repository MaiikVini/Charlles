package com.xk72.lib;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class h implements ImageObserver {
  boolean n;
  
  public synchronized boolean imageUpdate(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if ((paramInt1 & 0x20) != 0 || (paramInt1 & 0x40) != 0 || (paramInt1 & 0x80) != 0) {
      this.n = true;
      notify();
      return false;
    } 
    return true;
  }
  
  public boolean n() {
    return this.n;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\h.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */