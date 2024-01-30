package amaraj.sendemail.service;

public interface EmailSenderService {

    void sendEmail(String to, String subject, String message);

    String sendEmailWithAttachment(String to, String subject, String messag);
}
