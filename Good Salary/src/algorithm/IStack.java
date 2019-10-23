package algorithm;

/** 作者：王文彬 on 2019/10/21 15：58 邮箱：wwb199055@126.com */
public interface IStack<E> {

  /** 元素入栈 */
  E push(E value);

  /** 元素弹栈 */
  E pop() throws InterruptedException;

  /** 判断栈是否为空 */
  boolean isEmpty();

  /** 获取栈顶元素 */
  E peek() throws InterruptedException;
}
