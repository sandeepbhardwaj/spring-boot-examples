package com.koko.springboot.model;

public class ProfileConfiguration {

	private String profileName;

	public ProfileConfiguration(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileName() {
		return profileName;
	}

	@Override
	public String toString() {
		return "ProfileConfiguration [profileName=" + profileName + "]";
	}

}
