package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class SequencedDSMessage extends AcknowledgeDSMessage {
  private static final long serialVersionUID = -3146889294258882382L;
  
  private static final String n = "sequencedMessage";
  
  private static final String[] a = new String[] { "dataMessage", "dynamicSizing", "sequenceId", "sequenceProxies", "sequenceSize" };
  
  public SequencedDSMessage(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, a, "sequencedMessage");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, a, "sequencedMessage");
  }
  
  public String getAlias() {
    return "DSQ";
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\SequencedDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */