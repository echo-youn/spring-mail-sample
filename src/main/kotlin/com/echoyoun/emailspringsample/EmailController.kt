package com.echoyoun.emailspringsample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
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

    @GetMapping("/verify")
    fun verifyMail(): String {
        return "Verified!"
    }
}