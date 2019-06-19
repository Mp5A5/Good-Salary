package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** 作者：王文彬 on 2019-05-21 18：10 邮箱：wwb199055@126.com */
public class Animal {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Animal : name = " + name + " age = " + age;
  }

}
