package recover;

/** 作者：王文彬 on 2019-05-06 10：43 邮箱：wwb199055@126.com */
public interface java_06_01_interface {

  String mName = "王";

  void open();

  default String name() {
    return mName;
  }

  static String getName(){
    return mName;
  }
}
