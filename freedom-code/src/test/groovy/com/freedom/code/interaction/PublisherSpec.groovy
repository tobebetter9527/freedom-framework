package com.freedom.code.interaction

import com.freedom.code.annotation.CodeBootTest
import org.junit.Ignore
import org.spockframework.mock.IMockObject
import org.spockframework.mock.MockNature
import org.spockframework.mock.MockUtil
import org.spockframework.spring.ScanScopedBeans
import spock.lang.Retry
import spock.lang.Specification

/**
 * @description * @author tobebetter9527* @create 2021/02/16 12:51
 */
@ScanScopedBeans
//@CodeBootTest
class PublisherSpec extends Specification {
    Publisher publisher = new Publisher()
    Subscriber subscriber = Stub()
    Subscriber subscriber2 = Stub()

    def setup() {
        publisher.subscribers << subscriber // << is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2 // Groovy List.add()的简写方式
    }

    def "should send messages to all subscribers"() {
        subscriber.receive("message1") >> "ok"
        subscriber.receive("message2") >> "fail"

        when:
        publisher.send(msg)

        then:
        def receive = subscriber.receive(msg)
        println(receive)
        def person = Mock(name: "Fred", type: Person, defaultResponse: ZeroOrNullResponse, verified: false)

        where:
        msg        | _
        "message1" | _
        "message2" | _
    }

    def "test01"() {
        given:
        List list2 = Mock()
        IMockObject mock = MockUtil.asMock(list2)

        expect:
        mock.name == "list2"
        mock.type == List
    }

}
