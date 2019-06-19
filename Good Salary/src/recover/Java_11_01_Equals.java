package recover;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：王文彬 on 2019-05-16 13：41
 * 邮箱：wwb199055@126.com
 */
public class Java_11_01_Equals {

    private String name;
    private int age;

    public Java_11_01_Equals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object anObject) {

        if (this == null || !(anObject instanceof Java_11_01_Equals)) {
            return false;
        } else {
            return this.getName().equals(((Java_11_01_Equals) anObject).getName());
        }
    }

    @Override
    public int hashCode() {
        return getAge();
    }



    @Test
    public void test(){
        Map<String,Java_11_01_Equals> map = new HashMap<>();
        Java_11_01_Equals a = new Java_11_01_Equals("mp5a5",28);
        Java_11_01_Equals b = new Java_11_01_Equals("mp5a",28);
        map.put("w",a);

    }


}
