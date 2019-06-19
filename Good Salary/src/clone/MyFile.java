package clone;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class MyFile implements Cloneable {

  private String path;

  public Info info;

  public MyFile(String path, Info info) {

    this.path = path;

    this.info = info;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (obj.getClass() != getClass()) return false;
    MyFile temp = (MyFile) obj;
    if (path == null) {
      if (temp.path != null) {
        return false;
      }
    } else if (!path.equals(temp.path)) {
      return false;
    }

    if (info == null) {
      if (temp.info != null) {
        return false;
      }
    } else if (!info.equals(temp.info)) {
      return false;
    }

    return true;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
