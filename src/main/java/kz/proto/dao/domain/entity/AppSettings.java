package kz.proto.dao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AppSettings {

	@Id
	@SequenceGenerator(name = "GL_APP_SETTINGS_ID_GENERATOR", sequenceName = "GL_APP_SETTINGS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GL_APP_SETTINGS_ID_GENERATOR")
	private Integer id;

	@Column(length = 512)
	private String emailFrom;
	@Column(length = 512)
	private String emailPassword;
	@Column(length = 512)
	private String emailSmtpUrl;
	@Column(length = 512)
	private String emailSmtpPort;

	@Column(length = 512)
	private String emailMessage;

	@Column(length = 512)
	private String emailSubject;

	@Column
	private String siteDomain;

	@Column(length = 512)
	private String code;

	public AppSettings() {

	}

	public void populate(AppSettings in) {
		this.emailFrom = in.emailFrom;
		this.emailPassword = in.emailPassword;
		this.emailSmtpUrl = in.emailSmtpUrl;
		this.emailSmtpPort = in.emailSmtpPort;
		this.emailMessage = in.emailMessage;
		this.emailSubject = in.emailSubject;
		this.siteDomain = in.siteDomain;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getEmailSmtpUrl() {
		return emailSmtpUrl;
	}

	public void setEmailSmtpUrl(String emailSmtpUrl) {
		this.emailSmtpUrl = emailSmtpUrl;
	}

	public String getEmailSmtpPort() {
		return emailSmtpPort;
	}

	public void setEmailSmtpPort(String emailSmtpPort) {
		this.emailSmtpPort = emailSmtpPort;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format(
				"AppSettings [id=%s, emailFrom=%s, emailPassword=%s, emailSmtpUrl=%s, emailSmtpPort=%s, emailMessage=%s, emailSubject=%s, code=%s]", id,
				emailFrom, emailPassword, emailSmtpUrl, emailSmtpPort, emailMessage, emailSubject, code);
	}

	public String getSiteDomain() {
		return siteDomain;
	}

	public void setSiteDomain(String siteDomain) {
		this.siteDomain = siteDomain;
	}

}
