package kt.clazz

import org.junit.jupiter.api.Test

/**
 * 作者：王文彬 on 2019/10/30 19：32
 * 邮箱：wwb199055@126.com
 */

/**
 * 类委托:类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。
 */
interface Base {
    fun print()
}

class BaseImpl(private val x: Int) : Base {

    override fun print() = print(x)

}

class Derived(b: Base) : Base by b

class Test {

    @Test
    fun test() {
        val b = BaseImpl(10)
        Derived(b).print()
    }
}