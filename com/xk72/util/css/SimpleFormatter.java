package com.xk72.util.css;

public class SimpleFormatter {
  public static String n(String paramString) {
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    G g = new G();
    SimpleFormatter$State simpleFormatter$State = SimpleFormatter$State.n;
    SimpleFormatter$Type simpleFormatter$Type = SimpleFormatter$Type.n;
    for (byte b = 0; b < arrayOfChar.length; b++) {
      char c = arrayOfChar[b];
      boolean bool = false;
      byte b1 = 0;
      switch (Xsnk.a[simpleFormatter$State.ordinal()]) {
        case 1:
          if (c == '*') {
            simpleFormatter$State = SimpleFormatter$State.b;
            break;
          } 
          simpleFormatter$State = SimpleFormatter$State.n;
        case 2:
          switch (c) {
            case '/':
              simpleFormatter$State = SimpleFormatter$State.a;
              break;
            case '\\':
              simpleFormatter$State = SimpleFormatter$State.f;
              break;
            case '\'':
              simpleFormatter$State = SimpleFormatter$State.d;
              break;
            case '"':
              simpleFormatter$State = SimpleFormatter$State.e;
              break;
            case '}':
              simpleFormatter$Type = SimpleFormatter$Type.n;
              g.a();
              g.d();
              b1 = 2;
              break;
          } 
          switch (Xsnk.n[simpleFormatter$Type.ordinal()]) {
            case 1:
              if (n(arrayOfChar, b))
                simpleFormatter$Type = SimpleFormatter$Type.a; 
            case 2:
              switch (c) {
                case '{':
                  simpleFormatter$Type = (simpleFormatter$Type == SimpleFormatter$Type.a) ? SimpleFormatter$Type.n : SimpleFormatter$Type.b;
                  g.b();
                  g.n();
                  b1 = 1;
                  break;
                case ',':
                  b1 = 1;
                  break;
                case ';':
                  simpleFormatter$Type = SimpleFormatter$Type.n;
                  b1 = 1;
                  break;
              } 
              break;
            case 3:
              switch (c) {
                case ':':
                  simpleFormatter$Type = SimpleFormatter$Type.c;
                  bool = true;
                  break;
                case ';':
                  b1 = 1;
                  break;
              } 
              break;
            case 4:
              switch (c) {
                case ';':
                  simpleFormatter$Type = SimpleFormatter$Type.b;
                  b1 = 1;
                  break;
              } 
              break;
          } 
          break;
        case 3:
          if (c == '/') {
            simpleFormatter$State = SimpleFormatter$State.n;
            break;
          } 
          simpleFormatter$State = SimpleFormatter$State.b;
        case 4:
          if (c == '*') {
            simpleFormatter$State = SimpleFormatter$State.c;
            break;
          } 
          if (c == '\\')
            simpleFormatter$State = SimpleFormatter$State.f; 
          break;
        case 5:
          simpleFormatter$State = SimpleFormatter$State.n;
          break;
        case 6:
          if (c == '\\') {
            simpleFormatter$State = SimpleFormatter$State.f;
            break;
          } 
          if (c == '\'' || n(c))
            simpleFormatter$State = SimpleFormatter$State.n; 
          break;
        case 7:
          if (c == '\\') {
            simpleFormatter$State = SimpleFormatter$State.f;
            break;
          } 
          if (c == '"' || n(c))
            simpleFormatter$State = SimpleFormatter$State.n; 
          break;
      } 
      if (simpleFormatter$State == SimpleFormatter$State.b) {
        g.n(c);
      } else {
        g.a(c);
      } 
      switch (b1) {
        case 1:
          g.d();
          break;
        case 2:
          g.e();
          break;
      } 
      if (bool)
        g.c(); 
    } 
    return g.toString();
  }
  
  private static boolean n(char[] paramArrayOfchar, int paramInt) {
    return (paramArrayOfchar[paramInt] != '@') ? false : ((paramInt > 0 && !Character.isWhitespace(paramArrayOfchar[paramInt - 1]) && paramArrayOfchar[paramInt - 1] != '}') ? false : (!(paramArrayOfchar.length < paramInt + 6 || !(new String(paramArrayOfchar, paramInt, 6)).equalsIgnoreCase("@media"))));
  }
  
  private static boolean n(char paramChar) {
    return (paramChar == '\n' || paramChar == '\r');
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\css\SimpleFormatter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */