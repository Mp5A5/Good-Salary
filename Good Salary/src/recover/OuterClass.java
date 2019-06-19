package recover;

/** 作者：王文彬 on 2019-05-14 13：42 邮箱：wwb199055@126.com */
public class OuterClass {

  interface Print {
    void print();
  }

  public class InnerClass {

    public void test(final String name) {
      Print print =
          new Print() {
            @Override
            public void print() {
              System.out.println(name);
            }
          };

      print.print();
    }

    public void test1(final String str) {

      new OuterClass() {

        public void print() {
          System.out.println(str);
        }
      }.print();
    }
  }

  public void main() {
    InnerClass innerClass = new InnerClass();
    innerClass.test("w");
    innerClass.test1("p");
  }
}
