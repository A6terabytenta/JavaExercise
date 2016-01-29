package com.demo.myapp.autowirebytype;

public class Ability {
	private String skill;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Ability [skill=" + skill + "]";
	}

}
