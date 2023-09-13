package com.xk72.util.css;

class G {
  private final StringBuilder b = new StringBuilder();
  
  private int c = 0;
  
  boolean n = true;
  
  boolean a = false;
  
  public G n() {
    this.c++;
    return this;
  }
  
  public G a() {
    if (this.c > 0)
      this.c--; 
    return this;
  }
  
  public G n(char paramChar) {
    this.b.append(paramChar);
    return this;
  }
  
  public G a(char paramChar) {
    if (SimpleFormatter.n(paramChar)) {
      d();
    } else if (this.n) {
      if (!Character.isWhitespace(paramChar)) {
        for (byte b = 0; b < this.c; b++)
          this.b.append("  "); 
        this.b.append(paramChar);
        this.n = false;
      } 
    } else if (this.a) {
      if (!Character.isWhitespace(paramChar))
        this.b.append(' '); 
      this.b.append(paramChar);
    } else {
      this.b.append(paramChar);
    } 
    this.a = false;
    return this;
  }
  
  public G b() {
    if (this.b.length() == 0 || !Character.isWhitespace(this.b.charAt(this.b.length() - 1)))
      this.b.append(' '); 
    return this;
  }
  
  public G c() {
    this.a = true;
    return this;
  }
  
  public G d() {
    if (!this.n) {
      this.b.append('\n');
      this.n = true;
    } 
    return this;
  }
  
  public G e() {
    this.b.append('\n');
    if (!this.n) {
      this.b.append('\n');
      this.n = true;
    } 
    return this;
  }
  
  public String toString() {
    return this.b.toString();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\css\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */