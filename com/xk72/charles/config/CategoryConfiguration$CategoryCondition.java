package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.util.B;
import com.xk72.util.C;
import com.xk72.util.f;

@XStreamAlias("condition")
@B
@C
public class CategoryConfiguration$CategoryCondition implements f {
  private CategoryConfiguration$ConditionType type;
  
  private String name;
  
  private String value;
  
  private boolean regex;
  
  private boolean caseSensitive;
  
  private boolean matchWholeValue = true;
  
  private boolean negate;
  
  public CategoryConfiguration$CategoryCondition clone() {
    CategoryConfiguration$CategoryCondition categoryConfiguration$CategoryCondition = new CategoryConfiguration$CategoryCondition();
    categoryConfiguration$CategoryCondition.type = this.type;
    categoryConfiguration$CategoryCondition.name = this.name;
    categoryConfiguration$CategoryCondition.value = this.value;
    categoryConfiguration$CategoryCondition.regex = this.regex;
    categoryConfiguration$CategoryCondition.caseSensitive = this.caseSensitive;
    categoryConfiguration$CategoryCondition.matchWholeValue = this.matchWholeValue;
    categoryConfiguration$CategoryCondition.negate = this.negate;
    return categoryConfiguration$CategoryCondition;
  }
  
  public CategoryConfiguration$ConditionType getType() {
    return this.type;
  }
  
  public void setType(CategoryConfiguration$ConditionType paramCategoryConfiguration$ConditionType) {
    this.type = paramCategoryConfiguration$ConditionType;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public void setValue(String paramString) {
    this.value = paramString;
  }
  
  public boolean isRegex() {
    return this.regex;
  }
  
  public void setRegex(boolean paramBoolean) {
    this.regex = paramBoolean;
  }
  
  public boolean isCaseSensitive() {
    return this.caseSensitive;
  }
  
  public void setCaseSensitive(boolean paramBoolean) {
    this.caseSensitive = paramBoolean;
  }
  
  public void setMatchWholeValue(boolean paramBoolean) {
    this.matchWholeValue = paramBoolean;
  }
  
  public boolean isMatchWholeValue() {
    return this.matchWholeValue;
  }
  
  public void setNegate(boolean paramBoolean) {
    this.negate = paramBoolean;
  }
  
  public boolean isNegate() {
    return this.negate;
  }
  
  public String toString() {
    String str = this.negate ? " != " : " = ";
    switch (Xsnk.n[this.type.ordinal()]) {
      case 1:
        return "Method" + str + this.value;
      case 2:
        return "Code" + str + this.value;
      case 3:
      case 4:
        return this.name + this.name + str;
      case 5:
        return "Tag" + str + this.value;
    } 
    return null;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\CategoryConfiguration$CategoryCondition.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */