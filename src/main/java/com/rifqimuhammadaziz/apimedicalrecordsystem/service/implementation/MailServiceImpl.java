package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String email;

    @Override
    public void sendMailTest() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setFrom(email);
            helper.setTo("arifqi48@gmail.com");
            helper.setSubject("Test Email Verification");
            helper.setText("Hello, this is an email testing from RPLD Research");

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
