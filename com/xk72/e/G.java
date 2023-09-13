package com.xk72.e;

import org.json.JSONTokener;

public class G extends JSONTokener {
  public G(String paramString) {
    super(paramString);
  }
  
  public Object nextValue() {
    char c = nextClean();
    back();
    return (c == '{') ? new Xsnk(this) : super.nextValue();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\e\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */