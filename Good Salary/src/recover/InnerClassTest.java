package recover;

/** 作者：王文彬 on 2019-05-05 10：16 邮箱：wwb199055@126.com */
public class InnerClassTest {
  // 抽象类，模拟一些组件的基类
  abstract static class Component {

    final void create() {
      onCreate();
    }

    final void destroy() {
      onDestroy();
    }

    // 子类实现，模拟组件创建的过程
    abstract void onCreate();

    // 子类实现，模拟组件摧毁的过程
    abstract void onDestroy();
  }

  // 具体某个组件
  static class MyComponent extends Component {
    // 组件中窗口的单击事件监听器
    OnClickListener clickListener;
    // 模拟组件中的窗口
    MyWindow myWindow;

    @Override
    void onCreate() {
      // 执行组件内一些资源初始化的代码
      clickListener =
              new OnClickListener() {
                @Override
                public void onClick(Object obj) {
                  System.out.println("对象 " + obj + " 被单击");
                }
              };
      // 新建我的窗口对象，并设置其单击事件监听器
      myWindow = new MyWindow();
      myWindow.setClickListener(clickListener);
    }

    @Override
    void onDestroy() {
      // 执行组件内一些资源回收的代码
      myWindow.removeClickListener();
    }
  }

  // 我的窗口类，模拟一个可视化控件
  static class MyWindow {
    OnClickListener clickListener;

    // 设置当前控件的单击事件监听器
    void setClickListener(OnClickListener clickListener) {
      this.clickListener = clickListener;
    }

    // 移除当前控件的单击事件监听器
    void removeClickListener() {
      this.clickListener = null;
    }
  }

  // 对象的单击事件的监听接口
  public interface OnClickListener {
    void onClick(Object obj);
  }

  public static void main(String[] args) {
    MyComponent myComponent = new MyComponent();
    myComponent.create();
    myComponent.destroy();
    // myComponent 引用置为 null，排除它的干扰
    myComponent = null;
    // 调用 JVM 的垃圾回收动作，回收无用对象
    System.gc();

    System.out.println("aaaa");
  }
}
