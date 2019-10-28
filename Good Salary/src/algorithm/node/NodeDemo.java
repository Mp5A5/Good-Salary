package algorithm.node;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019/9/3 07：48 邮箱：wwb199055@126.com */
public class NodeDemo {

  @Test
  public void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(4);
    Node node3 = new Node(2);
    Node node4 = new Node(5);
    Node node5 = new Node(1);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = null;
    printNode(reverseByRecursion(node1));
  }

  public static void printNode(Node head) {
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
    Node fast = head; // 快指针
    Node slow = head; // 慢指针
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
    return /*merge(front, after)*/ mergeTwo(front, after);
  }

  private Node merge(Node front, Node after) {
    Node hHead = new Node(-1);
    Node current = hHead;
    while (front != null || after != null) {
      if (front == null) {
        current.next = after;
        break; // 关键点，不然无限递归
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
      current = current.next;
    }
    return hHead.next;
  }

  public Node mergeTwo(Node front, Node after) {
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

  public Node removeByRatio(Node head, int a, int b) {
    if (head == null || a < 1 || a > b) return head;
    int n = 0;
    Node current = head;
    while (current != null) {
      n++;
      current = current.next;
    }
    // 去（a*n）/b  向上取整
    n = (int) Math.ceil((double) (a * n) / b);
    if (n == 1) head = head.next;
    if (n > 1) {
      current = head;
      while (--n != 1) {
        current = current.next;
      }
      current.next = current.next.next;
    }
    return head;
  }

  public Node reversePart(Node head, int from, int to) {
    int len = 0;
    Node tNext = null;
    Node fPre = null;
    Node cur = head;
    while (cur != null) {
      len++;
      if (len == from - 1) fPre = cur;
      if (len == to + 1) tNext = cur;
      cur = cur.next;
    }

    if (from > to || from < 1 || to > len) return head;

    cur = fPre == null ? head : fPre.next;
    Node prev = tNext;
    Node next = null;
    while (cur != tNext) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    // 头结点不用反转的情况，将不用反转的链表和已经反转好的链表进行连接
    if (fPre != null) {
      fPre.next = prev;
      return head;
    }
    // 头结点需要反转的情况，返回新的头结点
    return prev;
  }

  // 每k个一组翻转链表
  public Node reverseKGroup(Node head, int k) {
    if (head == null || head.next == null) return head;
    Node temp = head;
    for (int i = 1; i < k && temp != null; i++) {
      temp = temp.next;
    }
    if (temp == null) return head;

    Node next = temp.next;
    temp.next = null;
    // 把当前的组进行逆序
    Node newNode = reverseByRecursion(head);
    // 把之后的节点进行分组逆序
    head.next = reverseKGroup(next, k);
    return newNode;
  }

  public Node reverseEndOrder(Node head, int k) {
    // 调用逆序函数
    head = reverseByLoop(head);
    // 调用每 k 个为一组的逆序函数（从头部开始组起）
    head = reverseKGroup(head, k);
    // 在逆序一次
    head = reverseByLoop(head);

    return head;
  }
}
