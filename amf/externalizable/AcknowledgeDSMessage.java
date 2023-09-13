package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class AcknowledgeDSMessage extends AsyncDSMessage {
  private static final long serialVersionUID = -3711731237515289137L;
  
  private static final String[] n = new String[0];
  
  private static final String a = "acknowledgeMessage";
  
  public AcknowledgeDSMessage(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, n, "acknowledgeMessage");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, n, "acknowledgeMessage");
  }
  
  public String getAlias() {
    return "DSK";
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\AcknowledgeDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */