package algorithm.node;

/** 作者：王文彬 on 2019/10/7 10：14 邮箱：wwb199055@126.com */
public class NodeTest01 {

  public void printNode(Node head) {
    if (head != null) {
      System.out.println(head.value);
      head = head.next;
    }
  }

  public boolean isCycle(Node head) {
    Node slow = head;
    Node fast = head;
    while (slow.next != null && slow.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  public Node getMid(Node head) {
    Node slow = head;
    Node fast = head;
    while (slow.next != null && slow.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

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

  public Node mergeSort(Node head) {
    if (head == null || head.next == null) return head;
    Node mid = getMid(head);
    mid.next = null;
    Node front = mergeSort(head);
    Node after = mergeSort(mid);
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

  // 删除倒数第K个节点
  public Node removeLastKthNode(Node head, int k) {
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

  // 删除a/b处的节点
  public Node removeByRatio(Node head, int a, int b) {
    if (head == null || a < 1 || a > b) return head;
    Node current = head;
    int n = 0;
    while (current != null) {
      n++;
      current = current.next;
    }

    // 取（a*n）/b  向上取整
    n = (int) Math.ceil((double) (a * n) / b);

    if (n == 1) {
      return head.next;
    }

    if (n > 1) {
      current = head;
      while (--n != 1) {
        current = current.next;
      }
      current.next = current.next.next;
    }
    return head;
  }

  // 链表从form到to的位置反转
  public Node reversePart(Node head, int from, int to) {
    if (head == null) return head;
    int n = 0;
    Node tNext = null;
    Node fPre = null;
    Node cur = head;
    while (cur != null) {
      n++;
      if (n == from - 1) fPre = cur;
      if (n == to + 1) tNext = cur;
      cur = cur.next;
    }
    if (from > to || from < 1 || to > n) return head;
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
