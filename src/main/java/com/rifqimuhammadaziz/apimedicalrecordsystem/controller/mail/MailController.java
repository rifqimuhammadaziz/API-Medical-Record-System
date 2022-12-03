package com.rifqimuhammadaziz.apimedicalrecordsystem.controller.mail;

import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/send")
    public String sendEmailTest() {
        mailService.sendMailTest();
        log.info("[][EMAIL SUCCESSFULLY SENT]");
        return "Success";
    }
}
