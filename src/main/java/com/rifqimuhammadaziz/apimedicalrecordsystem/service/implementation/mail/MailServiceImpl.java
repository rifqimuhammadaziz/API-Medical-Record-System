package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation.mail;

import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.PatientDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.UserDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail.MailService;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail.ThymeleafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    ThymeleafService thymeleafService;

    private final String REGISTER_SUBJECT = "Registration - Medical Record System Xenosty Hospital";

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
            helper.setText(thymeleafService.createContent("mail-sender-test.html", null), true);
            helper.setTo("rifqimuhammadaziz@gmail.com");
            helper.setSubject("Test Email With HTML Template");

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMailCreateUser(UserDTO userDTO) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );

            helper.setTo(userDTO.getEmail());

            Object[] bccObject = userDTO.getMailCC().toArray();
            String[] bcc = Arrays.copyOf(bccObject, bccObject.length, String[].class);
            helper.setBcc(bcc);

            Map<String, Object> variables = new HashMap<>();
            variables.put("name", userDTO.getName());
            variables.put("email", userDTO.getEmail());
            variables.put("birthdate", userDTO.getBirthdate());
            variables.put("address", userDTO.getAddress());

            // Created Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            variables.put("date", dateFormat.format(new Date()));

            helper.setText(thymeleafService.createContent("mail/create-patient.html", variables), true);
            helper.setFrom(email);
            helper.setSubject(REGISTER_SUBJECT);

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
