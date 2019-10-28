package algorithm.node;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019/10/23 10：33 邮箱：wwb199055@126.com */
public class NodeTest02 {

  @Test
  public void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(4);
    Node node3 = new Node(2);
    Node node4 = new Node(5);
    Node node5 = new Node(1);
    Node node6 = new Node(6);
    Node node7 = new Node(10);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    printNode(removeMidNode(node1));
    //    System.out.println(getMidNode(node1).value);
  }

  public void printNode(Node head) {
    while (head != null) {
      System.out.println(head.value);
      head = head.next;
    }
  }

  public Node reverseByRecursion(Node head) {
    if (head.next == null) return head;
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

  public Node getMidNode(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public boolean isCycle(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }

  public Node mergeSort(Node head) {
    if (head == null || head.next == null) return head;
    Node mid = getMidNode(head);
    Node next = mid.next;
    mid.next = null;
    Node front = mergeSort(head);
    Node after = mergeSort(next);
    return merge(front, after);
  }

  private Node merge(Node front, Node after) {
    if (front == null) return after;
    if (after == null) return front;
    Node head = null;
    if (front.value <= after.value) {
      head = front;
      head.next = merge(front.next, after);
    } else {
      head = after;
      head.next = merge(front, after.next);
    }
    return head;
  }

  private Node mergeTwo(Node front, Node after) {
    Node hHead = new Node(-1);
    Node current = hHead;
    while (front != null || after != null) {
      if (front == null) {
        current.next = after;
        break;
      } else if (after == null) {
        current.next = front;
        break;
      } else if (front.value <= after.value) {
        current.next = front;
        front = front.next;
      } else {
        current.next = after;
        after = after.next;
      }
    }
    return hHead.next;
  }

  public Node removeMidNode(Node head) {
    if (head == null || head.next == null) return head;
    if (head.next.next == null) return head.next;
    Node fast = head.next.next;
    Node slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }

  public Node removeLastKNode(Node head, int k) {
    if (head == null || k < 1) return head;
    Node current = head;
    int num = 0;
    while (current != null) {
      num++;
      current = current.next;
    }
    if (num == k) {
      return head.next;
    }

    if (num > k) {
      current = head;
      // 删除第(num-k+1)个节点
      // 定位到这个点的前驱
      while (num - k != 0) {
        current = current.next;
        num--;
      }
      current.next = current.next.next;
    }
    return head;
  }

  public Node removeByRation(Node head, int a, int b) {
    if (head == null || a < 1 || a > b) return head;
    Node current = head;
    int num = 0;
    while (current != null) {
      num++;
      current = current.next;
    }

    int index = (int) Math.ceil((double) (a * num) / b);

    if (index == 1) return head.next;

    if (index > 1) {
      current = head;
      while (--index != 1) {
        current = current.next;
      }
      current.next = current.next.next;
    }
    return head;
  }

  public Node reversePart(Node head, int from, int to) {
    if (head == null) return head;
    int num = 0;
    Node tNext = null;
    Node fPre = null;
    Node cur = head;
    while (cur != null) {
      num++;
      if (num == from - 1) fPre = cur;
      if (num == to + 1) tNext = cur;
      cur = cur.next;
    }
    if (from > to || from < 1 || to > num) return head;
    cur = fPre == null ? head : fPre.next;
    Node pre = tNext;
    Node next = null;
    while (cur != tNext) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }

    // 头结点不用反转的情况，将不用反转的链表和已经反转好的链表进行连接
    if (fPre != null) {
      fPre.next = pre;
      return head;
    }
    return pre;
  }

  // 分组逆序
  public Node reverseKGroup(Node head, int k) {
    if (head == null || head.next == null) return head;
    Node temp = head;
    for (int i = 1; i < k && temp != null; i++) {
      temp = temp.next;
    }
    if (temp == null) return head;
    Node next = temp.next;
    temp.next = null;
    Node newHead = reverseByRecursion(head);
    // 把之后的节点进行分组逆序
    head.next = reverseKGroup(next, k);
    return newHead;
  }

  // 给定一个单链表的头节点 head,实现一个调整单链表的函数，
  // 使得每K个节点之间为一组进行逆序，并且从链表的尾部开始组起，
  // 头部剩余节点数量不够一组的不需要逆序。（不能使用队列或者栈作为辅助）
  public Node reverseEndOrder(Node head, int k) {
    head = reverseByRecursion(head);
    head = reverseKGroup(head, k);
    head = reverseByRecursion(head);
    return head;
  }
}
