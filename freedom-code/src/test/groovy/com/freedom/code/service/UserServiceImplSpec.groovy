package com.freedom.code.service

import com.freedom.code.annotation.CodeBootTest
import com.freedom.common.entity.UserDO
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

/**
 * @description * @author tobebetter9527* @create 2021/02/16 12:51
 */
@CodeBootTest
class UserServiceImplSpec extends Specification {
    @Autowired
    private UserService userService;

    def "getById"() {
        //sleep(165453646464546)
        when: 'start'
        UserDO userDO = userService.getById(id)

        then: 'assert'
        userDO != null

        and: 'set value'
        def value = userDO.id

        expect: 'expect'
        value == expectedResult

        where: 'sucess'
        id                   || expectedResult
        1345368146133819649L || 1345368146133819649L
    }

    def "selectById"() {
        when: 'start'
        UserDO userDO = userService.selectById(id)

        then: 'assert'
        userDO != null

        and: 'set value'
        def value = userDO.id

        expect: 'expect'
        value == expectedResult

        where: 'sucess'
        id                   || expectedResult
        1345368146133819649L || 1345368146133819649L
    }


}
