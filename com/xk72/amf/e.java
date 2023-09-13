package com.xk72.amf;

import com.xk72.amf.externalizable.Xsnk;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class e extends a implements d {
  private List<v> r;
  
  private List<s> s;
  
  private List<l> t;
  
  public Object a(InputStream paramInputStream) {
    this.p = new B(paramInputStream);
    n();
    Object object = f();
    this.p.close();
    return object;
  }
  
  public Object a(byte[] paramArrayOfbyte) {
    this.p = new B(new ByteArrayInputStream(paramArrayOfbyte));
    n();
    Object object = f();
    this.p.close();
    return object;
  }
  
  protected void n() {
    super.n();
    this.r = new ArrayList<>();
    this.s = new ArrayList<>();
    this.t = new ArrayList<>();
  }
  
  private String n(Object paramObject) {
    return (paramObject instanceof y) ? ((y)paramObject).getType() : paramObject.getClass().getName();
  }
  
  private void n(s params) {
    this.s.add(params);
  }
  
  private s a(int paramInt) {
    if (paramInt < this.s.size())
      return this.s.get(paramInt); 
    throw new AMFInvalidReferenceException("Reference to non-existent object: " + paramInt);
  }
  
  protected Object n(int paramInt) {
    return (paramInt == 17) ? f() : super.n(paramInt);
  }
  
  public Object f() {
    int i = this.p.readUnsignedByte();
    switch (i) {
      case 0:
        return new x();
      case 1:
        return null;
      case 2:
        return Boolean.FALSE;
      case 3:
        return Boolean.TRUE;
      case 5:
        return b();
      case 4:
        return Integer.valueOf(h());
      case 6:
        return j();
      case 11:
        return p();
      case 8:
        return k();
      case 9:
        return l();
      case 10:
        return m();
      case 7:
        return o();
      case 12:
        return q();
    } 
    throw new AMFException("Unsupported AMF3 packet type " + i + " at " + this.p.a());
  }
  
  private int h() {
    byte b = 0;
    int i = this.p.readUnsignedByte();
    int j = 0;
    while ((i & 0x80) != 0 && b < 3) {
      j <<= 7;
      j |= i & 0x7F;
      i = this.p.readUnsignedByte();
      b++;
    } 
    if (b < 3) {
      j <<= 7;
      j |= i;
    } else {
      j <<= 8;
      j |= i;
      if ((j & 0x10000000) != 0)
        j |= 0xE0000000; 
    } 
    return j;
  }
  
  private String i() {
    return j().n();
  }
  
  private v j() {
    int i = h();
    boolean bool = ((i & 0x1) == 0) ? true : false;
    if (!bool) {
      int k = i >>> 1;
      byte[] arrayOfByte = new byte[k];
      this.p.readFully(arrayOfByte);
      String str = new String(arrayOfByte, "UTF-8");
      v v = new v(str);
      if (str.length() > 0)
        this.r.add(v); 
      return v;
    } 
    int j = i >>> 1;
    if (j < this.r.size())
      try {
        return new w(j, this.r.get(j));
      } catch (ClassCastException classCastException) {
        throw new AMFInvalidReferenceException("Reference to non-string when string required: " + j);
      }  
    throw new AMFInvalidReferenceException("Reference to non-existent string: " + j);
  }
  
  private n k() {
    int i = h();
    boolean bool = ((i & 0x1) == 0) ? true : false;
    if (!bool) {
      double d1 = this.p.readDouble();
      n n = new n(new Date((long)d1));
      n(n);
      return n;
    } 
    int j = i >>> 1;
    try {
      return new o(j, (n)a(j));
    } catch (ClassCastException classCastException) {
      throw new AMFInvalidReferenceException("Reference to non-date when date required: " + j);
    } 
  }
  
  private s l() {
    int i = h();
    boolean bool = ((i & 0x1) == 0) ? true : false;
    if (bool) {
      int k = i >>> 1;
      s s = a(k);
      if (s instanceof AMFArray || s instanceof AMFMixedArray)
        return new r(k, s); 
      throw new AMFInvalidReferenceException("Reference to non-array when array required: " + k);
    } 
    int j = i >>> 1;
    String str = i();
    if (str.length() > 0) {
      AMFMixedArray aMFMixedArray = new AMFMixedArray();
      n(aMFMixedArray);
      while (str.length() > 0) {
        Object object = f();
        aMFMixedArray.put(str, object);
        str = i();
      } 
      for (byte b1 = 0; b1 < j; b1++)
        aMFMixedArray.put("" + b1, f()); 
      return aMFMixedArray;
    } 
    AMFArray aMFArray = new AMFArray();
    n(aMFArray);
    for (byte b = 0; b < j; b++)
      aMFArray.add(f()); 
    return aMFArray;
  }
  
  private s m() {
    c c;
    int i = h();
    boolean bool1 = ((i & 0x1) == 0) ? true : false;
    if (bool1) {
      int k = i >>> 1;
      s s = a(k);
      try {
        return new r(k, s);
      } catch (ClassCastException classCastException) {
        throw new AMFInvalidReferenceException("Reference to non-object instance when object instance required: " + n(s));
      } 
    } 
    int j = i >>> 1;
    boolean bool2 = ((j & 0x1) == 0) ? true : false;
    if (bool2) {
      int k = j >>> 1;
      if (k < this.t.size()) {
        c = (c)this.t.get(k);
      } else {
        throw new AMFInvalidReferenceException("Reference to non-existent class definition: " + k);
      } 
    } else {
      String str = i();
      boolean bool3 = ((j & 0x2) != 0) ? true : false;
      boolean bool4 = ((j & 0x4) != 0) ? true : false;
      int k = j >>> 3;
      c = new c(str, bool3, bool4);
      for (byte b1 = 0; b1 < k; b1++) {
        String str1 = i();
        c.a(str1);
      } 
      this.t.add(c);
    } 
    if (c.c()) {
      AMFExternalizedObject aMFExternalizedObject = Xsnk.n(c);
      n(aMFExternalizedObject);
      aMFExternalizedObject.readExternal(this);
      return aMFExternalizedObject;
    } 
    AMFTypedObject aMFTypedObject = new AMFTypedObject(c);
    n(aMFTypedObject);
    for (byte b = 0; b < c.d(); b++) {
      Object object = f();
      aMFTypedObject.put(c.n(b), object);
    } 
    if (c.a())
      for (String str = i(); str.length() > 0; str = i()) {
        Object object = f();
        aMFTypedObject.put(str, object);
      }  
    return aMFTypedObject;
  }
  
  private s o() {
    int i = h();
    boolean bool = ((i & 0x1) == 0) ? true : false;
    if (bool) {
      int k = i >>> 1;
      try {
        A a2 = (A)a(k);
        return new r(k, a2);
      } catch (ClassCastException classCastException) {
        throw new AMFInvalidReferenceException("Reference to non-XML Document when XML Document required: " + k);
      } 
    } 
    int j = i >>> 1;
    byte[] arrayOfByte = new byte[j];
    this.p.readFully(arrayOfByte);
    String str = new String(arrayOfByte, "UTF-8");
    A a1 = new A(str);
    n(a1);
    return a1;
  }
  
  private s p() {
    int i = h();
    boolean bool = ((i & 0x1) == 0) ? true : false;
    if (bool) {
      int k = i >>> 1;
      try {
        z z1 = (z)a(k);
        return new r(k, z1);
      } catch (ClassCastException classCastException) {
        throw new AMFInvalidReferenceException("Reference to non-XML when XML required: " + k);
      } 
    } 
    int j = i >>> 1;
    byte[] arrayOfByte = new byte[j];
    this.p.readFully(arrayOfByte);
    String str = new String(arrayOfByte, "UTF-8");
    z z = new z(str);
    n(z);
    return z;
  }
  
  private s q() {
    int i = h();
    boolean bool = ((i & 0x1) == 0) ? true : false;
    if (bool) {
      int m = i >>> 1;
      try {
        k k1 = (k)a(m);
        return new r(m, k1);
      } catch (ClassCastException classCastException) {
        throw new AMFInvalidReferenceException("Reference to non-byte array when byte array required: " + m);
      } 
    } 
    int j = i >>> 1;
    byte[] arrayOfByte = new byte[j];
    this.p.readFully(arrayOfByte);
    k k = new k(arrayOfByte);
    n(k);
    return k;
  }
  
  public int g() {
    return this.p.readUnsignedByte();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\e.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */