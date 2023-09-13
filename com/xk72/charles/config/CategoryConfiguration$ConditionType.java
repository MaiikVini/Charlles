package com.xk72.charles.config;

public enum CategoryConfiguration$ConditionType {
  n("Request Method"),
  a("Response Code"),
  b("Request Header"),
  c("Response Header"),
  d("Tag");
  
  private final String display;
  
  CategoryConfiguration$ConditionType(String paramString1) {
    this.display = paramString1;
  }
  
  public String toString() {
    return this.display;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\CategoryConfiguration$ConditionType.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */