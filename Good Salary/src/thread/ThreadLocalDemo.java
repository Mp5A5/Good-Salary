package thread;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 作者：王文彬 on 2019/9/4 22：03 邮箱：wwb199055@126.com */
public class ThreadLocalDemo {

  private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
  private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
  private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>();
  private static final int THREAD_LOOP_SIZE = 2;

  public static void main(String[] args) {
    /*SimpleThreadLocal<List<String>> threadLocal = new SimpleThreadLocal<>();
    new Thread(
            () -> {
              List<String> params = new ArrayList<>(3);
              params.add("张三");
              params.add("李四");
              params.add("王五");
              threadLocal.set(params);
              System.out.println(Thread.currentThread().getName());
              ((List<String>) threadLocal.get()).forEach(param -> System.out.println(param));
            })
        .start();
    new Thread(
            () -> {
              try {
                Thread.sleep(1000);
                List<String> params = new ArrayList<>(2);
                params.add("Chinese");
                params.add("English");
                threadLocal.set(params);
                System.out.println(Thread.currentThread().getName());
                ((List<String>) threadLocal.get()).forEach(param -> System.out.println(param));
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();*/

    /** 三个ThreadLocal */
    long l1 = (long) ((1L << 31) * (Math.sqrt(5) - 1));
    System.out.println("as 32 bit unsigned: " + l1);
    int i1 = (int) l1;
    System.out.println("as 32 bit signed: " + i1);
    System.out.println("MAGIC = " + 0x61c88647);

    /*// 线程池变量指定一个线程
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

    for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
      executorService.execute(
          () -> {
            threadLocal1.set("123");
            threadLocal2.set("234");
            threadLocal3.set("345");
            Thread t = Thread.currentThread();
            System.out.println(t.getName());
          });
    }*/
  }

  static class SimpleThreadLocal<T> {

    /** Key为线程对象，Value为传入的值对象 */
    private static Map<Thread, Object> valueMap = Collections.synchronizedMap(new HashMap<>());

    /**
     * 设值
     *
     * @param value Map键值对的value
     */
    public void set(Object value) {
      valueMap.put(Thread.currentThread(), value);
    }

    /**
     * 取值
     *
     * @return
     */
    public Object get() {
      Thread currentThread = Thread.currentThread();
      // 返回当前线程对应的变量
      Object t = valueMap.get(currentThread);
      // 如果当前线程在Map中不存在，则将当前线程存储到Map中
      if (t == null && !valueMap.containsKey(currentThread)) {
        t = initialValue();
        valueMap.put(currentThread, t);
      }
      return t;
    }

    public void remove() {
      valueMap.remove(Thread.currentThread());
    }

    public Object initialValue() {
      return null;
    }
  }
}
