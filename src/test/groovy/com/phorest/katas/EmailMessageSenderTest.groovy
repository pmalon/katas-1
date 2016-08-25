package com.phorest.katas

import org.junit.Rule
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Specification

class EmailMessageSenderTest extends Specification {

    @Rule
    OutputCapture capture = new OutputCapture()

    EmailMessageSender sender = new EmailMessageSender()

    def "should send email"() {
        when:
        sender.send(address, message)

        then:
        capture.toString() == "Sending email message: ${message} to address: ${address}\n" as String

        where:
        address               | message
        "someone@phorest.com" | "hello"
    }
}
