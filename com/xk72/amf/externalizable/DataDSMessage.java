package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class DataDSMessage extends AsyncDSMessage {
  private static final long serialVersionUID = 4984811692865958162L;
  
  private static final String n = "dataMessage";
  
  private static final String[] a = new String[] { "identity", "operation" };
  
  public DataDSMessage(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, a, "dataMessage");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, a, "dataMessage");
  }
  
  public String getAlias() {
    return "DSD";
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\DataDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */