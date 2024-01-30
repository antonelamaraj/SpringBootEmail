package amaraj.sendemail.service.impl;

import amaraj.sendemail.service.EmailSenderService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {


  private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("marajantonela09@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
    }

    @Override
    public String sendEmailWithAttachment(String to, String subject, String message) {
        try {
            MimeMessage messageMim = mailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(messageMim, true);
            messageHelper.setFrom("marajantonela09@gmail.com");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(message);

            File file = new File("C:\\Users\\admin\\OneDrive\\Desktop\\hello.txt");
            messageHelper.addAttachment(file.getName(), file);
            mailSender.send(messageMim);
            return "Mail sent succesfulluy";
        } catch (Exception e) {

            return "Mail sent failed!";
        }
    }
}
