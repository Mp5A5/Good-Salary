package lock;

/** 作者：王文彬 on 2019-08-20 23：43 邮箱：wwb199055@126.com */
public class Lock {

  public static synchronized void print() {
    System.out.println("method synchronized");
  }

  public static void print2() {
    synchronized (Lock.class) {
      System.out.println("synchronized");
    }
  }

  public static void main(String[] args) {
    Lock.print();
    Lock.print2();
  }
}


    /*public static synchronized void print();
    descriptor: ()V
            flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
            Code:
            stack=2, locals=0, args_size=0
            0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
            3: ldc           #3                  // String method synchronized
            5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
            8: return


public static void print2();
        descriptor: ()V
        flags: ACC_PUBLIC, ACC_STATIC
        Code:
        stack=2, locals=2, args_size=0
        0: ldc           #5                  // class lock/Lock
        2: dup
        3: astore_0
        4: monitorenter
        5: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        8: ldc           #6                  // String synchronized
        10: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        13: aload_0
        14: monitorexit
        15: goto          23
        18: astore_1
        19: aload_0
        20: monitorexit
        21: aload_1
        22: athrow
        23: return
        Exception table:
        from    to  target type*/
