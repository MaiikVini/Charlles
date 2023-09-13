package com.xk72.amf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class b implements G {
  private boolean q = true;
  
  protected C p;
  
  private List<s> r;
  
  public byte[] n(q paramq) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    n(paramq, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  public void n(q paramq, OutputStream paramOutputStream) {
    this.p = new C(paramOutputStream);
    a(paramq);
    b(paramq);
    this.p.close();
  }
  
  protected void n() {
    this.r = new ArrayList<>();
  }
  
  private void a(q paramq) {
    this.p.writeShort(paramq.n());
    int i = paramq.b().size();
    this.p.writeShort(i);
    n();
    for (byte b1 = 0; b1 < i; b1++) {
      p p = paramq.b().get(b1);
      n(p.getName());
      a(p.isMustUnderstand());
      n(p.getContent());
    } 
  }
  
  private void b(q paramq) {
    int i = paramq.a().size();
    this.p.writeShort(i);
    for (byte b1 = 0; b1 < i; b1++) {
      n();
      j j = paramq.a().get(b1);
      n(j.getTarget());
      n(j.getResponse());
      n(j.getData());
    } 
  }
  
  protected void n(Object paramObject) {
    if (this.q) {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      C c1 = new C(byteArrayOutputStream);
      C c2 = this.p;
      this.p = c1;
      a(paramObject);
      c1.close();
      c2.writeInt(byteArrayOutputStream.size());
      c2.write(byteArrayOutputStream.toByteArray());
      this.p = c2;
    } else {
      this.p.writeInt(-1);
      a(paramObject);
    } 
  }
  
  protected void a(Object paramObject) {
    if (paramObject == null) {
      this.p.writeByte(5);
    } else if (paramObject instanceof Number) {
      this.p.writeByte(0);
      n((Number)paramObject);
    } else if (paramObject instanceof Boolean) {
      this.p.writeByte(1);
      a(((Boolean)paramObject).booleanValue());
    } else if (paramObject instanceof v) {
      this.p.writeByte(2);
      n((v)paramObject);
    } else if (paramObject instanceof String) {
      this.p.writeByte(2);
      n((String)paramObject);
    } else if (paramObject instanceof AMFTypedObject) {
      n((AMFTypedObject)paramObject);
    } else if (paramObject instanceof AMFObject) {
      n((AMFObject)paramObject);
    } else if (paramObject instanceof r) {
      n((AMFObject)((r)paramObject).c());
    } else if (paramObject instanceof AMFMixedArray) {
      a((AMFMixedArray)paramObject);
    } else if (paramObject instanceof AMFArray) {
      n((AMFArray)paramObject);
    } else if (paramObject instanceof x) {
      this.p.writeByte(6);
    } else if (paramObject instanceof n) {
      this.p.writeByte(11);
      n((n)paramObject);
    } else if (paramObject instanceof i) {
      this.p.writeByte(13);
      n((i)paramObject);
    } else if (paramObject instanceof A) {
      this.p.writeByte(15);
      n((A)paramObject);
    } else {
      throw new AMFException("AMF contained unrecognised type: " + paramObject.getClass().getName());
    } 
  }
  
  private boolean n(s params) {
    int i = this.r.indexOf(params);
    if (i != -1) {
      n(i);
      return true;
    } 
    this.r.add(params);
    return false;
  }
  
  private void n(AMFObject paramAMFObject) {
    if (!n(paramAMFObject)) {
      this.p.writeByte(3);
      n(paramAMFObject);
    } 
  }
  
  private void n(AMFMixedArray paramAMFMixedArray) {
    for (String str : paramAMFMixedArray.getKeysInOrder()) {
      n(str);
      a(paramAMFMixedArray.get(str));
    } 
    n("");
    this.p.writeByte(9);
  }
  
  private void n(AMFArray paramAMFArray) {
    if (!n(paramAMFArray)) {
      this.p.writeByte(10);
      int i = paramAMFArray.size();
      this.p.writeInt(i);
      for (byte b1 = 0; b1 < i; b1++)
        a(paramAMFArray.get(b1)); 
    } 
  }
  
  private void a(AMFMixedArray paramAMFMixedArray) {
    if (!n(paramAMFMixedArray)) {
      this.p.writeByte(8);
      this.p.writeInt(0);
      n(paramAMFMixedArray);
    } 
  }
  
  private void n(AMFTypedObject paramAMFTypedObject) {
    if (!n(paramAMFTypedObject)) {
      this.p.writeByte(16);
      n(paramAMFTypedObject.getClassDefinition().n());
      n(paramAMFTypedObject);
    } 
  }
  
  protected void n(Number paramNumber) {
    this.p.writeDouble(paramNumber.doubleValue());
  }
  
  private void a(boolean paramBoolean) {
    this.p.writeByte(paramBoolean ? 1 : 0);
  }
  
  private void n(v paramv) {
    n(paramv.n());
  }
  
  private void n(String paramString) {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    int i = arrayOfByte.length;
    this.p.writeShort(i);
    this.p.write(arrayOfByte);
  }
  
  protected void n(n paramn) {
    Date date = paramn.n();
    long l = date.getTime();
    int i = paramn.a() / -60000;
    this.p.writeDouble(l);
    this.p.writeShort(i);
  }
  
  private void n(A paramA) {
    this.p.n(paramA.n());
  }
  
  private void n(int paramInt) {
    this.p.write(7);
    this.p.writeShort(paramInt);
  }
  
  private void n(i parami) {}
  
  public boolean a() {
    return this.q;
  }
  
  public void n(boolean paramBoolean) {
    this.q = paramBoolean;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */