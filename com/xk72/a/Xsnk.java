package com.xk72.a;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Xsnk<K, V> implements c<K, V> {
  private final ReentrantLock n = new ReentrantLock();
  
  private final Map<K, V> a = new ConcurrentHashMap<>();
  
  private final Deque<K> b = new LinkedList<>();
  
  private final int c;
  
  public Xsnk(int paramInt) {
    this.c = paramInt;
  }
  
  public void n(K paramK, V paramV) {
    V v = this.a.put(paramK, paramV);
    if (v != null) {
      e(paramK);
    } else {
      d(paramK);
    } 
    if (this.a.size() > this.c)
      this.a.remove(c()); 
  }
  
  public boolean n(Object paramObject) {
    return this.a.containsKey(paramObject);
  }
  
  public V a(Object paramObject) {
    V v = this.a.get(paramObject);
    if (v != null)
      e((K)paramObject); 
    return v;
  }
  
  private void d(K paramK) {
    this.n.lock();
    try {
      this.b.addFirst(paramK);
    } finally {
      this.n.unlock();
    } 
  }
  
  private K c() {
    this.n.lock();
    try {
      K k = this.b.removeLast();
      return k;
    } finally {
      this.n.unlock();
    } 
  }
  
  private void e(K paramK) {
    this.n.lock();
    try {
      this.b.removeFirstOccurrence(paramK);
      this.b.addFirst(paramK);
    } finally {
      this.n.unlock();
    } 
  }
  
  private void f(K paramK) {
    this.n.lock();
    try {
      this.b.removeFirstOccurrence(paramK);
    } finally {
      this.n.unlock();
    } 
  }
  
  public V b(K paramK) {
    return this.a.get(paramK);
  }
  
  public V c(Object paramObject) {
    f((K)paramObject);
    return this.a.remove(paramObject);
  }
  
  public int n() {
    return this.a.size();
  }
  
  public void a() {
    this.n.lock();
    try {
      this.a.clear();
      this.b.clear();
    } finally {
      this.n.unlock();
    } 
  }
  
  public String toString() {
    return this.a.toString();
  }
  
  public Set<K> b() {
    return this.a.keySet();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\a\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */