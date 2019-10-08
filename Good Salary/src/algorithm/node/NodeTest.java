package algorithm.node;

/** 作者：王文彬 on 2019/9/27 07：28 邮箱：wwb199055@126.com */
public class NodeTest {

  public void printNode(Node head) {
    while (head != null) {
      System.out.println(head.value);
      head = head.next;
    }
  }

  public Node reversByRecursion(Node head) {
    if (head.next == null) return head;
    Node newHead = reversByRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  public Node reverseByLoop(Node head) {
    if (head.next == null) return head;
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

  public boolean isCircle(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }

  public Node getMid(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public Node mergeSort(Node head) {
    if (head == null || head.next == null) return head;
    Node mid = getMid(head);
    Node next = mid.next;
    mid.next = null;
    Node front = mergeSort(head);
    Node after = mergeSort(next);
    return mergeTwo(front, after);
  }

  private Node mergeTwo(Node front, Node after) {
    if (front == null) return after;
    if (after == null) return front;
    Node head = null;
    if (front.value <= after.value) {
      head = front;
      head.next = mergeTwo(front.next, after);
    } else {
      head = after;
      head.next = mergeTwo(front, after.next);
    }
    return head;
  }
}
