package recover;

/** 作者：王文彬 on 2019-04-25 15：12 邮箱：wwb199055@126.com */
public class Key {

  private Integer id;

  public Integer getId() {
    return id;
  }

  public Key(Integer id) {
    this.id = id;
  }

  public boolean equals(Object o) {
    if (this == null || !(o instanceof Key)) {
      return false;
    } else {
      return this.getId().equals(((Key) o).getId());
    }
  }

  public int hashCode() {
    return id.hashCode();
  }
}
