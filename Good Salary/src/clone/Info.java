package clone;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class Info implements Cloneable {

  private int id;

  private String text;

  public Info(int id, String text) {

    this.id = id;

    this.text = text;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (obj.getClass() != getClass()) return false;
    Info temp = (Info) obj;
    if (id != temp.id) return false;
    if (text == null) {
      if (temp.text != null) {
        return false;
      }
    } else if (!text.equals(temp.text)) {
      return false;
    }

    return true;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
