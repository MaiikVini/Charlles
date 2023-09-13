package com.xk72.amf.rpc;

import com.xk72.amf.AMFArray;
import com.xk72.amf.AMFMixedArray;
import com.xk72.amf.AMFTypedObject;
import com.xk72.amf.NotAMFException;
import com.xk72.amf.e;
import com.xk72.amf.j;
import com.xk72.amf.q;
import com.xk72.charles.gui.transaction.viewers.lib.l;
import com.xk72.charles.lib.a;
import com.xk72.charles.model.Transaction;
import com.xk72.proxy.ProxyEventStatus;
import java.util.ArrayList;
import java.util.List;

public class AMFRPC {
  public static AMFRPC$AMFMethodList n(Transaction paramTransaction, q paramq1, q paramq2) {
    AMFRPC$AMFMethodList aMFRPC$AMFMethodList = new AMFRPC$AMFMethodList();
    for (j j : paramq1.a()) {
      Xsnk xsnk = new Xsnk();
      xsnk.n(j.getTarget());
      xsnk.n(j.getData());
      if (paramq2 != null) {
        String str = j.getResponse();
        if (str != null) {
          List<j> list = n(paramq2, str);
          if (list.size() == 1) {
            j j1 = list.get(0);
            xsnk.a(j1.getTarget());
            xsnk.a(j1.getData());
          } else {
            AMFMixedArray aMFMixedArray = new AMFMixedArray();
            for (byte b = 0; b < list.size(); b++) {
              j j1 = list.get(b);
              aMFMixedArray.put(j1.getTarget(), new l("Result " + b, j1.getData()));
            } 
            xsnk.a(aMFMixedArray);
          } 
        } 
      } else {
        long l1 = 0L;
        if (paramTransaction.getResponseHeader() != null)
          l1 = paramTransaction.getResponseHeader().getLongField("Content-Length"); 
        long l2 = paramTransaction.getResponseSize();
        if (paramTransaction.getStatus() == ProxyEventStatus.g || paramTransaction.getStatus() == ProxyEventStatus.j) {
          a a = new a();
          xsnk.a("Waiting for response… Downloaded " + a.a(l2) + " of " + a.a(l1) + ".");
        } else {
          a a = new a();
          xsnk.a("AMF data is incomplete (" + a.a(l2) + " of " + a.a(l1) + "). Please check the recording limits in the Recording Settings.");
        } 
      } 
      if (xsnk.n() == null || xsnk.n().equals("null")) {
        n(xsnk);
        a(xsnk);
      } 
      aMFRPC$AMFMethodList.add(xsnk);
    } 
    return aMFRPC$AMFMethodList;
  }
  
  public static q n(byte[] paramArrayOfbyte, e parame) {
    return n(paramArrayOfbyte, "", "/1", parame);
  }
  
  public static q n(byte[] paramArrayOfbyte, q paramq, e parame) {
    String str = !paramq.a().isEmpty() ? (((j)paramq.a().get(0)).getResponse() + "/onResult") : "/1/onResult";
    return n(paramArrayOfbyte, str, "", parame);
  }
  
  private static q n(byte[] paramArrayOfbyte, String paramString1, String paramString2, e parame) {
    try {
      return parame.n(paramArrayOfbyte);
    } catch (NotAMFException notAMFException) {
      try {
        Object object = parame.a(paramArrayOfbyte);
        q q = new q();
        j j = new j(paramString1, paramString2, object);
        q.n(j);
        return q;
      } catch (NotAMFException notAMFException1) {
        throw notAMFException;
      } 
    } 
  }
  
  private static void n(Xsnk paramXsnk) {
    if (paramXsnk.a() instanceof AMFArray) {
      AMFArray aMFArray = (AMFArray)paramXsnk.a();
      if (aMFArray.size() == 1 && aMFArray.get(0) instanceof AMFTypedObject) {
        AMFTypedObject aMFTypedObject = (AMFTypedObject)aMFArray.get(0);
        String str1 = (aMFTypedObject.get("source") != null) ? aMFTypedObject.get("source").toString() : null;
        String str2 = (aMFTypedObject.get("operation") != null) ? aMFTypedObject.get("operation").toString() : null;
        String str3 = (aMFTypedObject.get("destination") != null) ? aMFTypedObject.get("destination").toString() : null;
        if (str1 != null && str1.length() == 0)
          str1 = null; 
        if (str2 != null && str2.length() == 0)
          str2 = null; 
        if (str3 != null && str3.length() == 0)
          str3 = null; 
        if (aMFTypedObject.getClassDefinition().n().equals("flex.messaging.messages.RemotingMessage")) {
          if (str1 != null && str2 != null) {
            paramXsnk.n(str1 + "." + str1);
          } else if (str3 != null && str2 != null) {
            paramXsnk.n(str3 + "." + str3);
          } else if (str2 != null) {
            paramXsnk.n(str2);
          } else {
            paramXsnk.n("Remoting Message");
          } 
          paramXsnk.n(aMFTypedObject.get("body"));
        } else if (aMFTypedObject.getClassDefinition().n().equals("flex.messaging.messages.CommandMessage")) {
          if (str1 != null && str2 != null) {
            paramXsnk.n(str1 + "." + str1);
          } else if (str3 != null && str2 != null) {
            paramXsnk.n(str3 + "." + str3);
          } else if (str2 != null) {
            paramXsnk.n(str2);
          } else {
            paramXsnk.n("Command Message");
          } 
          paramXsnk.n(aMFTypedObject.get("body"));
        } 
      } 
    } 
  }
  
  private static void a(Xsnk paramXsnk) {
    paramXsnk.a(n(paramXsnk.b(), false));
  }
  
  private static Object n(Object paramObject, boolean paramBoolean) {
    if (paramObject instanceof AMFTypedObject) {
      AMFTypedObject aMFTypedObject = (AMFTypedObject)paramObject;
      return n(aMFTypedObject);
    } 
    if (!paramBoolean && paramObject instanceof AMFMixedArray) {
      AMFMixedArray aMFMixedArray = (AMFMixedArray)paramObject;
      for (String str : aMFMixedArray.getKeysInOrder()) {
        Object object = aMFMixedArray.get(str);
        aMFMixedArray.put(str, n(object, true));
      } 
      return paramObject;
    } 
    if (paramObject instanceof l) {
      l l = (l)paramObject;
      l.a(n(l.n(), paramBoolean));
      return paramObject;
    } 
    return paramObject;
  }
  
  private static Object n(AMFTypedObject paramAMFTypedObject) {
    return paramAMFTypedObject.getClassDefinition().n().equals("flex.messaging.messages.AcknowledgeMessage") ? paramAMFTypedObject.get("body") : paramAMFTypedObject;
  }
  
  private static List<j> n(q paramq, String paramString) {
    paramString = paramString + "/";
    ArrayList<j> arrayList = new ArrayList();
    List<j> list = paramq.a();
    for (byte b = 0; b < list.size(); b++) {
      j j = list.get(b);
      if (j.getTarget() != null && j.getTarget().startsWith(paramString))
        arrayList.add(j); 
    } 
    return arrayList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\rpc\AMFRPC.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */