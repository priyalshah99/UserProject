package com.UserProject.response;

import com.UserProject.models.UserModel;

public class UserResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String countryCode;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public static UserResponse build(final UserModel userModel){
        UserResponse response = new UserResponse();

        response.setId(userModel.getUserId());
        response.setContact(userModel.getContact());
        response.setCountryCode(userModel.getCountryCode());
        response.setEmail(userModel.getEmail());
        response.setFirstName(userModel.getFirstName());
        response.setLastName(userModel.getLastName());
        return response;
    }
}
