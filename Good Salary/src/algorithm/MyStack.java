package algorithm;

import java.util.Arrays;
import java.util.EmptyStackException;

/** 作者：王文彬 on 2019/10/21 16：02 邮箱：wwb199055@126.com */
public class MyStack<E> implements IStack<E> {

  private Object[] elementData;

  private int top;

  private int size;

  public MyStack() {
    this(10);
  }

  public MyStack(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("栈初始容量不能小于0: " + initialCapacity);
    }
    elementData = new Object[initialCapacity];
    this.top = -1;
    this.size = initialCapacity;
  }

  @Override
  public E push(E value) {
    addValue(value);
    return value;
  }

  private synchronized void addValue(E value) {
    isGrow(top + 1);
    elementData[++top] = value;
  }

  private boolean isGrow(int minCapacity) {

    int oldCapacity = size;
    if (minCapacity >= oldCapacity) {
      // 定义扩大之后栈的总容量
      int newCapacity = 0;
      // 栈容量扩大两倍看是否超过int类型所表示的最大范围
      if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
        newCapacity = Integer.MAX_VALUE;
      } else {
        newCapacity = (oldCapacity << 1);
      }
      this.size = newCapacity;
      elementData = Arrays.copyOf(elementData, size);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public E pop() {
    E obj = peek();
    remove(top);
    return obj;
  }

  private synchronized void remove(int top) {
    elementData[top] = null;
    this.top--;
  }

  @Override
  public boolean isEmpty() {
    return top == -1;
  }

  @Override
  public synchronized E peek() {
    if (top == -1) {
      throw new EmptyStackException();
    }
    return (E) elementData[top];
  }
}
