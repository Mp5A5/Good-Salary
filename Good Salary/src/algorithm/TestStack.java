package algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/** 作者：王文彬 on 2019/10/21 16：13 邮箱：wwb199055@126.com */
public class TestStack {

  @Test
  public void test() {
    TestStack testStack = new TestStack();
    System.out.println(testStack.isStack());
  }

  private boolean isStack() {

    MyStack<Character> stack = new MyStack<>();

    String str = "123 456 789";

    char[] chars = str.toCharArray();
    for (char c : chars) {
      stack.push(c);
    }

    List<Character> mList = new ArrayList<>();
    while (!stack.isEmpty()) {
      mList.add(stack.pop());
    }

    if (!mList.isEmpty()) {
      int index = 0;
      while (index < mList.size()) {
        if (chars[mList.size() - index - 1] != mList.get(index)) {
          System.out.println("This is not Stack");
          return false;
        }
        index++;
      }
    }
    System.out.println("This is Stack");
    return true;
  }
}
