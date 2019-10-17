package recover;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 作者：王文彬 on 2019-05-07 14：49 邮箱：wwb199055@126.com */
public class Java_07_01_Type {



    public  void main(String[] args) throws IOException, ClassNotFoundException {
        // 反推如下
        List<? super Fruit> list = null;
        list = getFoods();
        // list.addAll(getFoods()); // 此处报错，编译不通过，原因是如果这个通过，那么下面这句话也该通过
        //list.addAll(getFruits()); // 如果这两个都通过，则说明List中含有Food、Fruit两个实例，从而违背了本文第一句话。
        // <? extends Fruit> 同理
        list.set(0,new Appel());
        list.add(new Appel());
        list.add(new pp());
        list.add(new Fruit());

    }

    class Food{

    }
    class Fruit extends Food{

    }
    class Appel extends Fruit{

    }

    class pp extends Appel{

    }

    public static ArrayList<Food> getFoods(){
        return new ArrayList<Food>();
    }
    public static ArrayList<Fruit> getFruits(){
        return new ArrayList<Fruit>();
    }
    public static ArrayList<Appel> getApple(){
        return new ArrayList<Appel>();
    }
}
