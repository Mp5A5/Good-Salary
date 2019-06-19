package recover;

import java.io.Serializable;

/** 作者：王文彬 on 2019-05-10 16：36 邮箱：wwb199055@126.com */
public class Person implements Serializable {
  private static final long serialVersionUID = 12345678900L;
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return "Person: " + id + " " + name;
  }
}
