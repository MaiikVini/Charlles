package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class CommandDSMessage extends AbstractDSMessage {
  private static final long serialVersionUID = -461446087676775420L;
  
  private static final String n = "commandMessage";
  
  private static final String[] a = new String[] { "operation" };
  
  public CommandDSMessage(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, a, "commandMessage");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, a, "commandMessage");
  }
  
  public String getAlias() {
    return "DSC";
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\CommandDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */