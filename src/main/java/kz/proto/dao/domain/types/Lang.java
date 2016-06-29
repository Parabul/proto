package kz.proto.dao.domain.types;

import java.util.Locale;

public enum Lang {
	RU("ru_RU", "ru"), EN("en_US", "en"), KZ("kk_KZ", "kk");

	private String locale;
	private String lang;

	Lang(String locale, String lang) {
		this.locale = locale;
		this.lang = lang;
	}

	public Locale getLocale() {
		return new Locale(locale);
	}

	public String getLocaleTag() {
		return locale;
	}

	public String getLang() {
		return lang;
	}

}
