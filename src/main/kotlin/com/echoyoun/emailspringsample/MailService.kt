package com.echoyoun.emailspringsample

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine

@Service
class MailService(
    private val javaMailSender: JavaMailSender,
    private val templateEngine: SpringTemplateEngine
) {
    fun sendMail(
        mailVo: MailVo
    ) {
        val mimeMessage = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(mimeMessage, true, "UTF-8")
        helper.setFrom("noreply@tmdwo07278.cafe24.com")
            helper.setTo(mailVo.receiver)
        helper.setSubject(mailVo.title)

        val context = Context().apply {
            setVariable("username", "윤승재")
        }

        val html = templateEngine.process("mail-template/verify", context)

        val message = SimpleMailMessage().apply {
            setTo(mailVo.receiver)
            from = "victoryjay727@gmail.com"
            subject = mailVo.title
            text = html
        }

        mimeMessage.setText(html, "UTF-8", "html")

        javaMailSender.send(mimeMessage)
    }
}