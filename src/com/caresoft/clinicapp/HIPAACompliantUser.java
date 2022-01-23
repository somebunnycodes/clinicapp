package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	
	public boolean assignPin(int pin);
	
	public boolean accessAuthorized(Integer ConfirmedAuthID);

	
}
