package gov.irrigation.service.impl;

import gov.irrigation.model.Plot;
import gov.irrigation.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private int mailPort;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Value("${alert.recipient.email}")
    private String alertRecipientEmail;

    @Autowired
    public AlertServiceImpl() {
        this.mailSender = createMailSender();
    }

    @Override
    public void sendSensorNotAvailableAlert(Plot plot) {
        String subject = "Sensor Not Available Alert";
        String message = "The sensor is not available for the plot with ID: " + plot.getId();
        sendEmailAlert(subject, message);
    }

    @Override
    public void sendRetryExceededAlert(Plot plot) {
        String subject = "Retry Exceeded Alert";
        String message = "The retry limit has been exceeded for the plot with ID: " + plot.getId();
        sendEmailAlert(subject, message);
    }

    private void sendEmailAlert(String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setTo(alertRecipientEmail);

        mailSender.send(mailMessage);
    }

    private JavaMailSender createMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);
        mailSender.setUsername(mailUsername);
        mailSender.setPassword(mailPassword);

        return mailSender;
    }
}
