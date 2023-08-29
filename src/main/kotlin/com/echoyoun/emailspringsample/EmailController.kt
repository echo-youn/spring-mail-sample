package com.echoyoun.emailspringsample

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class EmailController(
    private val mailService: MailService
) {
    @PostMapping("/mail")
    fun mailSend(
        @RequestBody
        mailVo: MailVo
    ): Unit {
        mailService.sendMail(mailVo)
    }
}