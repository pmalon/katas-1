package com.phorest.katas

import org.junit.Rule
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Specification

class SmsMessageSenderTest extends Specification {

    @Rule
    OutputCapture capture = new OutputCapture()

    SmsMessageSender sender = new SmsMessageSender()

    def "should send sms"() {
        when:
        sender.send(address, message)

        then:
        capture.toString() == "Sending sms message: ${message} to address: ${address}\n" as String

        where:
        address               | message
        "someone@phorest.com" | "hello"
    }
}
