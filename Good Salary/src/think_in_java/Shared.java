package think_in_java;

/** 作者：王文彬 on 2019-06-27 07：46 邮箱：wwb199055@126.com */
public class Shared {

  private int refcount = 0;
  private static long counter = 0;
  private final long id = counter++;

  public Shared() {
    System.out.println("Create" + this);
  }

  public void addRef() {
    refcount++;
  }

  protected void dispose() {
    if (--refcount == 0) {
      System.out.println("Dispose" + this);
    }
  }

  @Override
  public String toString() {
    return "Shared" + id;
  }
}

class Composing {

  private Shared shared;

  private static long counter = 0;

  private final long id = counter++;

  public Composing(Shared shared) {
    System.out.println("Create"+this);
    this.shared = shared;
    this.shared.addRef();
  }

  protected void dispose() {
    System.out.println("dispose" + this);
    shared.dispose();
  }

  @Override
  public String toString() {
    return "Composing" + id;
  }
}
