package com.echoyoun.emailspringsample

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailService(
    private val javaMailSender: JavaMailSender
) {
    fun sendMail(
        mailVo: MailVo
    ) {
        val message = SimpleMailMessage().apply {
            setTo(mailVo.receiver)
            from = "victoryjay727@gmail.com"
            subject = mailVo.title
            text = mailVo.content
        }

        javaMailSender.send(message)
    }
}