package com.java.javatr;


import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
public class AspectStudentError {

    private final Environment environment;
    private final EmailSender emailSender;

    @AfterThrowing(value = "execution( * getStudent(..))", throwing = "ex")

    public void sendmail( StudentNotFoundException ex ) {


        String mailto = environment.getProperty( "mailto" );// mailin kime gönderileceği


        String format = String.format
                ( "%s isimli öğrenci bulunamadı bu sebeple size bir bilgilendirme maili yolladık", ex.studentname );

        emailSender.sendEmail( format, ex.message, mailto );

    }
}
