package reflect;

/** 作者：王文彬 on 2019-05-22 11：36 邮箱：wwb199055@126.com */
public class Cat {

  static {
    System.out.println("执行了静态代码块");
  }

  public static final String TAG = Cat.class.getSimpleName();

  private String name;

  @Deprecated public int age;

  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void eat(String food) {
    System.out.println("eat food " + food);
  }

  private void eat(String... foods) {
    StringBuilder s = new StringBuilder();
    for (String food : foods) {
      s.append(food);
      s.append(" ");
    }
    System.out.println("eat food " + s.toString());
  }

  public void sleep() {
    System.out.println("sleep");
  }

  @Override
  public String toString() {
    return "name = " + name + " age = " + age;
  }
}
