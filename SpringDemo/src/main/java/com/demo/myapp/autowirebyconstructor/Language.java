package com.demo.myapp.autowirebyconstructor;

public class Language {
	private String language;

	// getter
	public String getLanguage() {
		return language;
	}

	// setter
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Language [language=" + language + "]";
	}

}
