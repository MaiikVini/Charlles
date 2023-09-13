package com.xk72.amf.externalizable;

import com.xk72.amf.AMFExternalizedObject;
import com.xk72.amf.AMFParseException;
import com.xk72.amf.e;
import com.xk72.amf.f;
import com.xk72.amf.l;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnknownExternalizable extends AMFExternalizedObject {
  private static final long serialVersionUID = -8534099931301882197L;
  
  private static final Logger n = Logger.getLogger("com.xk72.amf.externalizable.UnknownExternalizable");
  
  public UnknownExternalizable(l paraml) {
    super(paraml);
  }
  
  public void readExternal(e parame) {
    if (n.isLoggable(Level.WARNING))
      n.warning("Warning: Unknown externalizable class: " + getClassDefinition().n()); 
    try {
      setData(parame.f());
    } catch (AMFParseException aMFParseException) {
      throw aMFParseException;
    } catch (IOException iOException) {
      n.log(Level.SEVERE, "Unsupported externalizable class: " + getClassDefinition().n(), iOException);
      throw new AMFParseException("Unsupported externalizable class: " + getClassDefinition().n());
    } 
  }
  
  public void writeExternal(f paramf) {
    paramf.c(getData());
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\externalizable\UnknownExternalizable.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */