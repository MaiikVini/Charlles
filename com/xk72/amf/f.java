package com.xk72.amf;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class f extends b implements d {
  private static final int r = 128;
  
  private static final int s = 16384;
  
  private static final int t = 2097152;
  
  private static final boolean u = false;
  
  private List<String> v;
  
  private List<s> w;
  
  private List<c> x;
  
  public byte[] b(Object paramObject) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      this.p = new C(byteArrayOutputStream);
      c(paramObject);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.close();
      return arrayOfByte;
    } catch (Throwable throwable) {
      try {
        byteArrayOutputStream.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      } 
      throw throwable;
    } 
  }
  
  protected void n() {
    super.n();
    this.v = new ArrayList<>();
    this.w = new ArrayList<>();
    this.x = new ArrayList<>();
  }
  
  private int n(Object paramObject, List<?> paramList) {
    int i = paramList.size();
    for (byte b1 = 0; b1 < i; b1++) {
      if (paramList.get(b1) == paramObject)
        return b1; 
    } 
    return -1;
  }
  
  protected void a(Object paramObject) {
    boolean bool = false;
    if (paramObject instanceof Integer) {
      bool = true;
    } else if (paramObject instanceof AMFTypedObject) {
      bool = ((AMFTypedObject)paramObject).isAMF3Object();
    } 
    if (bool) {
      this.p.writeByte(17);
      c(paramObject);
    } else {
      super.a(paramObject);
    } 
  }
  
  public void c(Object paramObject) {
    if (paramObject == null) {
      this.p.writeByte(1);
    } else if (paramObject instanceof x) {
      this.p.writeByte(0);
    } else if (paramObject instanceof Boolean) {
      this.p.writeByte(((Boolean)paramObject).booleanValue() ? 3 : 2);
    } else if (paramObject instanceof Integer) {
      this.p.writeByte(4);
      a(((Integer)paramObject).intValue());
    } else if (paramObject instanceof Number) {
      this.p.writeByte(5);
      n((Number)paramObject);
    } else if (paramObject instanceof t) {
      c(((t)paramObject).c());
    } else if (paramObject instanceof v) {
      this.p.writeByte(6);
      n((v)paramObject);
    } else if (paramObject instanceof String) {
      this.p.writeByte(6);
      n((String)paramObject);
    } else if (paramObject instanceof AMFTypedObject) {
      this.p.writeByte(10);
      n((AMFTypedObject)paramObject);
    } else if (paramObject instanceof AMFArray) {
      this.p.writeByte(9);
      n((AMFArray)paramObject);
    } else if (paramObject instanceof AMFMixedArray) {
      this.p.writeByte(9);
      n((AMFMixedArray)paramObject);
    } else if (paramObject instanceof n) {
      this.p.writeByte(8);
      a((n)paramObject);
    } else if (paramObject instanceof A) {
      this.p.write(7);
      n((A)paramObject);
    } else if (paramObject instanceof z) {
      this.p.write(11);
      n((z)paramObject);
    } else if (paramObject instanceof k) {
      this.p.write(12);
      n((k)paramObject);
    } else {
      throw new AMFException("AMF contained unrecognised type: " + paramObject.getClass().getName());
    } 
  }
  
  private void a(int paramInt) {
    if (paramInt < -268435456 || paramInt > 268435455)
      throw new AMFException("Integer out of range: " + paramInt); 
    if (paramInt < 0 || paramInt >= 2097152) {
      this.p.writeByte(paramInt >> 22 | 0x80);
      this.p.writeByte(paramInt >> 15 | 0x80);
      this.p.writeByte(paramInt >> 8 | 0x80);
      this.p.writeByte(paramInt);
    } else if (paramInt >= 16384) {
      this.p.writeByte(paramInt >> 14 | 0x80);
      this.p.writeByte(paramInt >> 7 | 0x80);
      this.p.writeByte(paramInt & 0x7F);
    } else if (paramInt >= 128) {
      this.p.writeByte(paramInt >> 7 | 0x80);
      this.p.writeByte(paramInt & 0x7F);
    } else {
      this.p.writeByte(paramInt);
    } 
  }
  
  private void n(String paramString) {
    int i = this.v.indexOf(paramString);
    if (i != -1) {
      a(i << 1);
    } else {
      if (paramString.length() > 0)
        this.v.add(paramString); 
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      a((arrayOfByte.length << 1) + 1);
      this.p.write(arrayOfByte);
    } 
  }
  
  private void n(v paramv) {
    n(paramv.n());
  }
  
  private void a(n paramn) {
    int i = n(paramn, this.w);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramn);
      a(1);
      this.p.writeDouble(paramn.n().getTime());
    } 
  }
  
  private void n(AMFMixedArray paramAMFMixedArray) {
    int i = n(paramAMFMixedArray, this.w);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramAMFMixedArray);
      List<String> list = paramAMFMixedArray.getKeysInOrder();
      int j = list.size();
      int k = list.indexOf("0");
      if (k == -1)
        k = j; 
      int m = j - k;
      a((m << 1) + 1);
      byte b1;
      for (b1 = 0; b1 < k; b1++) {
        String str = list.get(b1);
        n(str);
        c(paramAMFMixedArray.get(str));
      } 
      n("");
      for (b1 = 0; b1 < m; b1++)
        c(paramAMFMixedArray.get("" + b1)); 
    } 
  }
  
  private void n(AMFArray paramAMFArray) {
    int i = n(paramAMFArray, this.w);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramAMFArray);
      a((paramAMFArray.size() << 1) + 1);
      n("");
      for (Object object : paramAMFArray)
        c(object); 
    } 
  }
  
  private void n(AMFTypedObject paramAMFTypedObject) {
    int i = n(paramAMFTypedObject, this.w);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramAMFTypedObject);
      c c = (c)paramAMFTypedObject.getClassDefinition();
      i = this.x.indexOf(c);
      if (i != -1) {
        a((i << 2) + 1);
      } else {
        this.x.add(c);
        int j = (c.c() ? 2 : 0) | (c.a() ? 4 : 0) | c.d() << 3;
        a((j << 1) + 3);
        n(c.n());
        for (byte b1 = 0; b1 < c.d(); b1++)
          n(c.n(b1)); 
      } 
      if (c.c()) {
        AMFExternalizedObject aMFExternalizedObject = (AMFExternalizedObject)paramAMFTypedObject;
        aMFExternalizedObject.writeExternal(this);
      } else {
        for (byte b1 = 0; b1 < c.d(); b1++)
          c(paramAMFTypedObject.get(c.n(b1))); 
        if (c.a()) {
          List<String> list = paramAMFTypedObject.getKeysInOrder();
          for (String str : list) {
            if (!c.b(str)) {
              n(str);
              c(paramAMFTypedObject.get(str));
            } 
          } 
          n("");
        } 
      } 
    } 
  }
  
  private void n(A paramA) {
    int i = this.w.indexOf(paramA);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramA);
      byte[] arrayOfByte = paramA.n().getBytes("UTF-8");
      a((arrayOfByte.length << 1) + 1);
      this.p.write(arrayOfByte);
    } 
  }
  
  private void n(z paramz) {
    int i = this.w.indexOf(paramz);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramz);
      byte[] arrayOfByte = paramz.n().getBytes("UTF-8");
      a((arrayOfByte.length << 1) + 1);
      this.p.write(arrayOfByte);
    } 
  }
  
  private void n(k paramk) {
    int i = this.w.indexOf(paramk);
    if (i != -1) {
      a(i << 1);
    } else {
      this.w.add(paramk);
      byte[] arrayOfByte = paramk.n();
      a((arrayOfByte.length << 1) + 1);
      this.p.write(arrayOfByte);
    } 
  }
  
  public void n(int paramInt) {
    this.p.writeByte(paramInt);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\f.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */