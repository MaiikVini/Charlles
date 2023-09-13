package com.xk72.util.lexar;

import de.sciss.syntaxpane.Token;
import de.sciss.syntaxpane.TokenType;
import de.sciss.syntaxpane.lexers.DefaultJFlexLexer;
import java.io.IOException;
import java.io.Reader;

public final class Xsnk extends DefaultJFlexLexer {
  public static final int n = -1;
  
  private static final int c = 16384;
  
  public static final int a = 0;
  
  public static final int b = 2;
  
  private static final int[] d = new int[] { 0, 0, 1, 1 };
  
  private static final String e = "\t\000\001\007\001\005\001\000\001\007\001\005\022\000\001 \001\036\001\003\002\000\001!\001\000\001\004\002\000\001\002\001\000\001\007\001\b\001\n\001\001\n\t\001\037\001\007\004\000\001\035\001\013\001\006\001\f\001\r\001\016\001\006\001\017\001\020\001\021\001\006\001\022\001\006\001\023\001\024\001\025\001\026\001\006\001\027\001\030\001\031\001\032\002\006\001\033\001\006\001\034\004\000\001\006\001\000\001\013\001\006\001\f\001\r\001\016\001\006\001\017\001\020\001\021\001\006\001\022\001\006\001\023\001\024\001\025\001\026\001\006\001\027\001\030\001\031\001\032\002\006\001\033\001\006\001\034\001\007\001\000\001\007￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000ﾒ\000";
  
  private static final char[] f = n("\t\000\001\007\001\005\001\000\001\007\001\005\022\000\001 \001\036\001\003\002\000\001!\001\000\001\004\002\000\001\002\001\000\001\007\001\b\001\n\001\001\n\t\001\037\001\007\004\000\001\035\001\013\001\006\001\f\001\r\001\016\001\006\001\017\001\020\001\021\001\006\001\022\001\006\001\023\001\024\001\025\001\026\001\006\001\027\001\030\001\031\001\032\002\006\001\033\001\006\001\034\004\000\001\006\001\000\001\013\001\006\001\f\001\r\001\016\001\006\001\017\001\020\001\021\001\006\001\022\001\006\001\023\001\024\001\025\001\026\001\006\001\027\001\030\001\031\001\032\002\006\001\033\001\006\001\034\001\007\001\000\001\007￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000￿\000ﾒ\000");
  
  private static final int[] g = b();
  
  private static final String h = "\002\000\006\001\001\002\003\001\001\003\001\000\001\004\002\000\001\005\007\000\001\006\n\000\002\005\001\000\001\007\001\000\001\b\t\000\001\002";
  
  private static final int[] i = c();
  
  private static final String j = "\000\000\000\"\000D\000f\000\000ª\000Ì\000î\000Đ\000Ĳ\000Ŕ\000Ŷ\000D\000\000D\000ª\000Ƙ\000ƺ\000ǜ\000Ǿ\000î\000Ƞ\000ɂ\000Ŕ\000ɤ\000D\000ʆ\000ʨ\000ˊ\000ˬ\000̎\000̰\000͒\000ʹ\000Ζ\000θ\000D\000Ϛ\000ϼ\000D\000О\000D\000р\000Ѣ\000҄\000Ҧ\000ӈ\000Ӫ\000Ԍ\000Ԯ\000Ր\000D";
  
  private static final int[] k = d();
  
  private static final String l = "\001\003\001\004\001\003\001\005\001\006\001\007\001\b\001\007\002\b\001\003\022\b\001\t\001\n\002\007\001\003\002\013\001\f\037\013$\000\001\r\037\000\003\016\001\017\001\016\001\000\034\016\004\020\001\017\001\000\034\020\b\000\001\021\001\022\001\023\001\024\034\000\001\025\001\000\002\025\001\000\022\025\002\000\001\026\b\000\001\t\001\000\002\t\001\000\022\t\026\000\001\027\020\000\002\030\001\031 \030\001\032\001\031\037\030\t\000\001\022\001\023 \000\001\022\001\023\001\000\001\033\001\034\001\035\001\036\001\037\001 \001!\001\"\002\000\001#\001$\001%\b\000\001%\t\000\001&2\000\001''\000\001(\024\000\001)\016\000\001\030\001*\001\031\037\030\023\000\001%\034\000\001+&\000\001%\007\000\001%\035\000\001$&\000\001%\031\000\001%\035\000\001\037$\000\001%\004\000\001%\025\000\001%\f\000\001%\001\000\001%\021\000\001,\037\000\001&\002\000\001\033\001\034\001\035\001\036\001\037\001 \001!\001\"\002\000\001#\001$\001%\b\000\001%\031\000\001-\036\000\001.\032\000\001%\037\000\001%)\000\001%!\000\001/#\000\0010#\000\0011\023\000\0012*\000\0013&\000\0014\b\000";
  
  private static final int m = 0;
  
  private static final int o = 1;
  
  private static final int p = 2;
  
  private static final String[] q = new String[] { "Unknown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
  
  private static final int[] r = e();
  
  private static final String s = "\002\000\001\t\t\001\001\t\001\000\001\t\002\000\001\001\007\000\001\t\n\000\001\t\001\001\001\000\001\t\001\000\001\t\t\000\001\t";
  
  private Reader t;
  
  private int u;
  
  private int v = 0;
  
  private char[] w = new char[16384];
  
  private int x;
  
  private int y;
  
  private int z;
  
  private int A;
  
  private int B;
  
  private int C;
  
  private int D;
  
  private boolean E = true;
  
  private boolean F;
  
  private boolean G;
  
  private int H = 0;
  
  private static final byte I = 1;
  
  private static final byte J = -1;
  
  private static int[] b() {
    int[] arrayOfInt = new int[52];
    int i = 0;
    i = n("\002\000\006\001\001\002\003\001\001\003\001\000\001\004\002\000\001\005\007\000\001\006\n\000\002\005\001\000\001\007\001\000\001\b\t\000\001\002", i, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int n(String paramString, int paramInt, int[] paramArrayOfint) {
    byte b = 0;
    int i = paramInt;
    int j = paramString.length();
    label10: while (b < j) {
      char c1 = paramString.charAt(b++);
      char c2 = paramString.charAt(b++);
      while (true) {
        paramArrayOfint[i++] = c2;
        if (--c1 <= '\000')
          continue label10; 
      } 
    } 
    return i;
  }
  
  private static int[] c() {
    int[] arrayOfInt = new int[52];
    int i = 0;
    i = a("\000\000\000\"\000D\000f\000\000ª\000Ì\000î\000Đ\000Ĳ\000Ŕ\000Ŷ\000D\000\000D\000ª\000Ƙ\000ƺ\000ǜ\000Ǿ\000î\000Ƞ\000ɂ\000Ŕ\000ɤ\000D\000ʆ\000ʨ\000ˊ\000ˬ\000̎\000̰\000͒\000ʹ\000Ζ\000θ\000D\000Ϛ\000ϼ\000D\000О\000D\000р\000Ѣ\000҄\000Ҧ\000ӈ\000Ӫ\000Ԍ\000Ԯ\000Ր\000D", i, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int a(String paramString, int paramInt, int[] paramArrayOfint) {
    byte b = 0;
    int i = paramInt;
    int j = paramString.length();
    while (b < j) {
      int k = paramString.charAt(b++) << 16;
      paramArrayOfint[i++] = k | paramString.charAt(b++);
    } 
    return i;
  }
  
  private static int[] d() {
    int[] arrayOfInt = new int[1394];
    int i = 0;
    i = b("\001\003\001\004\001\003\001\005\001\006\001\007\001\b\001\007\002\b\001\003\022\b\001\t\001\n\002\007\001\003\002\013\001\f\037\013$\000\001\r\037\000\003\016\001\017\001\016\001\000\034\016\004\020\001\017\001\000\034\020\b\000\001\021\001\022\001\023\001\024\034\000\001\025\001\000\002\025\001\000\022\025\002\000\001\026\b\000\001\t\001\000\002\t\001\000\022\t\026\000\001\027\020\000\002\030\001\031 \030\001\032\001\031\037\030\t\000\001\022\001\023 \000\001\022\001\023\001\000\001\033\001\034\001\035\001\036\001\037\001 \001!\001\"\002\000\001#\001$\001%\b\000\001%\t\000\001&2\000\001''\000\001(\024\000\001)\016\000\001\030\001*\001\031\037\030\023\000\001%\034\000\001+&\000\001%\007\000\001%\035\000\001$&\000\001%\031\000\001%\035\000\001\037$\000\001%\004\000\001%\025\000\001%\f\000\001%\001\000\001%\021\000\001,\037\000\001&\002\000\001\033\001\034\001\035\001\036\001\037\001 \001!\001\"\002\000\001#\001$\001%\b\000\001%\031\000\001-\036\000\001.\032\000\001%\037\000\001%)\000\001%!\000\001/#\000\0010#\000\0011\023\000\0012*\000\0013&\000\0014\b\000", i, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int b(String paramString, int paramInt, int[] paramArrayOfint) {
    byte b = 0;
    int i = paramInt;
    int j = paramString.length();
    label10: while (b < j) {
      char c1 = paramString.charAt(b++);
      char c2 = paramString.charAt(b++);
      c2--;
      while (true) {
        paramArrayOfint[i++] = c2;
        if (--c1 <= '\000')
          continue label10; 
      } 
    } 
    return i;
  }
  
  private static int[] e() {
    int[] arrayOfInt = new int[52];
    int i = 0;
    i = c("\002\000\001\t\t\001\001\t\001\000\001\t\002\000\001\001\007\000\001\t\n\000\001\t\001\001\001\000\001\t\001\000\001\t\t\000\001\t", i, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int c(String paramString, int paramInt, int[] paramArrayOfint) {
    byte b = 0;
    int i = paramInt;
    int j = paramString.length();
    label10: while (b < j) {
      char c1 = paramString.charAt(b++);
      char c2 = paramString.charAt(b++);
      while (true) {
        paramArrayOfint[i++] = c2;
        if (--c1 <= '\000')
          continue label10; 
      } 
    } 
    return i;
  }
  
  public Xsnk() {}
  
  public int yychar() {
    return this.C;
  }
  
  public Xsnk(Reader paramReader) {
    this.t = paramReader;
  }
  
  private static char[] n(String paramString) {
    char[] arrayOfChar = new char[1114112];
    byte b1 = 0;
    byte b2 = 0;
    label10: while (b1 < 'Æ') {
      char c1 = paramString.charAt(b1++);
      char c2 = paramString.charAt(b1++);
      while (true) {
        arrayOfChar[b2++] = c2;
        if (--c1 <= '\000')
          continue label10; 
      } 
    } 
    return arrayOfChar;
  }
  
  private boolean f() {
    if (this.z > 0) {
      this.A += this.H;
      this.H = 0;
      System.arraycopy(this.w, this.z, this.w, 0, this.A - this.z);
      this.A -= this.z;
      this.y -= this.z;
      this.x -= this.z;
      this.z = 0;
    } 
    if (this.y >= this.w.length - this.H) {
      char[] arrayOfChar = new char[this.w.length * 2];
      System.arraycopy(this.w, 0, arrayOfChar, 0, this.w.length);
      this.w = arrayOfChar;
      this.A += this.H;
      this.H = 0;
    } 
    int i = this.w.length - this.A;
    int j = this.t.read(this.w, this.A, i);
    if (j == 0)
      throw new IOException("Reader returned 0 characters. See JFlex examples for workaround."); 
    if (j > 0) {
      this.A += j;
      if (j == i && Character.isHighSurrogate(this.w[this.A - 1])) {
        this.A--;
        this.H = 1;
      } 
      return false;
    } 
    return true;
  }
  
  public final void n() {
    this.F = true;
    this.A = this.z;
    if (this.t != null)
      this.t.close(); 
  }
  
  public final void yyreset(Reader paramReader) {
    this.t = paramReader;
    this.E = true;
    this.F = false;
    this.G = false;
    this.A = this.z = 0;
    this.y = this.x = 0;
    this.H = 0;
    this.B = this.C = this.D = 0;
    this.v = 0;
    if (this.w.length > 16384)
      this.w = new char[16384]; 
  }
  
  public final int a() {
    return this.v;
  }
  
  public final void n(int paramInt) {
    this.v = paramInt;
  }
  
  public final String yytext() {
    return new String(this.w, this.z, this.x - this.z);
  }
  
  public final char yycharat(int paramInt) {
    return this.w[this.z + paramInt];
  }
  
  public final int yylength() {
    return this.x - this.z;
  }
  
  private void b(int paramInt) {
    String str;
    try {
      str = q[paramInt];
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      str = q[0];
    } 
    throw new Error(str);
  }
  
  public void a(int paramInt) {
    if (paramInt > yylength())
      b(2); 
    this.x -= paramInt;
  }
  
  public Token yylex() {
    int i = this.A;
    char[] arrayOfChar1 = this.w;
    char[] arrayOfChar2 = f;
    int[] arrayOfInt1 = k;
    int[] arrayOfInt2 = i;
    int[] arrayOfInt3 = r;
    while (true) {
      int j;
      int n = this.x;
      this.C += n - this.z;
      int k = -1;
      int m = this.y = this.z = n;
      this.u = d[this.v];
      int i1 = arrayOfInt3[this.u];
      if ((i1 & 0x1) == 1)
        k = this.u; 
      while (true) {
        if (m < i) {
          j = Character.codePointAt(arrayOfChar1, m, i);
          m += Character.charCount(j);
        } else {
          if (this.F) {
            byte b = -1;
            break;
          } 
          this.y = m;
          this.x = n;
          boolean bool = f();
          m = this.y;
          n = this.x;
          arrayOfChar1 = this.w;
          i = this.A;
          if (bool) {
            byte b = -1;
            break;
          } 
          j = Character.codePointAt(arrayOfChar1, m, i);
          m += Character.charCount(j);
        } 
        int i2 = arrayOfInt1[arrayOfInt2[this.u] + arrayOfChar2[j]];
        if (i2 == -1)
          break; 
        this.u = i2;
        i1 = arrayOfInt3[this.u];
        if ((i1 & 0x1) == 1) {
          k = this.u;
          n = m;
          if ((i1 & 0x8) == 8)
            break; 
        } 
      } 
      this.x = n;
      if (j == -1 && this.z == this.y) {
        this.F = true;
        switch (this.v) {
          case 0:
            return null;
          case 53:
            continue;
          case 2:
            return null;
          case 54:
            continue;
        } 
        return null;
      } 
      switch ((k < 0) ? k : g[k]) {
        case 1:
        case 9:
          continue;
        case 2:
          return token(TokenType.KEYWORD);
        case 10:
          continue;
        case 3:
          n(2);
          return token(TokenType.COMMENT2, 1);
        case 11:
          continue;
        case 4:
          return token(TokenType.STRING);
        case 12:
          continue;
        case 5:
          return token(TokenType.NUMBER);
        case 13:
          continue;
        case 6:
          n(0);
          return token(TokenType.COMMENT2, -1);
        case 14:
          continue;
        case 7:
          a(1);
          return token(TokenType.TYPE);
        case 15:
          continue;
        case 8:
          a(2);
          return token(TokenType.COMMENT);
        case 16:
          continue;
      } 
      b(1);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\lexar\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */