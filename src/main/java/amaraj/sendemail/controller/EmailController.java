package amaraj.sendemail.controller;

import amaraj.sendemail.resource.EmailMessage;
import amaraj.sendemail.service.EmailSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-mail")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/sendEmailWithAttachment")
    public String sendEmailWithAttachment(@RequestBody EmailMessage emailMessage){
        return emailSenderService.sendEmailWithAttachment(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
    }
}
