package com.demo.myapp.autowirebyconstructor;

public class Developer {
	private Language language;

	public Developer(Language language) {
		this.language = language;
	}

	// getter
	public Language getLanguage() {
		return language;
	}

	// setter
	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Developer [language=" + language + "]";
	}

}
