package algorithm.node;

/** 作者：王文彬 on 2019/10/23 10：33 邮箱：wwb199055@126.com */
public class NodeTest02 {

  public Node reverseByRecursion(Node head) {
    if (head == null) return head;
    Node newHead = reverseByRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  public Node reverseByLoop(Node head) {
    if (head == null) return head;
    Node pre = null;
    Node next = null;
    while (head != null) {
      next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }
}
