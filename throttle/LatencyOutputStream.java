package com.xk72.throttle;

import java.io.IOException;
import java.io.OutputStream;

public class LatencyOutputStream extends OutputStream {
  private static final int n = 3706880;
  
  private final OutputStream a;
  
  private final LatentExecutor<d> b;
  
  private boolean c = false;
  
  public LatencyOutputStream(Xsnk paramXsnk, OutputStream paramOutputStream) {
    this.a = paramOutputStream;
    this.b = new LatentExecutor<>(paramXsnk, () -> new d(this.a), 3706880);
  }
  
  public void write(int paramInt) {
    this.c = false;
    d d = this.b.e();
    if (d == null) {
      this.a.write(paramInt);
    } else {
      d.n(paramInt);
      try {
        this.b.n(d);
      } catch (LatentExecutor$ExecutorCancelledException latentExecutor$ExecutorCancelledException) {
        throw new IOException(latentExecutor$ExecutorCancelledException.getCause());
      } 
    } 
  }
  
  public void write(byte[] paramArrayOfbyte) {
    write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.c = false;
    d d = this.b.e();
    if (d == null) {
      this.a.write(paramArrayOfbyte, paramInt1, paramInt2);
    } else {
      d.n(paramArrayOfbyte, paramInt1, paramInt2);
      try {
        this.b.n(d);
      } catch (LatentExecutor$ExecutorCancelledException latentExecutor$ExecutorCancelledException) {
        throw new IOException(latentExecutor$ExecutorCancelledException.getCause());
      } 
    } 
  }
  
  public void flush() {
    if (this.c)
      return; 
    this.c = true;
    d d = this.b.e();
    if (d == null) {
      this.a.flush();
    } else {
      d.c();
      try {
        this.b.n(d);
      } catch (LatentExecutor$ExecutorCancelledException latentExecutor$ExecutorCancelledException) {
        throw new IOException(latentExecutor$ExecutorCancelledException.getCause());
      } 
    } 
  }
  
  public void close() {
    try {
      this.b.d();
    } catch (InterruptedException interruptedException) {}
    this.b.n();
    this.a.close();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\LatencyOutputStream.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */