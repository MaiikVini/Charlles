package com.xk72.amf.a;

import com.xk72.amf.AMFMixedArray;
import com.xk72.amf.B;
import com.xk72.amf.a;
import com.xk72.amf.v;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.InputStream;

public class G extends a {
  public Xsnk a(byte[] paramArrayOfbyte) {
    return a(new ByteArrayInputStream(paramArrayOfbyte));
  }
  
  public Xsnk a(InputStream paramInputStream) {
    this.p = new B(paramInputStream);
    n();
    v v = (v)a();
    AMFMixedArray aMFMixedArray = (AMFMixedArray)a();
    return new Xsnk(v.n(), aMFMixedArray);
  }
  
  protected AMFMixedArray n(AMFMixedArray paramAMFMixedArray) {
    try {
      return super.n(paramAMFMixedArray);
    } catch (EOFException eOFException) {
      return paramAMFMixedArray;
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\a\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */