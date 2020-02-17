package com.java.javatr;


import lombok.AllArgsConstructor;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailSender{


    private final JavaMailSender javaMailSender;


    public void sendEmail( String message, String title, String receiver ) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo( receiver );

        msg.setSubject( title );
        msg.setText( message );

        javaMailSender.send( msg );

    }


}
