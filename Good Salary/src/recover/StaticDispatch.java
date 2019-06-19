package recover;

/**
 * 作者：王文彬 on 2019-05-16 17：50
 * 邮箱：wwb199055@126.com
 */
public class StaticDispatch {
    static abstract class Human {}

    static class Man extends Human{}

    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello, guy");
    }
    public void sayHello(Man guy) {
        System.out.println("hello, gentleman");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello, lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);//hello, guy
        sr.sayHello(woman);//hello, guy
    }
}



