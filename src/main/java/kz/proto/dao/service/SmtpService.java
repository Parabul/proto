package kz.proto.dao.service;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import kz.proto.dao.domain.entity.AppSettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmtpService {

	private static final Logger logger = LoggerFactory.getLogger(SmtpService.class);

	@Autowired
	private AppSettingsService settingsService;

	private Properties properties;

	private AppSettings settings;

	@PostConstruct
	public void init() {
		settings = settingsService.getSettings();
		properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", settings.getEmailSmtpUrl());
		properties.put("mail.smtp.port", settings.getEmailSmtpPort());
	}

	public void send(String to, String subject, String body) {
		final String username = settings.getEmailFrom();
		final String password = settings.getEmailPassword();

		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(settings.getEmailFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

			logger.info("Send message done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
