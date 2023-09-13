package com.xk72.amf.externalizable;

import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;

public class UpdateCollectionDSMessage extends DataDSMessage {
  private static final long serialVersionUID = 7714523642726297699L;
  
  private static final String n = "updateCollection";
  
  private static final String[] a = new String[] { "collectionId", "replace", "updateMode" };
  
  public UpdateCollectionDSMessage(l paraml) {
    super(paraml);
  }
  
  public String getAlias() {
    return "DSU";
  }
  
  public void readExternal(e parame) {
    super.readExternal(parame);
    readDSData(parame, a, "updateCollection");
  }
  
  public void writeExternal(f paramf) {
    super.writeExternal(paramf);
    writeDSData(paramf, a, "updateCollection");
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\UpdateCollectionDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */