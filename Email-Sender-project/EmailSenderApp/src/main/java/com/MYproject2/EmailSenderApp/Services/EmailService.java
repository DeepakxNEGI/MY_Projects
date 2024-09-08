package com.MYproject2.EmailSenderApp.Services;

import com.MYproject2.EmailSenderApp.api.Message;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface EmailService {
    //for single person
    void sendEmail(String to, String subject, String message);

    //send mail for multiple person
    void sendmail(String[] to, String subject, String message);
    //send mail with html

    void sendEmailWithHtml(String to, String subject, String htmlContent);

    //send mail with file

    void sendEmailWithFile(String to, String subject, String message , File file);
    void sendEmailWithFile(String to, String subject, String message , InputStream is);

 List<Message> getInboxMessages();

}



