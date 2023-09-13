package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class PagedDSMessage extends SequencedDSMessage {
  private static final long serialVersionUID = -4904697804980664177L;
  
  private static final String n = "pagedMessage";
  
  private static final String[] a = new String[] { "pageCount", "pageIndex" };
  
  public PagedDSMessage(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, a, "pagedMessage");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, a, "pagedMessage");
  }
  
  public String getAlias() {
    return "DSP";
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\PagedDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */