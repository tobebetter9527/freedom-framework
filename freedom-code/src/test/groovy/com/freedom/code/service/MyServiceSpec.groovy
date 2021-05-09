package com.freedom.code.service

import com.freedom.code.annotation.CodeBootTest
import spock.lang.Specification

/**
 * @description * @author tobebetter9527* @create 2021/02/16 12:51
 */
@CodeBootTest
class MyServiceSpec extends Specification {

    def "表达式测试，表达式左右对象方法,数组表示测试数据"() {
        expect:
        name.size() == length
        where:
        name << ["fjdslj", "fds"]
        length << [6, 3]
    }
}
