package com.mp5a5.www.salary;

/**
 * @author ：mp5a5 on 2019-05-11 11：47
 * @describe
 * @email：wwb199055@126.com
 */
public class Test {

    @org.junit.Test
    public void execute() {
        final int s = 10;

        class InnerClass {


            public void run() {

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.currentThread().sleep(10);
                            System.out.println(s);
                        } catch (final Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        }

        new InnerClass().run();
        System.out.println("住方法已经Over啦！");
    }
}
