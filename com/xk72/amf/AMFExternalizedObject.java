package com.xk72.amf;

public abstract class AMFExternalizedObject extends AMFTypedObject {
  private static final long serialVersionUID = 2624403841096699313L;
  
  private Object data;
  
  public AMFExternalizedObject(l paraml) {
    super(paraml);
  }
  
  public String getType() {
    return "Externalized Object";
  }
  
  public Object getData() {
    return this.data;
  }
  
  public void setData(Object paramObject) {
    this.data = paramObject;
  }
  
  public abstract void readExternal(e parame);
  
  public abstract void writeExternal(f paramf);
  
  public int hashCode() {
    byte b = 31;
    null = super.hashCode();
    return 31 * null + ((this.data == null) ? 0 : this.data.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!super.equals(paramObject))
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    AMFExternalizedObject aMFExternalizedObject = (AMFExternalizedObject)paramObject;
    if (this.data == null) {
      if (aMFExternalizedObject.data != null)
        return false; 
    } else if (!this.data.equals(aMFExternalizedObject.data)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\amf\AMFExternalizedObject.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */