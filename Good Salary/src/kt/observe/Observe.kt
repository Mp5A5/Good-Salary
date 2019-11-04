package kt.observe

import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

/**
 * 作者：王文彬 on 2019/10/30 19：54
 * 邮箱：wwb199055@126.com
 */

class User {
    var name: String by Delegates.observable("初始值") { property, oldValue, newValue ->
        println("旧值：$oldValue -> 新值：$newValue")
    }
}

class Test {

    @Test
    fun test() {
        val user = User()
        user.name = "第一次赋值"
        user.name = "第二次赋值"
    }
}

