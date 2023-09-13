package com.xk72.lib;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;

public class a extends JsonReader {
  public a(Reader paramReader) {
    super(paramReader);
  }
  
  public String n() {
    JsonToken jsonToken = peek();
    if (jsonToken == JsonToken.NULL) {
      nextNull();
      return null;
    } 
    return nextString();
  }
  
  public Integer a() {
    JsonToken jsonToken = peek();
    if (jsonToken == JsonToken.NULL) {
      nextNull();
      return null;
    } 
    return Integer.valueOf(nextInt());
  }
  
  public int n(int paramInt) {
    JsonToken jsonToken = peek();
    if (jsonToken == JsonToken.NULL) {
      nextNull();
      return paramInt;
    } 
    return nextInt();
  }
  
  public Long b() {
    JsonToken jsonToken = peek();
    if (jsonToken == JsonToken.NULL) {
      nextNull();
      return null;
    } 
    return Long.valueOf(nextLong());
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */