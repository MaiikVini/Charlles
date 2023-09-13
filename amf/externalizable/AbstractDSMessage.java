package com.xk72.amf.externalizable;

import com.xk72.amf.AMFExternalizedObject;
import com.xk72.amf.AMFObject;
import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDSMessage extends AMFExternalizedObject {
  private static final long serialVersionUID = 4062545882649482186L;
  
  private static final String n = "abstractMessage";
  
  private static final String[][] a = new String[][] { { "body", "clientId", "destination", "headers", "messageId", "timestamp", "timeToLive" }, { "clientIdBytes", "messageIdBytes" } };
  
  public AbstractDSMessage(l paraml) {
    super(paraml);
  }
  
  public abstract String getAlias();
  
  public void readExternal(e parame) {
    setData(new AMFObject());
    readDSData(parame, a, "abstractMessage");
  }
  
  public void writeExternal(f paramf) {
    writeDSData(paramf, a, "abstractMessage");
  }
  
  protected short[] readFlags(e parame) {
    boolean bool = true;
    short[] arrayOfShort = new short[2];
    for (byte b = 0; bool; b++) {
      short s = (short)parame.g();
      if (b == arrayOfShort.length) {
        short[] arrayOfShort1 = new short[b * 2];
        System.arraycopy(arrayOfShort, 0, arrayOfShort1, 0, arrayOfShort.length);
        arrayOfShort = arrayOfShort1;
      } 
      arrayOfShort[b] = s;
      if ((s & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
    } 
    return arrayOfShort;
  }
  
  protected void readBlazeDSTrailers(e parame, AMFObject paramAMFObject, String paramString, short paramShort1, short paramShort2) {
    if (paramShort1 >> paramShort2 != 0) {
      ArrayList<Object> arrayList = new ArrayList();
      short s;
      for (s = paramShort2; s < 6; s = (short)(s + 1)) {
        if ((paramShort1 >> s & 0x1) != 0) {
          arrayList.add(parame.f());
        } else {
          arrayList.add(null);
        } 
      } 
      paramAMFObject.put(paramString, arrayList);
    } 
  }
  
  protected void readDSData(e parame, String[][] paramArrayOfString, String paramString) {
    AMFObject aMFObject = (AMFObject)getData();
    short[] arrayOfShort = readFlags(parame);
    for (byte b = 0; b < arrayOfShort.length; b++) {
      short s = arrayOfShort[b];
      short s1 = 0;
      if (b < paramArrayOfString.length) {
        for (byte b1 = 0; b1 < (paramArrayOfString[b]).length; b1++) {
          if ((s & 1 << b1) != 0)
            aMFObject.put(paramArrayOfString[b][b1], parame.f()); 
        } 
        s1 = (short)(paramArrayOfString[b]).length;
      } 
      readBlazeDSTrailers(parame, aMFObject, paramString + "Trailers" + paramString, s, s1);
    } 
  }
  
  protected void readDSData(e parame, String[] paramArrayOfString, String paramString) {
    readDSData(parame, new String[][] { paramArrayOfString }, paramString);
  }
  
  protected void writeDSData(f paramf, String[][] paramArrayOfString, String paramString) {
    AMFObject aMFObject = (AMFObject)getData();
    short[] arrayOfShort = new short[paramArrayOfString.length];
    int i;
    for (i = 0; i < paramArrayOfString.length; i++) {
      for (byte b = 0; b < (paramArrayOfString[i]).length; b++) {
        if (aMFObject.get(paramArrayOfString[i][b]) != null)
          arrayOfShort[i] = (short)(arrayOfShort[i] | 1 << b); 
      } 
      List list = (List)aMFObject.get(paramString + "Trailers" + paramString);
      if (list != null) {
        int k = (paramArrayOfString[i]).length;
        for (byte b1 = 0; k < 6 && b1 < list.size(); b1++) {
          if (list.get(b1) != null)
            arrayOfShort[i] = (short)(arrayOfShort[i] | 1 << k); 
          k++;
        } 
      } 
    } 
    i = 0;
    int j;
    for (j = arrayOfShort.length - 1; j >= 0; j--) {
      if (arrayOfShort[j] != 0) {
        i = j;
        break;
      } 
    } 
    for (j = 0; j <= i; j++) {
      if (j < i) {
        paramf.n(arrayOfShort[j] | 0x80);
      } else {
        paramf.n(arrayOfShort[j]);
      } 
    } 
    for (j = 0; j < paramArrayOfString.length; j++) {
      for (byte b = 0; b < (paramArrayOfString[j]).length; b++) {
        Object object = aMFObject.get(paramArrayOfString[j][b]);
        if (object != null)
          paramf.c(object); 
      } 
      List list = (List)aMFObject.get(paramString + "Trailers" + paramString);
      if (list != null) {
        int k = (paramArrayOfString[j]).length;
        for (byte b1 = 0; k < 6 && b1 < list.size(); b1++) {
          if (list.get(b1) != null)
            paramf.c(list.get(b1)); 
          k++;
        } 
      } 
    } 
  }
  
  protected void writeDSData(f paramf, String[] paramArrayOfString, String paramString) {
    writeDSData(paramf, new String[][] { paramArrayOfString }, paramString);
  }
  
  protected short calculateBlazeDSTrailersFlag(AMFObject paramAMFObject, String paramString, short paramShort1, short paramShort2) {
    List list = (List)paramAMFObject.get(paramString);
    if (list != null) {
      short s;
      for (s = paramShort2; s < 6; s = (short)(s + 1)) {
        if (s - paramShort2 < list.size() && list.get(s - paramShort2) != null)
          paramShort1 = (short)(paramShort1 | 1 << s); 
      } 
    } 
    return paramShort1;
  }
  
  protected void writeBlazeDSTrailers(f paramf, AMFObject paramAMFObject, String paramString, short paramShort) {
    List list = (List)paramAMFObject.get(paramString);
    if (list != null) {
      short s;
      for (s = paramShort; s < 6; s = (short)(s + 1)) {
        if (s - paramShort < list.size() && list.get(s - paramShort) != null)
          paramf.c(list.get(s - paramShort)); 
      } 
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\AbstractDSMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */