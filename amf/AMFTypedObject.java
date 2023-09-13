package com.xk72.amf;

public class AMFTypedObject extends AMFObject {
  private static final long serialVersionUID = -1554710831871072658L;
  
  private final l classDefinition;
  
  public AMFTypedObject(l paraml) {
    this.classDefinition = paraml;
  }
  
  public String getName() {
    return this.classDefinition.n();
  }
  
  public String toString() {
    String str = getName();
    return (str != null) ? (str + ": " + str) : super.toString();
  }
  
  public l getClassDefinition() {
    return this.classDefinition;
  }
  
  public boolean isAMF3Object() {
    return (this.classDefinition != null && this.classDefinition instanceof c);
  }
  
  public int hashCode() {
    byte b = 31;
    null = super.hashCode();
    return 31 * null + ((this.classDefinition == null) ? 0 : this.classDefinition.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!super.equals(paramObject))
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    AMFTypedObject aMFTypedObject = (AMFTypedObject)paramObject;
    if (this.classDefinition == null) {
      if (aMFTypedObject.classDefinition != null)
        return false; 
    } else if (!this.classDefinition.equals(aMFTypedObject.classDefinition)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\AMFTypedObject.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */