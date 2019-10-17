package algorithm.tree;

/** 作者：王文彬 on 2019/10/17 11：53 邮箱：wwb199055@126.com */
public class TreeDemo {

  public void infixOrder(TreeNode current) {
    if (current != null) {
      infixOrder(current.left);
      System.out.print(current.value + " ");
      infixOrder(current.left);
    }
  }

  public void preOrder(TreeNode current) {
    if (current != null) {
      System.out.print(current.value + " ");
      preOrder(current.left);
      preOrder(current.right);
    }
  }

  public void postOrder(TreeNode current) {
    if (current != null) {
      postOrder(current.left);
      postOrder(current.right);
      System.out.print(current.value + " ");
    }
  }


}
