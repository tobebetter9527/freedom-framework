package com.freedom.code.service

import com.freedom.code.annotation.CodeBootTest
import groovy.sql.Sql
import spock.lang.FailsWith
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Timeout
import spock.lang.Unroll

/**
 * @description * @author tobebetter9527* @create 2021/02/16 12:51
 */
@CodeBootTest
class MyServiceSpec extends Specification {
    // 与setup中等价
    User user

    @Unroll
    def "test 1 #user  name is  #user.name "() {
        when: "set value"
        user.setName("测试方法")

        then:
        verifyAll(user, User.class) {
            name == "sadfd"
            1 == 2
        }
        println("test01:" + user)

        where:
        user << [new User(id: 12, name: "你好", age: 24)]
    }

    def match(user) {
        user.getName() == "测试方法1"
    }

    @Unroll
    def "maximum of #a and #b is #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 4
        0 | 0 || 1
    }

    @Shared
    def sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a = 3
        b = Math.random() * 100
        c = a > b ? a : b

    }
}
