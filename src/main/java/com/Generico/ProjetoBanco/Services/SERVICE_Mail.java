package com.Generico.ProjetoBanco.Services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SERVICE_Mail {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public String enviarEmail(String destinatario, String mensagem, String assunto) throws RuntimeException{
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setText(mensagem);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            javaMailSender.send(simpleMailMessage);

            return "Cheque seu email!";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Email Error");
    }

}
