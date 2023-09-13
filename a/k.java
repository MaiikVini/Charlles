package com.xk72.a;

public class k<K, V> {
  private static long n = 60000L;
  
  private long a;
  
  private Thread b;
  
  private n<K, V> c;
  
  public k(n<K, V> paramn) {
    this.c = paramn;
    n();
  }
  
  public void n() {
    this.a = System.currentTimeMillis() + Math.max(this.c.c() * 2L, n);
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/xk72/a/n;
    //   4: invokeinterface b : ()Ljava/util/Set;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface iterator : ()Ljava/util/Iterator;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 64
    //   26: aload_2
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: astore_3
    //   33: aload_0
    //   34: getfield c : Lcom/xk72/a/n;
    //   37: aload_3
    //   38: invokeinterface a : (Ljava/lang/Object;)Ljava/lang/Object;
    //   43: astore #4
    //   45: aload #4
    //   47: ifnonnull -> 61
    //   50: aload_0
    //   51: getfield c : Lcom/xk72/a/n;
    //   54: aload_3
    //   55: invokeinterface c : (Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: goto -> 17
    //   64: return
  }
  
  private synchronized void c() {
    if (this.b == null) {
      this.b = new l(this, getClass().getName() + " maintenance");
      this.b.setPriority(1);
      this.b.start();
    } 
  }
  
  public void a() {
    long l = System.currentTimeMillis();
    if (l > this.a)
      synchronized (this) {
        if (l > this.a) {
          n();
          c();
        } 
      }  
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\k.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */