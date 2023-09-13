package com.xk72.amf;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class a implements G {
  protected B p;
  
  private List<y> q;
  
  private boolean r;
  
  public q n(byte[] paramArrayOfbyte) {
    return n(new ByteArrayInputStream(paramArrayOfbyte));
  }
  
  public q n(InputStream paramInputStream) {
    q q = new q();
    this.p = new B(paramInputStream);
    n(q);
    a(q);
    if (this.r) {
      byte b = 0;
      try {
        while (true) {
          this.p.readUnsignedByte();
          b++;
        } 
      } catch (EOFException eOFException) {
        if (b > 0)
          throw new AMFException("" + b + " extra bytes after deserialization"); 
      } 
    } 
    this.p.close();
    return q;
  }
  
  protected void n() {
    this.q = new ArrayList<>();
  }
  
  protected void n(q paramq) {
    int i = this.p.readUnsignedShort();
    if (i != 0 && i != 3)
      throw new NotAMFException("Unsupported AMF version or corrupted data: " + i); 
    paramq.n(i);
    short s = this.p.readShort();
    if (s < 0)
      throw new NotAMFException("Invalid header count, probably not AMF or corrupted data"); 
    n();
    for (byte b = 0; b < s; b++) {
      String str = c();
      boolean bool = this.p.readBoolean();
      this.p.readInt();
      Object object = a();
      paramq.n(new p(str, bool, object));
    } 
  }
  
  protected void a(q paramq) {
    short s = this.p.readShort();
    if (s < 0)
      throw new NotAMFException("Invalid body count, probably not AMF or corrupted data"); 
    for (byte b = 0; b < s; b++) {
      n();
      String str1 = null;
      String str2 = null;
      try {
        str1 = c();
      } catch (EOFException eOFException) {
        break;
      } 
      str2 = c();
      this.p.readInt();
      Object object = a();
      paramq.n(new j(str1, str2, object));
    } 
  }
  
  protected Object a() {
    int i = this.p.readUnsignedByte();
    return n(i);
  }
  
  protected Object n(int paramInt) {
    switch (paramInt) {
      case 0:
        return b();
      case 1:
        return j();
      case 2:
        return k();
      case 3:
        return f();
      case 5:
        return null;
      case 6:
        return new x();
      case 7:
        return m();
      case 8:
        return h();
      case 10:
        return g();
      case 11:
        return d();
      case 13:
        return o();
      case 15:
        return l();
      case 16:
        return i();
    } 
    throw new AMFException("AMF contained unrecognised type: " + paramInt);
  }
  
  private void n(s params) {
    this.q.add(params);
  }
  
  private AMFObject f() {
    AMFObject aMFObject = new AMFObject();
    n(aMFObject);
    return aMFObject;
  }
  
  protected AMFMixedArray n(AMFMixedArray paramAMFMixedArray) {
    n(paramAMFMixedArray);
    String str = c();
    for (int i = this.p.readUnsignedByte(); i != 9; i = this.p.readUnsignedByte()) {
      Object object = n(i);
      paramAMFMixedArray.put(str, object);
      str = c();
    } 
    return paramAMFMixedArray;
  }
  
  private AMFArray g() {
    AMFArray aMFArray = new AMFArray();
    n(aMFArray);
    long l = this.p.readInt();
    for (byte b = 0; b < l; b++)
      aMFArray.add(a()); 
    return aMFArray;
  }
  
  private AMFMixedArray h() {
    this.p.readInt();
    AMFMixedArray aMFMixedArray = new AMFMixedArray();
    n(aMFMixedArray);
    return aMFMixedArray;
  }
  
  private AMFTypedObject i() {
    String str = c();
    AMFTypedObject aMFTypedObject = new AMFTypedObject(new Xsnk(str));
    n(aMFTypedObject);
    return aMFTypedObject;
  }
  
  protected Double b() {
    return Double.valueOf(this.p.readDouble());
  }
  
  private Boolean j() {
    return (this.p.readUnsignedByte() == 1) ? Boolean.TRUE : Boolean.FALSE;
  }
  
  private v k() {
    try {
      int i = this.p.readUnsignedShort();
      byte[] arrayOfByte = new byte[i];
      this.p.readFully(arrayOfByte);
      return new v(new String(arrayOfByte, "UTF-8"));
    } catch (UTFDataFormatException uTFDataFormatException) {
      return new v(uTFDataFormatException.toString());
    } 
  }
  
  protected String c() {
    return k().n();
  }
  
  protected n d() {
    double d = this.p.readDouble();
    short s = this.p.readShort();
    int i = s * 60000 * -1;
    return new n(new Date((long)d), i);
  }
  
  private A l() {
    try {
      return new A(this.p.n());
    } catch (UTFDataFormatException uTFDataFormatException) {
      return new A(uTFDataFormatException.toString());
    } 
  }
  
  private r m() {
    short s = this.p.readShort();
    r r = new r(s);
    if (s < this.q.size())
      r.n((s)this.q.get(s)); 
    return r;
  }
  
  private i o() {
    return new i();
  }
  
  public boolean e() {
    return this.r;
  }
  
  public void n(boolean paramBoolean) {
    this.r = paramBoolean;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */