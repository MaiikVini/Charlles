package com.xk72.amf.externalizable;

import com.xk72.amf.AMFExternalizedObject;
import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class BasicExternalizable extends AMFExternalizedObject {
  private static final long serialVersionUID = -6301898866586148120L;
  
  public BasicExternalizable(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    setData(parame.f());
  }
  
  public void writeExternal(f paramf) {
    paramf.c(getData());
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\BasicExternalizable.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */