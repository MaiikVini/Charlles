package com.xk72.charles.a;

import java.util.Comparator;

public class G implements Comparator<Xsnk> {
  public int n(Xsnk paramXsnk1, Xsnk paramXsnk2) {
    byte[] arrayOfByte1 = paramXsnk1.a().getAddress();
    byte[] arrayOfByte2 = paramXsnk2.a().getAddress();
    if (arrayOfByte1.length < arrayOfByte2.length)
      return -1; 
    if (arrayOfByte1.length > arrayOfByte2.length)
      return 1; 
    String str1 = paramXsnk1.n().getDisplayName();
    String str2 = paramXsnk2.n().getDisplayName();
    return (str1 == str2) ? 0 : ((str1 == null) ? 1 : ((str2 == null) ? -1 : str1.compareTo(str2)));
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\a\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */