package com.MYproject2.EmailSenderApp;

import com.MYproject2.EmailSenderApp.Services.EmailService;
import com.MYproject2.EmailSenderApp.api.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


@SpringBootTest
public class EmailSenderTest {
    @Autowired

    private EmailService emailService;
    @Test
    void emailSendTest(){
        System.out.println("sending email");
        emailService.sendEmail("deepaknegi7895@gmail.com","EMAIL FROM SPRING BOOT", "THIS EMAIL IS SENT USING SPRING BOOT USING EMAIL SERVICE");
    }
@Test
    void sendHtmlInEmail(){
        String html ="" +
                "<h1 style='color:red;border:1px'> MY name is Deepak Singh Negi </h1> "+"";
        emailService.sendEmailWithHtml("deepaknegi7895@gmail.com"
        ,"Email from spring boot",html);
    }

@Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("deepaknegi7895@gmail.com",
                "Email with file",
                "this email contains file",
                new File("D:\\MYproject\\EmailSenderApp\\src\\main\\resources\\static\\em-image.png")
                );

    }

    @Test
    void sendEmailWithStream(){
        File file = new File("D:\\MYproject\\EmailSenderApp\\src\\main\\resources\\static\\em-image.png");
        try {
            InputStream is =new FileInputStream(file);
            emailService.sendEmailWithFile("deepaknegi7895@gmail.com",
                    "Email with file",
                    "this email contains file",is
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
@Test
    //receiving email test
    void getInbox (){
        List<Message> inboxMessages = emailService.getInboxMessages();
        inboxMessages.forEach(item->{
            System.out.println(item.getSubjects());
            System.out.println(item.getContent());
            System.out.println(item.getFiles());
        });
    }
}
