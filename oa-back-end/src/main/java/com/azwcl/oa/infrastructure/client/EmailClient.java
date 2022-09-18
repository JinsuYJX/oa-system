package com.azwcl.oa.infrastructure.client;

import com.azwcl.oa.infrastructure.config.MailConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 邮件客户端
 *
 * @author az
 * @date 2022/09/09
 */
@Component
@Getter
@Setter
@ToString
public class EmailClient {

    private final MimeMessage message;

    public EmailClient(MailConfig mailConfig) throws MessagingException, UnsupportedEncodingException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", mailConfig.getHost());
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailConfig.getUsername(), mailConfig.getPassword());
            }
        });
        this.message = new MimeMessage(session);
        this.message.setFrom(new InternetAddress(mailConfig.getUsername(), mailConfig.getFrom()));
    }

    /**
     * 发送简单邮件
     *
     * @param to 收件者邮箱
     * @param subject 主题
     * @param message 收件信息
     */
    public void sendSimpleMail(String to, String subject, String message) throws MessagingException {
        this.message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        this.message.setSubject(subject);
        this.message.setText(message);

        Transport.send(this.message);
    }
}
