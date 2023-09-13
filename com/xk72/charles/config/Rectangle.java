package com.xk72.charles.config;

import com.xk72.util.B;
import com.xk72.util.C;

@B
@C
public class Rectangle {
  private int x;
  
  private int y;
  
  private int width;
  
  private int height;
  
  public Rectangle() {}
  
  public Rectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public int getX() {
    return this.x;
  }
  
  public void setX(int paramInt) {
    this.x = paramInt;
  }
  
  public int getY() {
    return this.y;
  }
  
  public void setY(int paramInt) {
    this.y = paramInt;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public void setWidth(int paramInt) {
    this.width = paramInt;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public void setHeight(int paramInt) {
    this.height = paramInt;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\Rectangle.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */