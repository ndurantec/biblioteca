package com.escola.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.escola.biblioteca.modelo.EmailDetails;


public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendMail(EmailDetails emailDetails) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(sender);
        message.setTo(emailDetails.getTo());
        message.setSubject(emailDetails.getSubject());
        message.setText(emailDetails.getBody());

        javaMailSender.send(message);
        return "Email enviado com sucesso";

    }

    /*
    public String sendMailWithAttachment(EmailDetails emailDetails) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(sender);
        helper.setTo(emailDetails.getTo());
        helper.setSubject(emailDetails.getSubject());
        helper.setText(emailDetails.getBody());

        FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(mimeMessage);
        return "Mail Sent Successfully...";
    }
        */

}
