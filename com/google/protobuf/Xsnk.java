package com.google.protobuf;

import java.io.IOException;

public class Xsnk {
  public static String n(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject) {
    if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM && ((Descriptors.EnumValueDescriptor)paramObject).getIndex() < 0)
      return String.valueOf(((Descriptors.EnumValueDescriptor)paramObject).getNumber()); 
    StringBuffer stringBuffer = new StringBuffer();
    try {
      TextFormat.printer().printFieldValue(paramFieldDescriptor, paramObject, stringBuffer);
    } catch (IOException iOException) {}
    return ((paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.STRING || paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.BYTES) && stringBuffer.length() > 1 && stringBuffer.charAt(0) == '"' && stringBuffer.charAt(stringBuffer.length() - 1) == '"') ? stringBuffer.substring(1, stringBuffer.length() - 1) : stringBuffer.toString();
  }
  
  public static Object n(Descriptors.FieldDescriptor paramFieldDescriptor) {
    switch (G.n[paramFieldDescriptor.getJavaType().ordinal()]) {
      case 1:
        return paramFieldDescriptor.getEnumType().getValues().get(0);
      case 2:
        return Integer.valueOf(0);
      case 3:
        return Long.valueOf(0L);
      case 4:
        return Float.valueOf(0.0F);
      case 5:
        return Double.valueOf(0.0D);
      case 6:
        return Boolean.FALSE;
      case 7:
        return "";
      case 8:
        return ByteString.EMPTY;
    } 
    throw new IllegalArgumentException();
  }
  
  public static Object n(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString) {
    Descriptors.EnumValueDescriptor enumValueDescriptor;
    switch (G.a[paramFieldDescriptor.getType().ordinal()]) {
      case 1:
      case 2:
      case 3:
        return Integer.valueOf(TextFormat.parseInt32(paramString));
      case 4:
      case 5:
        return Integer.valueOf(TextFormat.parseUInt32(paramString));
      case 6:
      case 7:
      case 8:
        return Long.valueOf(TextFormat.parseInt64(paramString));
      case 9:
      case 10:
        return Long.valueOf(TextFormat.parseUInt64(paramString));
      case 11:
        return paramString.equals("inf") ? Float.valueOf(Float.POSITIVE_INFINITY) : (paramString.equals("-inf") ? Float.valueOf(Float.NEGATIVE_INFINITY) : (paramString.equals("nan") ? Float.valueOf(Float.NaN) : Float.valueOf(paramString)));
      case 12:
        return paramString.equals("inf") ? Double.valueOf(Double.POSITIVE_INFINITY) : (paramString.equals("-inf") ? Double.valueOf(Double.NEGATIVE_INFINITY) : (paramString.equals("nan") ? Double.valueOf(Double.NaN) : Double.valueOf(paramString)));
      case 13:
        return Boolean.valueOf(paramString);
      case 14:
        try {
          return TextFormat.unescapeText(paramString);
        } catch (InvalidEscapeSequenceException invalidEscapeSequenceException) {
          throw new RuntimeException(invalidEscapeSequenceException);
        } 
      case 15:
        try {
          return TextFormat.unescapeBytes(paramString);
        } catch (InvalidEscapeSequenceException invalidEscapeSequenceException) {
          throw new RuntimeException(invalidEscapeSequenceException);
        } 
      case 16:
        enumValueDescriptor = paramFieldDescriptor.getEnumType().findValueByName(paramString);
        if (enumValueDescriptor == null && paramFieldDescriptor.getFile().supportsUnknownEnumValue())
          try {
            int i = Integer.parseInt(paramString);
            enumValueDescriptor = paramFieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(i);
          } catch (RuntimeException runtimeException) {} 
        if (enumValueDescriptor == null)
          throw new RuntimeException("Unknown enum value: \"" + paramString + "\""); 
        return enumValueDescriptor;
    } 
    throw new RuntimeException("Shouldn't get here.");
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\google\protobuf\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */