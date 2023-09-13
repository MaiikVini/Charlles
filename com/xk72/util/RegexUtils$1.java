package com.xk72.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

class RegexUtils$1 extends LinkedHashMap<I, Pattern> {
  private static final long serialVersionUID = 1L;
  
  RegexUtils$1(int paramInt, float paramFloat, boolean paramBoolean) {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<I, Pattern> paramEntry) {
    return (size() > 8096);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\RegexUtils$1.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */