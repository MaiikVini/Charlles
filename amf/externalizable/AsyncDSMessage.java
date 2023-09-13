package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class AsyncDSMessage extends AbstractDSMessage {
  private static final long serialVersionUID = 6043285133618347766L;
  
  private static final String n = "asyncMessage";
  
  private static final String[] a = new String[] { "correlationId", "correlationIdBytes" };
  
  public AsyncDSMessage(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, a, "asyncMessage");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, a, "asyncMessage");
  }
  
  public String getAlias() {
    return "DSA";
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\AsyncDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */