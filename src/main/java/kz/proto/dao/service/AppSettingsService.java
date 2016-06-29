package kz.proto.dao.service;

import kz.proto.dao.domain.entity.AppSettings;
import kz.proto.dao.repository.AppSettingsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppSettingsService {

	private static final Logger logger = LoggerFactory.getLogger(AppSettingsService.class);

	@Autowired
	private AppSettingsRepository settingsRepository;

	@Value("${email.from}")
	private String fromEmail;

	@Value("${email.password}")
	private String fromPassword;

	@Value("${email.smtp.url}")
	private String smtpUrl;

	@Value("${email.smtp.port}")
	private String smtpPort;

	@Value("${email.message}")
	private String emailMessage;

	@Value("${email.subject}")
	private String emailSubject;
	
	@Value("${site.domain}")
	private String siteDomain;

	@Transactional
	public AppSettings getSettings() {
		logger.debug("getSettings");
		AppSettings settings = settingsRepository.findByCode(AppSettingsRepository.general);
		if (settings == null) {
			settings = getDefault();
		}
		logger.debug("getSettings " + settings.toString());
		return settings;
	}

	@Transactional
	public AppSettings save(AppSettings in) {
		logger.debug("save " + in.toString());
		AppSettings settings = settingsRepository.findByCode(AppSettingsRepository.general);
		settings.populate(in);
		return settingsRepository.save(settings);
	}

	@Transactional
	private AppSettings getDefault() {
		AppSettings settings = new AppSettings();
		settings.setCode(AppSettingsRepository.general);
		settings.setEmailFrom(fromEmail);
		settings.setEmailMessage(emailMessage);
		settings.setEmailPassword(fromPassword);
		settings.setEmailSmtpPort(smtpPort);
		settings.setEmailSmtpUrl(smtpUrl);
		settings.setEmailSubject(emailSubject);
		settings.setSiteDomain(siteDomain);
		return settingsRepository.save(settings);
	}
}
