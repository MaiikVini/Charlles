package com.xk72.amf.externalizable;

import com.xk72.amf.AMFExternalizedObject;
import com.xk72.amf.c;
import com.xk72.amf.l;

public class Xsnk {
  public static AMFExternalizedObject n(c paramc) {
    String str = paramc.n();
    return (AMFExternalizedObject)((str.equals("flex.messaging.io.ObjectProxy") || str.equals("flex.messaging.io.ArrayCollection") || str.equals("flex.messaging.io.ArrayList")) ? new BasicExternalizable((l)paramc) : (str.equals("DSK") ? new AcknowledgeDSMessage((l)paramc) : (str.equals("DSA") ? new AsyncDSMessage((l)paramc) : (str.equals("DSC") ? new CommandDSMessage((l)paramc) : (str.equals("DSD") ? new DataDSMessage((l)paramc) : (str.equals("DSP") ? new PagedDSMessage((l)paramc) : (str.equals("DSQ") ? new SequencedDSMessage((l)paramc) : (str.equals("DSU") ? new UpdateCollectionDSMessage((l)paramc) : new UnknownExternalizable((l)paramc)))))))));
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */