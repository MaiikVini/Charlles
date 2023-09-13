package com.xk72.d;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;

public abstract class Xsnk extends FilterInputStream implements G {
  protected DataInput n;
  
  private int a = 0;
  
  private int b = 0;
  
  private final boolean c;
  
  public Xsnk(InputStream paramInputStream) {
    this(paramInputStream, false);
  }
  
  public Xsnk(InputStream paramInputStream, boolean paramBoolean) {
    super(paramInputStream);
    if (paramInputStream instanceof DataInput) {
      this.n = (DataInput)paramInputStream;
    } else {
      this.n = new DataInputStream(paramInputStream);
    } 
    this.c = paramBoolean;
  }
  
  protected Xsnk(DataInput paramDataInput) {
    this(paramDataInput, false);
  }
  
  protected Xsnk(DataInput paramDataInput, boolean paramBoolean) {
    super(null);
    this.n = paramDataInput;
    this.c = paramBoolean;
  }
  
  public void n() {
    this.a = 0;
    this.b = 0;
  }
  
  public abstract int read();
  
  public void n(int paramInt) {
    n();
    this.n.skipBytes(paramInt);
  }
  
  public abstract int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public int readInt() {
    n();
    return this.c ? e(this.n.readInt()) : this.n.readInt();
  }
  
  public short readShort() {
    n();
    return this.c ? f(this.n.readShort()) : this.n.readShort();
  }
  
  public int readUnsignedShort() {
    n();
    return this.c ? g(this.n.readUnsignedShort()) : this.n.readUnsignedShort();
  }
  
  public byte readByte() {
    n();
    return this.n.readByte();
  }
  
  public int readUnsignedByte() {
    n();
    return this.n.readUnsignedByte();
  }
  
  public boolean readBoolean() {
    return (b(1) == 1);
  }
  
  public String a() {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = readUnsignedByte(); i != 0; i = readUnsignedByte())
      stringBuffer.append((char)i); 
    return stringBuffer.toString();
  }
  
  public String b() {
    int i = this.n.readUnsignedByte();
    byte[] arrayOfByte = new byte[i];
    read(arrayOfByte, 0, i);
    return new String(arrayOfByte, 0, i);
  }
  
  public long a(int paramInt) {
    long l = 0L;
    while (true) {
      int i = paramInt - this.b;
      if (i > 0) {
        l |= (this.a << i);
        paramInt -= this.b;
        this.a = read();
        if (this.a == -1)
          throw new EOFException("SwfInputStream: end of file"); 
        this.b = 8;
        continue;
      } 
      l |= (this.a >>> -i);
      this.b -= paramInt;
      this.a &= 255 >> 8 - this.b;
      return l;
    } 
  }
  
  public int b(int paramInt) {
    return (int)a(paramInt);
  }
  
  public long c(int paramInt) {
    long l = b(paramInt);
    if ((l & 1L << paramInt - 1) != 0L)
      l |= -1L << paramInt; 
    return l;
  }
  
  public int d(int paramInt) {
    return (int)c(paramInt);
  }
  
  public abstract void close();
  
  private static int e(int paramInt) {
    return paramInt >>> 24 | paramInt >> 8 & 0xFF00 | paramInt << 8 & 0xFF0000 | paramInt << 24;
  }
  
  private static short f(int paramInt) {
    paramInt = paramInt >>> 8 & 0xFF | paramInt << 8 & 0xFF00;
    if ((paramInt & 0x8000L) != 0L)
      paramInt = (int)(paramInt | 0xFFFFFFFFFFFF0000L); 
    return (short)paramInt;
  }
  
  private static int g(int paramInt) {
    return paramInt >>> 8 & 0xFF | paramInt << 8 & 0xFF00;
  }
  
  public char readChar() {
    n();
    return this.n.readChar();
  }
  
  public double readDouble() {
    n();
    return this.n.readDouble();
  }
  
  public float readFloat() {
    n();
    return this.n.readFloat();
  }
  
  public long readLong() {
    n();
    return this.n.readLong();
  }
  
  public int skipBytes(int paramInt) {
    n();
    return this.n.skipBytes(paramInt);
  }
  
  public void readFully(byte[] paramArrayOfbyte) {
    n();
    this.n.readFully(paramArrayOfbyte);
  }
  
  public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    n();
    this.n.readFully(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public String readLine() {
    n();
    return this.n.readLine();
  }
  
  public String readUTF() {
    n();
    return this.n.readUTF();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\d\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */